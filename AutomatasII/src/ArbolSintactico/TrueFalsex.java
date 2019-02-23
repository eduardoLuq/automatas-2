
package ArbolSintactico;

public class TrueFalsex extends Expx{
    private boolean s1;
    
    public TrueFalsex(boolean st1) {
        s1 = st1;
    }
    
    public boolean getTrueFalsex() {
        return s1;
    }
    
    @Override
    public String tipoDato() {
        return "boolean";
    }
    
    @Override
    public String getString() {
        return null;
    }
    
}
