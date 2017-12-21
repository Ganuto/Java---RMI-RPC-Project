
package BinderIMC;

import java.io.Serializable;


public class RespostaIMC implements Serializable{
    
    private float resultado;
    private int status;
    private String diagnostico;

    public RespostaIMC() {
        
    }
    
    public double getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getDiagnostico(){
        return diagnostico;
    }
            
    public void setDiagnostico (String diagnostico){
        this.diagnostico = diagnostico;
    } 
    
}
