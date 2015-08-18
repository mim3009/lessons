package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Pass;

public interface Compute extends Remote {
	Object executeTask(Task t) throws RemoteException;

	Object executeTask2(Task task) throws RemoteException;
}
