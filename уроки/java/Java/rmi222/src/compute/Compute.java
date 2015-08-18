package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
	// всего один метод, для выполнения задачи
	Object executeTask(Task t) throws RemoteException;
}
