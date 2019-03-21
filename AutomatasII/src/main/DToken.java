
package main;

/**
 *
 * @author Jesus
 */
    class DToken {
        
        private int no;
        private String tok;
        private String tipoTok;
        //private String alcanzeSimboloTok;
        //private String posicionSimboloTok;

    public DToken(int no, String tok, String tipoTok) {
        this.no = no;
        this.tok = tok;
        this.tipoTok = tipoTok;
        //this.alcanzeSimboloTok=alcanzeSimboloTok;
        //this.posicionSimboloTok=posicionSimboloTok;
    }

    public int getNo() {
        return no;
    }

    public String getTok() {
        return tok;
    }

    public String getTipoTok() {
        return tipoTok;
    }
    /*
    public String getAlcanzeSimboloTok() {
        return alcanzeSimboloTok;
    }
    public String getPosicionSimboloTok() {
        return posicionSimboloTok;
    }
    */

        
        
        
    }
