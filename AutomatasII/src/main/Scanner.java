
package main;

import javax.swing.JOptionPane;

public class Scanner {
    
//DECLARACIONES
    private int lineaNo, k;
    private final String[] tokens;
    private String tipoToken;
    private String token;
    private final String[] reservadas = {"class", "boolean", "int", "while", "System.out.println", "true", "false","public","private"};
    private final String[] operadores = {"=", "<", "+", "-", "*"};
    private final String[] delimitadores = {";", "{", "}", "(" , ")"};
    
//CONSTRUCTOR
    public Scanner(String codigo) {
        tokens = codigo.split("\\s+");
        lineaNo = 0; //Aun sin implementar...
        k=0;
        token = "";
    }
    
    //M脡TODO que retorna tokens v谩lidos al parser
    public String getToken(boolean b) {
        boolean tokenValido = false;
        token = tokens[k];
        if(b) {
            if(k < tokens.length-1) {
            k++;
            }
        }
                
        //VERIFICACI脫N L脡XICA
        //Palabras reservadas:
        for (String reservada : reservadas) {
            if (token.equalsIgnoreCase(reservada)) {
                tokenValido = true;
                setTipoToken("Palabra reservada", b);
                break;
            }
        }
        //Operadores:
        if(!tokenValido) {
            for(String operador : operadores) {
                if(token.equals(operador)) {
                    tokenValido = true;
                    setTipoToken("Operador", b);
                    break;
                }
            }
        }
        //Delimitadores:
        if(!tokenValido) {
            for(String delimitador : delimitadores) {
                if(token.equals(delimitador)) {
                tokenValido = true;
                setTipoToken("Delimitador", b);
                }
            }
        }    
        
        //Identificadores:
        if(!tokenValido) {
            if(validaIdentificador(token)) {
                tokenValido = true;
                setTipoToken("Identificador", b);
            }
        }
        
        //Digitos enteros
        if(!tokenValido) {
            if(validaInteger(token)) {
                tokenValido = true;
                setTipoToken("Integer", b);
            }
        }
        
        //Error:
        if(!tokenValido) {
            error("El token \"" + token + "\" es invalido para el lenguaje.");
            setTipoToken("ERROR", b);
            return "TOKEN INVALIDO!!!!";
        }
        return token;
    }
    
    //VALIDACION DEL IDENTIFICADOR
    public boolean validaIdentificador(String t) {
        boolean tokenValido = false;
        char[] charArray;
        charArray = t.toCharArray();
        int i=0;
        
       //Validaci贸n del primer caracter:
        if((charArray[i]>='a' && charArray[i]<='z') || 
                (charArray[i] >= 'A' && charArray[i] <= 'Z')){
            tokenValido = true;
        }
        //Validaci贸n del resto del token (si su longitud es mayor a 1):
        if(t.length() > 1 && tokenValido) {
            for(int j=1 ; j<charArray.length ; j++) {
                if((charArray[j]>='a' && charArray[j]<='z') || 
                (charArray[j] >= 'A' && charArray[j] <= 'Z') ||
                (charArray[j]=='_') || (charArray[j]=='-') || (charArray[j]>='0' && charArray[j]<='9')){
                    tokenValido = true;
                }
            }
        }
        else if(t.length() > 1 && tokenValido) {
            tokenValido = false;
        }
        return tokenValido;
    }
    
    //VALIDACION DEL INTEGER
    public boolean validaInteger(String t) {
        boolean tokenValido = false;
        char[] charArray;
        charArray = t.toCharArray();
        int i=0;
        
       //Validaci贸n del primer numero (negativo o positivo o cero):
        if((charArray[i]=='0') || (charArray[i]=='-') || 
                (charArray[i]>='0' && charArray[i]<='9') ){
            tokenValido = true;
        }
        //Validaci贸n del resto del token (si su longitud es mayor a 1):
        if(t.length() > 1 && tokenValido) {
            for(int j=1 ; j<charArray.length ; j++) {
                if((charArray[j]>='0' && charArray[j]<='9')){
                    tokenValido = true;
                }
            }
        }
        else if(t.length() > 1 && tokenValido) {
            tokenValido = false;
        }
        return tokenValido;
    }
    
    public void setTipoToken(String tipo, boolean b) {
        if(b) {
            tipoToken = tipo;
            }
    }
       
    public String getTipoToken() {
        return tipoToken;
    }
    
    public String checkNextToken() {
        return tokens[k];
    }
    
    //Verificacion de error l茅xico
    public void error(String error) {
        switch(JOptionPane.showConfirmDialog(null,
                "Error lexico: " + error + ".\n"
                        + "緿esea terminar la aplicacion?",
                "Ha ocurrido un error",
                JOptionPane.YES_NO_OPTION)) {
            case JOptionPane.NO_OPTION:
                int e = 1;
                break;
                    
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
        }
    }
}
