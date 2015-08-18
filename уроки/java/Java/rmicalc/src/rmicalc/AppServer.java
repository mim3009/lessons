package rmicalc;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class AppServer {
	
	public static void main(String[] args) throws RemoteException{
        System.setProperty("java.security.policy","E:\\rmi.policy");
        String name = "rmi://localhost/calc";
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Naming.rebind(name, new CalkImpl());
            System.out.println("Server bound");
        } catch (Exception e) {
            System.err.println("Server Trouble: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
