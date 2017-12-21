package BinderMedia;

import java.io.Serializable;
import java.util.ArrayList;

public class RequisicaoMedia implements Serializable {
    
    private ArrayList<Integer> valores = new ArrayList<Integer>();
    private int contador;
    
    
    public RequisicaoMedia() {
        //Construtor padrao
    }
    
    public RequisicaoMedia (ArrayList<Integer> valores) {
        this.valores = valores;
    }

    public ArrayList<Integer> getValores() {
        return valores;
    }  
    
    public int getUltPos(){
        return this.valores.get(contador);
    }
    
    public void removeUltPos(){
        this.valores.remove(contador);
    }
    
    public void setValores(ArrayList<Integer> valores) {
        this.valores = valores;
    }
    
    public void setValor(int valor){
        contador = this.valores.size();
        this.valores.add(contador, valor);        
    }
    
    public int getTamanho(){
        return this.valores.size();
    }
    
    
}
