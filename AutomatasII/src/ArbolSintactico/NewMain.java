
package ArbolSintactico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.*;

public class NewMain {
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        InputStream in = new FileInputStream(new File("src/main/prueba.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        String code = out.toString();
        System.out.println(out.toString());   //Prints the string content read from input stream
        reader.close();
        
        //Programax px = new Programax(new Declarax(new Typex("float"),"rnd"),
          //      new Whilex(new Comparax(new Idx("a"), new Idx("b")), new Asignax(new Idx("c"), new Idx("d"))));
        
       
        
          //Parser ppp = new Parser("class pp  int al ; int a2 ; boolean a3 ; boolean bo ; { a1 = a2 * a3 ; a2 = a3 + a1 ; } ");
        
          Parser codigof = new Parser(code);
          
    }
    
   public static Declarax VisitaArbol(Programax dx) {
       return dx.getDeclaration();
   }
   
   public static Statx VisitaArbol2(Programax dx) {
       return dx.getStatement();
   }
}
