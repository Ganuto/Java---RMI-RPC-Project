package ServidorCalc;

import BinderCalc.RequisicaoCalc;
import BinderCalc.RespostaCalc;
import BinderCalc.CalculadoraInterface;
import BinderDicionario.DicionarioInterface;
import BinderDicionario.RequisicaoDicionario;
import BinderDicionario.RespostaDicionario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcBack extends  UnicastRemoteObject implements CalculadoraInterface, DicionarioInterface{
    public CalcBack() throws RemoteException{
        super();
    }
    public RespostaCalc soma(RequisicaoCalc requisicao){
        RespostaCalc resposta = new RespostaCalc();
        
        resposta.setResultado(requisicao.getOp1() + requisicao.getOp2());
        resposta.setStatus(0);
        
        return resposta;
    }
    public RespostaCalc subtracao(RequisicaoCalc requisicao){
        RespostaCalc resposta = new RespostaCalc();
        
        resposta.setResultado(requisicao.getOp1() - requisicao.getOp2());
        resposta.setStatus(0);
        
        return resposta;
    }
    public RespostaCalc multiplicacao(RequisicaoCalc requisicao){
        RespostaCalc resposta = new RespostaCalc();
        
        resposta.setResultado(requisicao.getOp1() * requisicao.getOp2());
        resposta.setStatus(0);
        
        return resposta;
    }
    public RespostaCalc divisao(RequisicaoCalc requisicao){
        RespostaCalc resposta = new RespostaCalc();
        if (requisicao.getOp2() == 0) {
            resposta.setStatus(2);
        }else{
            resposta.setResultado(requisicao.getOp1() / requisicao.getOp2());
            
            resposta.setStatus(0);
        }
        
        return resposta;
    }
    
    public RespostaDicionario traduzir(RequisicaoDicionario requsicao) {
        RespostaDicionario respostaDicionario = new RespostaDicionario();

        if (requsicao.getTraduzir().equalsIgnoreCase("Ola mundo")) {
            respostaDicionario.setTraducao("Ingles: Hello world / Frances: Bonjour le monde");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Bom dia")) {
            respostaDicionario.setTraducao("Ingles: Good morning / Frances: Bonjour ");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Boa tarde")) {
            respostaDicionario.setTraducao("Ingles: Good evening / Frances: Bonsoir");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Boa noite")) {
            respostaDicionario.setTraducao("Ingles: Good night / Frances: Bonne nuit");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Hello world")) {
            respostaDicionario.setTraducao("Portugues: Ola mundo / Frances: Bonjour le monde");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Good morning")) {
            respostaDicionario.setTraducao("Portugues: Bom dia / Frances: Bonjour ");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Good evening")) {
            respostaDicionario.setTraducao("Portugues: Boa tarde/ Frances: Bonsoir");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Good night")) {
            respostaDicionario.setTraducao("Portugues: Boa noite / Frances: Bonne nuit");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Bonjour le monde")) {
            respostaDicionario.setTraducao("Portugues: Ola mundo / Ingles: Hello world");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Bonjour")) {
            respostaDicionario.setTraducao("Portugues: Bom dia / Ingles: Good morning");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Good Bonsoir")) {
            respostaDicionario.setTraducao("Portugues: Boa tarde/ Ingles: Good evening");
        } else if (requsicao.getTraduzir().equalsIgnoreCase("Bonne nuit")) {
            respostaDicionario.setTraducao("Portugues: Boa noite / Ingles: Good night");
        } else {
            respostaDicionario.setStatus(0);
            respostaDicionario.setTraducao(requsicao.getTraduzir() + "      *****PALAVRA NAO CONSTA EM NOSSO DB*****");
        }

        return respostaDicionario;
    }
}
