package main;

import javax.swing.JOptionPane;
import ArbolSintactico.*;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.lang3.ArrayUtils;

public class Parser {
    
    //Declaración de variables
    Programax p = null;
    String[] tipo = null;
    String[] variable;
    private Vector tablaSimbolos = new Vector();
    private ArrayList<DToken> tablaTokens = new ArrayList<DToken>();
    private ArrayList<DSimbolos> ts = new ArrayList<DSimbolos>();
    private ArrayList<String> listIndiceBc = new ArrayList<>();
    private final Scanner s;
    final int classx=1, booleanx=2, intx=3, whilex=4, sopx=5, truex=6, falsex=7, igualx=8, menorx=9, 
            sumax=10, menosx=11, multx=12, puntocomx=13, llaveAbre=14, llaveCierra=15, parenAbre =16, parenCierra=17, 
            identx = 18, integerx=19;

    private int tknCode, tokenEsperado;
    private String token, tokenActual, log;
    
    //Contador de los tokens 
    static int countertoken;

    //Contador de los errores
    static int err; 
    
    //Sección de bytecode  --------------------------------
    private int cntBC = 0; // Contador de lineas para el código bytecode
    private String bc; // String temporal de bytecode
    private int jmp1, jmp2, jmp3;
    private int aux1, aux2, aux3;
    private String pilaBC[] = new String[100];
    private String memoriaBC[] = new String[10];
    private String pilaIns[] = new String [50];
    private int retornos[]= new int[10];
    private int cntIns = 0;
    //---------------------------------------------
    
