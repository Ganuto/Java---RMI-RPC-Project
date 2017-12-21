package BinderDicionario;

import java.io.Serializable;

public class RequisicaoDicionario implements Serializable {

    private String traduzir;
    private int idioma;

    public String getTraduzir() {
        return traduzir;
    }
    
    public void setIdioma(int idioma){
        this.idioma = idioma;
    }
    
    public int getIdioma() {
        return this.idioma;
    }
    
    public void setTraduzir(String traduzir) {
        this.traduzir = traduzir;
    }
    
    public RequisicaoDicionario() {
    }
    
}
