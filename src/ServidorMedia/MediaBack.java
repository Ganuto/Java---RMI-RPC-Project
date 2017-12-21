package ServidorMedia;

import BinderIMC.IMCInterface;
import BinderIMC.RequisicaoIMC;
import BinderIMC.RespostaIMC;
import BinderMedia.MediaInterface;
import BinderMedia.RequisicaoMedia;
import BinderMedia.RespostaMedia;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class MediaBack extends UnicastRemoteObject implements MediaInterface, IMCInterface {

    public MediaBack() throws RemoteException {
        super();
    }

    public RespostaMedia calculaMedia(RequisicaoMedia requisicao) {
        RespostaMedia respostaMedia = new RespostaMedia();
        ArrayList<Integer> valores = new ArrayList<Integer>(requisicao.getValores());        
        double somaTotal = 0;        
        for (int i = 0; i < valores.size(); i++) {            
            somaTotal += valores.get(i);
        }

        respostaMedia.setResultado(somaTotal / valores.size());
        respostaMedia.setStatus(false);
        
        return respostaMedia;
    }
    
    public RespostaIMC calculaIMC (RequisicaoIMC requisicao){
        RespostaIMC respostaIMC = new RespostaIMC();
        respostaIMC.setResultado(requisicao.getPeso() / (requisicao.getAltura() * requisicao.getAltura()));
        if(respostaIMC.getResultado() >= 18.5 && respostaIMC.getResultado() <= 25){
            respostaIMC.setDiagnostico("peso ideal.");
        }else if(respostaIMC.getResultado() <= 18.5){
            respostaIMC.setDiagnostico("abaixo do peso. Vá ao medico!");
        }else
            respostaIMC.setDiagnostico("acima do peso. Vá ao medico!");
        respostaIMC.setStatus(0);
        return respostaIMC;
    }

}
