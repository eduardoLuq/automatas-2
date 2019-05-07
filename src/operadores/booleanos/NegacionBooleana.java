package operadores.booleanos;

//import operadores.Operador;
//import tiposDeDatos.Valor;

import operadores.OperadorUnarioCA;

public class NegacionBooleana extends OperadorUnarioCA {

    public NegacionBooleana(String nombreOperacion) {
        super(nombreOperacion);
    }

    @Override
    public Object operar(Boolean op1) {
        return !op1;
    }

    @Override
    public String toString() {
        return "!";
    }
}
