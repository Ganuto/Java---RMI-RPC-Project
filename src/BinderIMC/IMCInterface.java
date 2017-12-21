package BinderIMC;

import BinderMedia.RequisicaoMedia;
import BinderMedia.RespostaMedia;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IMCInterface extends Remote{
    
    public RespostaIMC calculaIMC (RequisicaoIMC requisicao) throws RemoteException;
    
    public RespostaMedia calculaMedia(RequisicaoMedia requisicao) throws RemoteException;
    
}
