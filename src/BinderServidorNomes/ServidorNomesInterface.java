/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinderServidorNomes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author canuto
 */
public interface ServidorNomesInterface extends Remote{
    
    public RespostaServidorNomes repostaServidorServico (RequisicaoServidorNomes requisicao) throws RemoteException;
    public void adicionaServidor(RequisicaoConexaoServidorNomes requisicaoServidor) throws RemoteException;
    public void removeServidor(RequisicaoConexaoServidorNomes requisicao) throws RemoteException;
    public ArrayList<RequisicaoConexaoServidorNomes> getLista() throws RemoteException;
    
}
