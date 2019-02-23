
package ArbolSintactico;

public class Idx extends Expx{
    private String s1;
    
    public Idx(String st1) {
        s1 = st1;
    }
    
    public String getIdx() {
        return s1;
    }
    
    @Override
    public String tipoDato() {
        return "id";
    }
    
    @Override
    public String getString() {
        return getIdx();
    }
}
