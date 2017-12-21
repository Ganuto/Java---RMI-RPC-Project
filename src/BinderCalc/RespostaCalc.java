package BinderCalc;

import java.io.Serializable;

public class RespostaCalc implements Serializable{
    private int status;
    private float resultado;

    public RespostaCalc(int status, float resultado) {
        this.status = status;
        this.resultado = resultado;
    }

    public RespostaCalc() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
    
    
}
