package ArbolSintactico;
import java.util.Vector;

public class Programax {
    private Idx i1;
    private Declarax s1;
    //private Vector s1;
    private Statx s2;
    
    public Programax(Idx id1, Declarax st1, Statx st2) {
        i1 = id1;
        s1 = st1;
        s2 = st2;
    }
    
    public Idx getIdentifier() {return i1;}
    
    public Declarax getDeclaration() {return s1;}
    
    public Statx getStatement() {return s2;}
}
