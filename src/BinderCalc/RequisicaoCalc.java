package BinderCalc;

import java.io.Serializable;

public class RequisicaoCalc implements Serializable{
        private float op1;
        private float op2;

    public RequisicaoCalc() {
        
    }    
    public RequisicaoCalc(float op1, float op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public float getOp1() {
        return op1;
    }

    public void setOp1(float op1) {
        this.op1 = op1;
    }

    public float getOp2() {
        return op2;
    }

    public void setOp2(float op2) {
        this.op2 = op2;
    }
        
        
        
}
