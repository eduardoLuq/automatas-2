
package main;

public class DSimbolos {
    
        private int no;
        private String simbolo;
        private String tipoSimbolo;

    public DSimbolos(int x, String y, String z) {
        this.no = x;
        this.simbolo = y;
        this.tipoSimbolo = z;
    }

    public int getNo() {
        return no;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getTipoSimbolo() {
        return tipoSimbolo;
    }
    
}
