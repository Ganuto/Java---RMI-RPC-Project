package ServidorNomes;

import BinderServidorNomes.RequisicaoConexaoServidorNomes;
import BinderServidorNomes.RequisicaoServidorNomes;
import BinderServidorNomes.RespostaServidorNomes;
import BinderServidorNomes.ServidorNomesInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class NomesBack extends UnicastRemoteObject implements ServidorNomesInterface {

    ArrayList<RequisicaoConexaoServidorNomes> lista = new ArrayList();

    public NomesBack() throws RemoteException {
        super();
    }

    public void adicionaServidor(RequisicaoConexaoServidorNomes requisicaoServidor) {
        lista.add(requisicaoServidor);
    }

    public ArrayList<RequisicaoConexaoServidorNomes> getLista() {
        return lista;
    }

    public void removeServidor(RequisicaoConexaoServidorNomes requisicaoServidor) {
        int i = 0;
        for (RequisicaoConexaoServidorNomes args : lista) {
            if (requisicaoServidor.getEnderecoIP().equalsIgnoreCase(args.getEnderecoIP())) {
                lista.remove(i);
            }
            i++;
        }
    }

//    public RespostaServidorNomes repostaServidorServico(RequisicaoServidorNomes requisicao) {
//        RespostaServidorNomes resposta = new RespostaServidorNomes();
//        int i = 0;
//        if (!lista.isEmpty()) {
//            for (RequisicaoConexaoServidorNomes req : lista) {
//                if ((requisicao.getServico() == 1 || requisicao.getServico() == 4) && req.getServico() == 1) {
//                    resposta.setStatus(0);
//                    resposta.setServidor(req.getEnderecoIP());
//                    break;
//                } else if ((requisicao.getServico() == 2 || requisicao.getServico() == 3) && req.getServico() == 2) {
//                    resposta.setStatus(0);
//                    resposta.setServidor(req.getEnderecoIP());
//                    break;
//                } else {
//                    resposta.setStatus(1);
//                }
//            }
//        }else{
//            resposta.setStatus(1);
//        }
//
//        return resposta;
//    }
        static int i = 0;
        public RespostaServidorNomes repostaServidorServico(RequisicaoServidorNomes requisicao) {
        RespostaServidorNomes resposta = new RespostaServidorNomes();        
        if (!lista.isEmpty()) {
            while (i != lista.size()) {
                if ((requisicao.getServico() == 1 || requisicao.getServico() == 4) && lista.get(i).getServico() == 1) {
                    resposta.setStatus(0);
                    resposta.setServidor(lista.get(i).getEnderecoIP());
                    i ++;
                    break;
                } else if ((requisicao.getServico() == 2 || requisicao.getServico() == 3) && lista.get(i).getServico() == 2) {
                    resposta.setStatus(0);
                    resposta.setServidor(lista.get(i).getEnderecoIP());
                    i++;
                    break;
                } else {
                    resposta.setStatus(1);
                }
                i ++;
            }
            if (i == lista.size())
                i = 0;
        }else{
            resposta.setStatus(1);
        }

        return resposta;
    }

}
