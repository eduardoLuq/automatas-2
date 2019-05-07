package operadores.booleanos;

//import operadores.Operador;
//import tiposDeDatos.Valor;

import operadores.OperadorCA;

public class MenorIgualQue extends OperadorCA {

    public MenorIgualQue(String nombreOperacion) {
        super(nombreOperacion);
    }

    @Override
    public Object operar(Integer op1,Integer op2) {
        return op1 <= op2;
    }
    @Override
    public Object operar(Double op1,Double op2) {
        return op1 <= op2;
    }

    @Override
    public int getPrecedencia() {
        return 0;
    }

    @Override
    public String toString() {
        return "<=";
    }
}
