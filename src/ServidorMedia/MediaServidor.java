package ServidorMedia;

import BinderMedia.MediaInterface;
import BinderServidorNomes.RequisicaoConexaoServidorNomes;
import BinderServidorNomes.ServidorNomesInterface;
import ServidorCalc.CalculadoraServidor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MediaServidor {
    static RequisicaoConexaoServidorNomes reqServNomes = new RequisicaoConexaoServidorNomes();
    
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        
        MediaInterface media = new MediaBack();
        
        LocateRegistry.createRegistry(6663);
        
        Naming.rebind("rmi://localhost:6663/Media", media);
        
        reqServNomes.setEnderecoIP("rmi://localhost:6663/Media");
        reqServNomes.setServico(2);
        
        try {
            ServidorNomesInterface servidorNomes = (ServidorNomesInterface) Naming.lookup("rmi://localhost:6659/servidorNomes");
            servidorNomes.adicionaServidor(reqServNomes);
            System.out.println("Servidor registrado no servidor de nomes.");
        } catch (Exception ex) {
            System.out.println("Servidor de nomes não encontrado ou fora do ar.");
            System.exit(0);
        }
        
        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    ServidorNomesInterface servidorNomes = (ServidorNomesInterface) Naming.lookup("rmi://localhost:6659/servidorNomes");
                    servidorNomes.removeServidor(reqServNomes);
                } catch (NotBoundException ex) {
                    Logger.getLogger(CalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(CalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
    }
}
