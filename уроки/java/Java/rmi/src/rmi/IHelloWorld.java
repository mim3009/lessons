package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

// ��������� ������ ��������� Remote
public interface IHelloWorld extends Remote {
	// � ������������ RemoteException
	public String WorHello(String name) throws RemoteException;
}
