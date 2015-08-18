package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

// интерфейс должен расширять Remote
public interface IHelloWorld extends Remote {
	// и генерировать RemoteException
	public String WorHello(String name) throws RemoteException;
}
