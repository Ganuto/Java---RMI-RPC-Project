package BinderCalc;

import BinderDicionario.RequisicaoDicionario;
import BinderDicionario.RespostaDicionario;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraInterface extends Remote {

    public RespostaDicionario traduzir(RequisicaoDicionario requsicao) throws RemoteException;

    public RespostaCalc soma(RequisicaoCalc reqisicao) throws RemoteException;

    public RespostaCalc subtracao(RequisicaoCalc reqisicao) throws RemoteException;

    public RespostaCalc multiplicacao(RequisicaoCalc reqisicao) throws RemoteException;

    public RespostaCalc divisao(RequisicaoCalc reqisicao) throws RemoteException;
}
