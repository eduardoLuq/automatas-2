
package main;

public class DSimbolos {
    
        private int no;
        private String simbolo;
        private String tipoSimbolo;
        //private String alcanzeSimbolo;
        //private String posicionSimbolo;
        

    public DSimbolos(int x, String y, String z) {
        this.no = x;
        this.simbolo = y;
        this.tipoSimbolo = z;
        //this.alcanzeSimbolo=w;
        //this.posicionSimbolo=g;
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
    /*
    public String getAlcanzeSimbolo() {
        return alcanzeSimbolo;
    }
    public String getPosicionSimbolo() {
        return posicionSimbolo;
    }
    */
}
