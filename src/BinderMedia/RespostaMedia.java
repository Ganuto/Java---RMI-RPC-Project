package BinderMedia;

import java.io.Serializable;

public class RespostaMedia implements Serializable {
    private double resultado;
    private boolean status;

    public RespostaMedia() {
        
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
