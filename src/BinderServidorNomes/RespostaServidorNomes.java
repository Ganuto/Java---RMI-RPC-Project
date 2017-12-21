package BinderServidorNomes;

import java.io.Serializable;

public class RespostaServidorNomes implements Serializable{
    
    String servidor;
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    
    
    
}
