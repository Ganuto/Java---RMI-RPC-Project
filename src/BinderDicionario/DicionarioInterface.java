package BinderDicionario;

import BinderCalc.RequisicaoCalc;
import BinderCalc.RespostaCalc;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DicionarioInterface extends Remote{
    public RespostaDicionario traduzir (RequisicaoDicionario requsicao) throws RemoteException;
    public RespostaCalc soma(RequisicaoCalc reqisicao) throws RemoteException;
    public RespostaCalc subtracao(RequisicaoCalc reqisicao) throws RemoteException;
    public RespostaCalc multiplicacao(RequisicaoCalc reqisicao) throws RemoteException;
    public RespostaCalc divisao(RequisicaoCalc reqisicao) throws RemoteException;
    
}
