package engine;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;
import compute.Task;

public class ComputeEngine extends UnicastRemoteObject implements Compute {
	public ComputeEngine() throws RemoteException {
		super();
	}

	public Object executeTask(Task t) throws RemoteException {
		return t.execute();
	}
	
	public Object executeTask2(Task task) throws RemoteException {
		return task.execute();
	}
	
	public static void main(String[] args) {
		System.setProperty("java.security.policy", "E:\\rmi2.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		//String name = "rmi://169.254.93.82/ComputePass";
		String name = "rmi://localhost/ComputePass";
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
