package BinderDicionario;

import java.io.Serializable;

public class RespostaDicionario implements Serializable {
    
    private String traducao;
    private int status;

    public String getTraducao() {
        return traducao;
    }

    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RespostaDicionario() {
    }
    
}