    //Constructor del parser con el código
    public Parser(String codigo) {  
        
        //Inicializando contador de tokens y de errores
        countertoken = 0;
        err = 0;
        
        s = new Scanner(codigo);
        token = s.getToken(true);
        tknCode = stringToCode(token);
        p = P();
        //System.out.println(p.getIdentifier().getIdx()+" -- "+p.getDeclaration() + "- - " + p.getStatement());
        
        //Tras terminar compilacion
        if (err==0){
            System.out.println("\n BYTECODE: \n"+getBytecode());
            JOptionPane.showMessageDialog(null, "Compilación realizada completamente!");
            mandarTabla(); 
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(null, "Se presentaron errores durante la compilación", "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        
        }
        
        
    }
    
    
    //INICIO DE ANÁLISIS SINTÁCTICO
    public void advance() {
        token = s.getToken(true);
        tokenActual = s.getToken(false);
        tknCode = stringToCode(token);
    }
    
    //"eat" cada elemento y agregarlo a la list de tokens (Dtoken)"
    public void eat(int t) {
        tokenEsperado = t;
        if(tknCode == t) {
            countertoken++;
            
            tablaTokens.add(new DToken(countertoken, token, s.getTipoToken()));
            //System.out.println("Token "+ countertoken + ": " + token + " - - - -  - - " + "Tipo:  "+ s.getTipoToken());
            
            advance();
        }
        else{
            error(token, "un token de tipo "+ " ' "+CodeToString(t)+" ' ");
            err = 1;
        }
    }
    
    
    public Programax P() {
        
        Idx i;
        Declarax d;
        Statx s;
        
        eat(classx); 
        i=new Idx(token); eat(identx); 
        d = D();
        createTable(); //Crea la tabla de simbolos
        mandaSimbolos(); //Manda la t. de simbolos a la interfaz
        indiceByteCode(); //Obtiene los indices de las variables para la memoria de Bytecode
        eat(llaveAbre); 
        s = S();
        eat(llaveCierra);
        byteCode("return"); //Retornar el último bloque de bytecode (return)
        
        return new Programax(i, d, s);
          
    }
        
    //Sección que crea la declaracion de variables
    public Declarax D() {
      
       //Verificacion de Tipos (que sea int / boolean) 
       Typex t;
        if (tknCode == intx || tknCode == booleanx)
            t = T();
        else
            return null;
        
       //Verificacion de identificador 
      if(tknCode == identx) {
        if(stringToCode(s.getToken(false)) != intx || stringToCode(s.getToken(false)) != booleanx) {
          String identificador = token;
          //System.out.println(s);
          eat(identx); 
          eat(puntocomx); 
          tablaSimbolos.addElement(new Declarax(t,identificador));
          D();
          return new Declarax(t,identificador);
        }
        else{return null;}
      }

      else if(tknCode != identx){return null;}
      else{
        error(token, "(identificador)");
        err = 1;
        return null;
      }            
    }
    
    //Verificacionde tipos de datos
    public Typex T() {
        if(tknCode == intx) {
            eat(intx);
            return new Typex("int");
        }
        else if(tknCode == booleanx) {
            eat(booleanx);
            return new Typex("boolean");
        }
        else{
            error(token, "(int / boolean)");
            err = 1;
            return null;
        }
    }
    
    //Verificacion de operadores
    public Opx O() {
        switch (tknCode){
            
            case menorx: 
                eat(menorx);
                return new Opx("<");
                
            case sumax:
                eat(sumax);
                return new Opx("+");
                
            case menosx:
                eat(menosx);
                return new Opx("-");
                
            case multx:
                eat(multx);
                return new Opx("*");
                
            default: 
                error(token, "Operador (+ - * < )");
                err = 1;
                return null;     
        
        
        }
         
    }
    
    //Verificacion de Estatutos, regresa Statement
    public Statx S() { 

        switch(tknCode) {
            
            case whilex: 
                Expx e;
                Statx s1;
                eat(whilex); 
                eat(parenAbre); 
                e = E(); 
                String c = byteCode("while"); //Para el goto de bytecode y c=salto
                eat(parenCierra); 
                eat(llaveAbre); s1 =S(); eat(llaveCierra);
                byteCode(e);
                byteCode("menor", c);
                S();
                return new Whilex(e, s1);
          
            case sopx:
                Expx e1;
                eat(sopx); 
                eat(parenAbre);  
                e1=E();
                byteCode(e1);
                byteCode("sop");
                eat(parenCierra); 
                eat(puntocomx);
                S();
                
                return new Printx(e1);
            
            case identx: 
                Expx e2;
                Idx i1;
                declarationCheck(token); //
                i1=new Idx(token);
                eat(identx); 
                eat(igualx);
                e2 = E();
                byteCode(e2);
                byteCode("identificador", i1.getIdx()); 
                eat(puntocomx);
                S();
                checarCompatibilidadAsign(i1.getIdx(), e2);
                
                return new Asignax(i1, e2);
                     
            default: 
                if (tknCode!= whilex ||tknCode!= sopx || tknCode!= identx )
                    return null;
                else { 
                error(token, "( while | sop | identificador = expresión )");
                err = 1;
                return null; }
        }
    }
    
    //Validar si el token es un entero (Integer)
    public boolean esInteger(String s) {
        boolean n;
        try {
        Integer.parseInt(s);
        n = true;
        }           
        catch(Exception e) {
            n = false;
                   }
        return n;
        }
    
    //Verificacion de expresiones
    public Expx E() {
        
        //Validar primeramente si es un número Integer la expresion
        if (esInteger(token)) {
            int num;
            num = Integer.parseInt(token);
            //System.out.println("---"+num);
            eat(identx);
            return new Numx(num);
            }
        
           switch(tknCode) {
                   
               case truex:
                   eat(truex); 
                   return new TrueFalsex(true);
               
               case falsex:
                   eat(falsex);
                   return new TrueFalsex(false);
                   
               case identx:
                   String i1, i2; 
                   Opx op;
                   i1 = token;
                   declarationCheck(token); 
                   eat(identx);
                   if(tknCode == menorx || tknCode == sumax || tknCode == menosx || tknCode == multx ) {
                       op = O();
                       i2 = token;
                       declarationCheck(token); 
                       checarCompatibilidad(i1, i2);
                       eat(identx); 
                       //System.out.println("---"+i1+"---"+i2);
                       return new Comparax(op, i1, i2);
                   }
                   else {
                   //System.out.println("---"+i1);
                   return new Idx(i1); 
                   }
      
               default: 
                   error(token, "(Expresión)");
                   err = 1;
                   return null;
           }
       }
        //FIN DEL ANÁLISIS SINTÁCTICO
    
    
    //Ver todos los tokens y regresa su código ligado.
    public int stringToCode(String t) {
        int codigo = 0;
        switch(t) {
            case "class": codigo=1; break;    
            case "boolean": codigo=2; break;
            case "int": codigo=3; break;
            case "while": codigo=4; break;
            case "System.out.println": codigo=5; break;
            case "true": codigo=6; break;
            case "false": codigo=7; break;
            case "=": codigo=8; break;
            case "<": codigo=9; break;
            case "+": codigo=10; break;
            case "-": codigo=11; break;
            case "*": codigo=12; break;
            case ";": codigo=13; break;
            case "{": codigo=14; break;
            case "}": codigo=15; break;
            case "(": codigo=16; break;
            case ")": codigo=17; break;     
            default: codigo=18; break;
        }
        return codigo;
    }
    
     //Ver el codigo (int) y retornar su token(String) ligado
    public String CodeToString(int i) {
        String str;
        switch(i) {
            case 1: str="class"; break;    
            case 2: str="boolean"; break;
            case 3: str="int"; break;
            case 4: str="while"; break;
            case 5: str="System.out.println"; break;
            case 6: str="true"; break;
            case 7: str="false"; break;
            case 8: str="="; break;
            case 9: str="<"; break;
            case 10: str="+"; break;
            case 11: str=";"; break;
            case 12: str="*"; break;
            case 13: str=";"; break;
            case 14: str="{"; break;
            case 15: str="}"; break;
            case 16: str="("; break;
            case 17: str=")"; break;   
            default: str="identificador"; break;
        }
        return str;
    }
    
    //En caso de que lance un error SINTACTICO
    public void error(String token, String t) {
        switch(JOptionPane.showConfirmDialog(null,
                "Error sintáctico:\n"
                        + "El token:("+ token + ") no concuerda con la gramática del lenguaje,\n"
                        + "se espera: " + t + "\n"
                        + "¿Desea terminar la aplicación?",
                "Ha ocurrido un error",
                JOptionPane.YES_NO_OPTION)) {
            case JOptionPane.NO_OPTION:
                err = 1;;
                break;
                
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
        }
    }
    
        
    //Metodo para mandar toda la lista de Tokens y sus datos al main
    public ArrayList<DToken> mandarTabla() {
        ArrayList<DToken> tt;
        tt = tablaTokens;
        return tt;
    }
    
    //Manda la tabla de símobolos a la tabla de la interfaz
    public ArrayList<DSimbolos> mandaSimbolos() {
        ArrayList<DSimbolos> tts;
        tts = ts;
        return tts;
    }
    
    //Informe de errores 
    public boolean informeErrores() {
    
        System.out.println("Hay errores: "+err);
        if (err==0)
            return false;
        else
            return true;
    }
   
    
    //SEGUNDA PARTE DEL PROYECTO (CONTINUACIÓN)
    
    //Recorrido de la parte izquierda del árbol y creación de la tabla de símbolos (EN CONSOLA)
    public void createTable() {
        
        variable = new String[tablaSimbolos.size()];
        tipo = new String[tablaSimbolos.size()];
        
        //Imprime tabla de símbolos
        System.out.println("-----------------");
        System.out.println("TABLA DE SÍMBOLOS");
        System.out.println("-----------------");
        for(int i=0; i<tablaSimbolos.size(); i++) {
            int no; 
            Declarax dx;
            Typex tx;
            
            no = i+1;
            dx = (Declarax)tablaSimbolos.get(i);
            variable[i] = dx.s2;
            tipo[i] = dx.s1.getTypex();
            
            ts.add(new DSimbolos(no, variable[i], tipo[i])); //Tabla DSimbolos para el Frame
            
            System.out.println(no+"   "+variable[i] + ": "+ tipo[i]); //Imprime tabla de símbolos por consola. 
        }
        
        ArrayUtils.reverse(variable);
        ArrayUtils.reverse(tipo);
        
        System.out.println("-----------------\n");
    }
    
   
    
    //Verifica las declaraciones de las variables consultando la tabla de símbolos
    public void declarationCheck(String s) {
        boolean valido = false;
        for (int i=0; i<tablaSimbolos.size(); i++) { //} 
            if(s.equals(variable[i])) {
                valido = true;
                break;
            }
        }
        if(!valido) {
            System.out.println("La varible "+ s +  " no está declarada.\nSe detuvo la ejecución.");
             javax.swing.JOptionPane.showMessageDialog(null, "La varible [" + s + "] no está declarada", "Error",
                   javax.swing.JOptionPane.ERROR_MESSAGE);
             err = 1;
        }
    }
    
    
    //Chequeo de tipos consultando la tabla de símbolos
    public void checarCompatibilidad(String s1, String s2) {
        
        Declarax elementoCompara1;
        Declarax elementoCompara2;
        String t1;
        String t2;
        System.out.println("CHECANDO COMPATIBILIDAD ENTRE TIPOS ("+s1+", "+s2+"). ");
        boolean termino = false;
        for(int i=0; i<tablaSimbolos.size() ; i++) {
          elementoCompara1 = (Declarax) tablaSimbolos.elementAt(i);
          if(s1.equals(elementoCompara1.s2)) {
            System.out.println("Se encontró el primer elemento en la tabla de símbolos...");
            //System.out.println(elementoCompara1.getTypex().getTypex());
            t1 = elementoCompara1.getTypex().getTypex();
            for(int j=0; j<tablaSimbolos.size() ; j++) {
              elementoCompara2 = (Declarax) tablaSimbolos.elementAt(j);
              //if (s2.equals("boolean")) {t2 = "boolean"; } if (s2.equals("int")) {t2 = "int";} 
              
              //Ver si el segundo elemento a comparar es un identificador, un boolean o un int
              if(s2.equals(elementoCompara2.s2) || (s2.equals("boolean")) || (s2.equals("int")) ) {
                int caso = 0;  
                System.out.println("Se encontró el segundo elemento en la tabla de símbolos...");
                if (s2 == "boolean") 
                { 
                    t2 = "boolean"; caso=1;
                }
                else if (s2 == "int") 
                {  
                    t2 = "int"; caso=2;
                }
                else {
                //System.out.println(elementoCompara2.getTypex().getTypex());
                t2 = elementoCompara2.getTypex().getTypex();
                caso=3; 
                }
                if(t1.equals(t2)) {
                  termino = true;
                  System.out.println("El tipo es: "+t1+ " El tipo t2 es: "+t2); 
                  break;
                }else{
                  termino = true;
                  if (caso==1) {
                  javax.swing.JOptionPane.showMessageDialog(null, "Incompatibilidad de tipos: "+ elementoCompara1.s2 +" ("
                      + elementoCompara1.s1.getTypex() + ") , True / False(boolean)", "Error",
                      javax.swing.JOptionPane.ERROR_MESSAGE);
                    err = 1;;  
                  } 
                  else if (caso==2) { 
                  javax.swing.JOptionPane.showMessageDialog(null, "Incompatibilidad de tipos: "+ elementoCompara1.s2 +" ("
                      + elementoCompara1.s1.getTypex() + ") , Numérico(int)", "Error",
                      javax.swing.JOptionPane.ERROR_MESSAGE);
                    err = 1; 
                  }
                  else 
                  {
                    javax.swing.JOptionPane.showMessageDialog(null, "Incompatibilidad de tipos: "+ elementoCompara1.s2 +" ("
                      + elementoCompara1.s1.getTypex() + ") , "+elementoCompara2.s2 +" (" + elementoCompara2.s1.getTypex()
                      +").", "Error",
                      javax.swing.JOptionPane.ERROR_MESSAGE);
                    err = 1; 
                  }
                }
                break;
              }
            }
          }
          if(termino) {
            break;
          }
        }
    }
    
    //Chequeo de tipos para la asignación ( Identificador = Expresion ) 
    public void checarCompatibilidadAsign(String s1, Expx e1) {
        
        String datoExp = e1.tipoDato();
        //System.out.println("DATO: - - - - - - - "+datoExp);
        System.out.println("");
        
        switch(datoExp) {   
            case "boolean":
                TrueFalsex x;
                x = (TrueFalsex) e1;
                //System.out.println(x.getTrueFalsex());
                
                checarCompatibilidad(s1, "boolean");
                
                break;
                
            case "int":
                Numx y;
                y = (Numx) e1;
                //System.out.println(y.getNum());
                
                checarCompatibilidad(s1, "int");
                break;
                
            case "id" :
                Idx z;
                z = (Idx) e1;
                
                String id = e1.getString();
                checarCompatibilidad(s1, id);
                break;
                
            case "compara":
                String[] ids = e1.getString().split(" ");
                String id1 = ids[0];
                String id2 = ids[1];
                
                checarCompatibilidad(s1, id1);
                checarCompatibilidad(s1, id2);
                break;
                
            default: 
                break;
        } 
    }
    
    //Indice de memoria para cada variable en Bytecode
    public void indiceByteCode(){
        Declarax dx;

        for(int i=0; i<tablaSimbolos.size(); i++){
            dx = (Declarax)tablaSimbolos.get(i);
            variable[i] = dx.s2;
            //sub = Integer.toString(i);

            listIndiceBc.add(variable[i]);
            }
        /*for(int j=0; j<listIndiceBc.size(); j++){
            System.out.println(j);
            System.out.println(listIndiceBc.get(j));
            System.out.println();
            
            }*/
        }
    
    
    //METODOS PARA LA GENERACION DE BYTECODE
    
    //Para Expresiones
    public void byteCode(Expx exp){
        
        String caso = exp.tipoDato();
        
        switch(caso) {
            case "id":
                Idx temp;
                temp = (Idx) exp; 
                String strId = temp.getIdx();
                
                for(int i=0; i<listIndiceBc.size(); i++){
                    if(strId.equals(listIndiceBc.get(i)))
                        ipbc(cntIns + ": iload_" + i);
                    
                    }
                jmp2 = cntBC;
            break;
            
            case "int":
                Numx temp1;
                temp1 = (Numx) exp;
                
                ipbc(cntIns + ": iconst_"+temp1.getNum());
                jmp1 = cntBC;  
            break;
            
            case "boolean":
                TrueFalsex temp2;
                temp2 = (TrueFalsex) exp;
                
                if (temp2.getTrueFalsex())
                    ipbc(cntIns + ": iconst_1");
                else
                    ipbc(cntIns + ": iconst_0");
                jmp1 = cntBC;
            break;
            
            case "compara":
                Comparax temp3;
                temp3 = (Comparax) exp;
                
                String opt = temp3.getOp().getOpx();
                String s1t = temp3.getS1();
                String s2t = temp3.getS2();
                
                for(int i=0; i<listIndiceBc.size(); i++){
                    if(s1t.equals(listIndiceBc.get(i)))
                        ipbc(cntIns + ": iload_" + i);
                    
                    }
                jmp2 = cntBC;
                
                for(int j=0; j<listIndiceBc.size(); j++){
                    if(s2t.equals(listIndiceBc.get(j)))
                        ipbc(cntIns + ": iload_" + j);
                    }
                jmp2 = cntBC;
                
                switch(opt){
                
                    case "+":
                        ipbc(cntIns + ": iadd");
                        jmp2 = cntBC;
                        break;
                        
                    case "-":
                        ipbc(cntIns + ": isub");
                        jmp2 = cntBC;
                        break;
                        
                    case "*":
                        ipbc(cntIns + ": imul");
                        jmp2 = cntBC;
                        break;
                        
                    case "<":
                        //ipbc(cntIns + ": if_cmplt");
                        //cntIns=cntIns+2;
                        //jmp2 = cntBC;
                        break;                    
                
                }
                jmp1 = cntBC;
            break; 
        }    
    }
      
    //P (Tipo de token, valor)
    public void byteCode(String tipo, String s1) {
        
        switch(tipo) {
            
            case "identificador":
                for(int i=0; i<listIndiceBc.size(); i++){
                    if(s1.equals(listIndiceBc.get(i)))
                        ipbc(cntIns + ": istore_" + i);
                    }
                jmp2 = cntBC;
            break;
            
            case "menor":
            String c = String.valueOf(cntIns-2);
            
            ipbc(cntIns + ": if_icmplt " + (s1));
            cntIns=cntIns+2;
            jmp1 = cntBC;
            //System.out.println(c);
          break;
        }
    }
    
    //Tipo
    public String byteCode(String tipo){
        
        switch(tipo) {
            
          case "while":
            ipbc(cntIns + ": goto" + " - - if_sentence");
            cntIns=cntIns+2;
            
            String c = String.valueOf(cntIns); 
            jmp2 = cntBC;
            return c;
            //break;    
            
        case "sop":
            ipbc (cntIns + ": getstatic <Field java.io.PrintStream out>" );
            cntIns=cntIns+2;
            ipbc ( cntIns + ": ldc <String >");
            cntIns=cntIns+1;
            ipbc (cntIns + ": invokevirtual  <Method void println(java.lang.String)>");
            cntIns=cntIns+2;
            jmp1 = cntBC;
            break;  
            
         case "return":
            ipbc(cntIns + ": return");
            jmp2 = cntBC;
            break;    
             
        }
        return null;
    }
    
    //Contador de instruccions de byteCode
    public void ipbc(String ins) {
        while(pilaBC[cntBC] != null) {
            cntBC++;
        }
        cntIns++;
        pilaBC[cntBC] = ins;
        cntBC++;
    }
    
    //Retorna todo el código Bytecode obtenido
    public String getBytecode() {
        String JBC = "";
        for(int i=0; i<pilaBC.length; i++) {
            if(pilaBC[i] != null){
                JBC = JBC + pilaBC[i] + "\n";
            }
        }
        return JBC;
    }   
}

