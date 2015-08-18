package engine;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import compute.*;

public class ComputeEngine extends UnicastRemoteObject implements Compute {
	public ComputeEngine() throws RemoteException {
		super();
	}

	public Object executeTask(Task t) {
		return t.execute();
	}

	public static void main(String[] args) {
		System.setProperty("java.security.policy", "E:\\rmi2.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		String name = "rmi://localhost/Compute";
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Compute engine = new ComputeEngine();
			Naming.rebind(name, engine);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
