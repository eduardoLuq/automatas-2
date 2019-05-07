package simbolos;

import analizadorSintactico.CustomToken;
import errores.ManejadorErrores;
import errores.SemanticError;
import tiposDeDatos.TipoError;

import java.util.ArrayList;
import java.util.HashMap;

public class TablaDeSimbolos {

    static HashMap<String,Identificador> simbolos = new HashMap();
    
    static ArrayList<String> ALalc = new ArrayList<String>();
    static ArrayList<String> ALtipo = new ArrayList<String>();
    static ArrayList<String> ALposicion = new ArrayList<String>();
    static ArrayList<String> ALnombre = new ArrayList<String>();
    static ArrayList<String> ALvalor = new ArrayList<String>();
    static ArrayList<String> ALAL = new ArrayList<String>();

    public void agregarIdentificador(Identificador identificador){
        if (!simbolos.containsKey(identificador.getToken().image)) {
            simbolos.put(identificador.getToken().image, identificador);
        } else {
            String reason = "La variable \""+identificador.getToken().image+"\" ya esta declarada";
            ManejadorErrores.agregarError( new SemanticError(
                    identificador.getToken().beginLine,
                    identificador.getToken().beginColumn,
                    reason)
            );
        }
    }

    public Identificador obtenerIdentificador(CustomToken token){
        try {
            return obtenerIdentificador(token.image);
        } catch (Error e){
            String reason = "La variable \""+token.image+"\" no existe";
            ManejadorErrores.agregarError( new SemanticError(
                    token.beginLine,
                    token.beginColumn,
                    reason)
            );
            Variable error = new Variable(token,"error","error",new TipoError());
            return error;
        }

    }

    private Identificador obtenerIdentificador(String image) throws Error{
        if (simbolos.containsKey(image)){
            return simbolos.get(image);
        } else {
            throw new Error("No se encontro el identificador \""+image+"\"");
        }
    }

    public static ArrayList<String> print(String id){
       //String format = "%-10s %-10s %-25s %-15s %s\n";
       //System.out.printf(format,"Alcance","Tipo","Posicion","Nombre","Valor");
       //System.out.println();
       ALalc.clear();
       ALtipo.clear();
       ALposicion.clear();
       ALnombre.clear();
       ALvalor.clear();
        for (String key: simbolos.keySet()){
            Variable var = (Variable) simbolos.get(key);
            ALnombre.add(key);
            String tipoDeDato = var.getTipoDeDato().toString();
            ALtipo.add(tipoDeDato);
            String alcance = var.getAlcance();
            ALalc.add(alcance);
            String posicion = "linea "+var.getToken().beginLine;
            ALposicion.add(posicion);
            String valor;
            try {
                valor = var.getDato().toString();
                ALvalor.add(valor);
            }catch (NullPointerException e){
                valor = "null";
            }
            //System.out.printf(format,alcance,tipoDeDato,posicion,key,valor);
        }
        if(id.equals("alc")) {
        	return ALalc;
        }
        else if(id.equals("tipo")) {
        	return ALtipo;
        }
        else if(id.equals("pos")) {
        	return ALposicion;
        }
        else if(id.equals("nom")) {
        	return ALnombre;
        }
        else if (id.equals("val")) {
        	return ALvalor;
        }
        else {
        	return ALvalor;
        }
    }
    
}
