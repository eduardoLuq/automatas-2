package expresiones;

import java.util.ArrayList;

import simbolos.Identificador;
import simbolos.Valor;
import simbolos.Variable;

public class ExpresionAsignacion {

    private Identificador destino;
    private Expresion expresion;

    public ExpresionAsignacion(Identificador destino,Expresion expresion){
        this.destino = destino;
        this.expresion = expresion;
    }

    public void ejectuar() {
        ManejadorExpresiones.resetContador();
        Valor resultado = expresion.obtenerArbol().calcular();
        System.out.println(destino.getNombre()+" = "+ManejadorExpresiones.construirNombreTemp());
        System.out.println("El valor es = "+resultado);

        ((Variable)destino).setDato(resultado.getDato());
    }

}
