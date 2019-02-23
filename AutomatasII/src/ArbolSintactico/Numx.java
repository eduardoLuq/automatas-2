
package ArbolSintactico;

public class Numx extends Expx{
    int num1;
    
    public Numx(int num2) {
        num1 = num2;
    }

    public int getNum() {
        return num1;
    }
    
    @Override
    public String tipoDato() {
        return "int";
    }
    
    @Override
    public String getString() {
        return null;
    }
}

