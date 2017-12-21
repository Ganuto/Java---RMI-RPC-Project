package ServidorNomes;

import BinderServidorNomes.ServidorNomesInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class NomesServidor {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {

            ServidorNomesInterface servidorNomes = new NomesBack();

            LocateRegistry.createRegistry(6659);

            Naming.rebind("rmi://localhost:6659/servidorNomes", (Remote) servidorNomes);
            
            System.out.println("Servidor de nomes online");
        } catch (Exception ex) {
            System.out.println("Já existe um servidor de nomes no ar.");
        }
    }

}
