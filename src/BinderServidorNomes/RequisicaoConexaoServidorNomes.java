package BinderServidorNomes;

import java.io.Serializable;

public class RequisicaoConexaoServidorNomes implements Serializable{
    private String enderecoIP;
    private int servico;

    public String getEnderecoIP() {
        return enderecoIP;
    }

    public void setEnderecoIP(String enderecoIP) {
        this.enderecoIP = enderecoIP;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }
    
    
    
}
