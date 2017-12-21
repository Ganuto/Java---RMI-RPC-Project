package BinderIMC;

import java.io.Serializable;

public class RequisicaoIMC implements Serializable {
    private float altura;
    private float peso;
    private char sexo;

    public RequisicaoIMC() {
        
    }
    
    public RequisicaoIMC(char sexo, float peso, float altura) {
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
    }
    
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
