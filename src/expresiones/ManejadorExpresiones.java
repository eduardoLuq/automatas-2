package expresiones;

import java.util.ArrayList;

public class ManejadorExpresiones {

    private static int contadorVariablesTemporales = 0;
    public static ArrayList<ExpresionAsignacion> expresiones = new ArrayList<>();
    public static ArrayList<String> pruebaExp = new ArrayList<>();

    static public void agregarExpresion(ExpresionAsignacion expresion){
        expresiones.add(expresion);
    }

    static int j = 1;
    static public void calcular(){
        for (int i = 0;i<expresiones.size();i++){
            ExpresionAsignacion expresion = expresiones.get(i);
            //String inicia = ("Expresion NO."+ j++ +"PASOOOOOO 1");
            //pruebaExp.add(inicia);
            //guardar(inicia);
            //imprimir(0);
            //System.out.println(pruebaExp.get(i));
            System.out.println("Expresion NO."+ j++);
            expresion.ejectuar();
            System.out.println();
        }
        
    }

    static public String construirNombreTemp(){
    	//System.out.println("ESTO RETORNA CONSTRUIR TEMP = " + "temp"+(contadorVariablesTemporales));
    	//String temp = "temp"+(contadorVariablesTemporales)+"PASOOOOOOOO 2";
    	//pruebaExp.add(temp);
        return "T"+(contadorVariablesTemporales);
    }
    static public void aumentarContador(){
        contadorVariablesTemporales ++;
    }
    static public void resetContador(){
        contadorVariablesTemporales = 0;
    }

    static public void print(){
        calcular();
    }
    /*
    static public void guardar(String temp){
    	pruebaExp.add(temp);
    	return pruebaExp
    }
    static public ArrayList<String> guardarfinal(){
    	return pruebaExp;
    }
    static public String imprimir(int temp2){
    	return pruebaExp.get(temp2);
    }*/



}
