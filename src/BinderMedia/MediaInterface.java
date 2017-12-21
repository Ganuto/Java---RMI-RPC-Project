package BinderMedia;

import BinderIMC.RequisicaoIMC;
import BinderIMC.RespostaIMC;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MediaInterface extends Remote{
        
        public RespostaMedia calculaMedia(RequisicaoMedia requisicao) throws RemoteException;
    
        public RespostaIMC calculaIMC (RequisicaoIMC requisicao) throws RemoteException;
}
