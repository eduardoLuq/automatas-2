package operadores.booleanos;

//import operadores.Operador;
//import tiposDeDatos.Valor;

import operadores.OperadorCA;

public class Disyuncion extends OperadorCA {

    public Disyuncion(String nombreOperacion) {
        super(nombreOperacion);
    }

    @Override
    public Object operar(Boolean op1, Boolean op2) {
        return op1 || op2;
    }

    @Override
    public int getPrecedencia() {
        return 0;
    }

    @Override
    public String toString() {
        return "||";
    }
}
