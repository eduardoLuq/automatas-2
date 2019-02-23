
package ArbolSintactico;

public class Comparax extends Expx{
    private Opx o1;
    private String s1;
    private String s2;
    
    public Comparax(Opx op1, String st1, String st2) {
        o1 = op1;
        s1 = st1;
        s2 = st2;
    }

    public Opx getOp() {
        return o1;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    @Override
    public String tipoDato() {
        return "compara";
    }

    @Override
    public String getString() {
        return s1+" "+s2;
    }
}
