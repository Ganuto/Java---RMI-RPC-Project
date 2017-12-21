package ServidorCalc;

import BinderCalc.CalculadoraInterface;
import BinderServidorNomes.RequisicaoConexaoServidorNomes;
import BinderServidorNomes.ServidorNomesInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculadoraServidor {
    static RequisicaoConexaoServidorNomes reqServNomes = new RequisicaoConexaoServidorNomes();
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        CalculadoraInterface calculadora = new CalcBack();        

        LocateRegistry.createRegistry(6660);

        Naming.rebind("rmi://localhost:6660/Calculadora", calculadora);

        reqServNomes.setEnderecoIP("rmi://localhost:6660/Calculadora");
        reqServNomes.setServico(1);

        try {
            ServidorNomesInterface servidorNomes = (ServidorNomesInterface) Naming.lookup("rmi://localhost:6659/servidorNomes");
            servidorNomes.adicionaServidor(reqServNomes);
            System.out.println("Servidor registrado no servidor de nomes.");
        } catch (Exception ex) {
            System.out.println("Servidor de nomes não encontrado ou fora do ar.");
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
