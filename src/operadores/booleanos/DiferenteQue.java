package operadores.booleanos;

//import operadores.Operador;
//import tiposDeDatos.Valor;

import operadores.OperadorCA;

public class DiferenteQue extends OperadorCA {

    public DiferenteQue(String nombreOperacion) {
        super(nombreOperacion);
    }

    @Override
    public Object operar(Boolean op1, Boolean op2) {
        return op1 != op2;
    }
    @Override
    public Object operar(String op1, String op2) {
        return op1 != op2;
    }
    @Override
    public Object operar(Double op1, Double op2) {
        return op1 != op2;
    }
    @Override
    public Object operar(Integer op1, Integer op2) {
        return op1 != op2;
    }

    @Override
    public int getPrecedencia() {
        return 0;
    }

    @Override
    public String toString() {
        return "!=";
    }
}
