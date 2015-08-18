package rmicalc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalkImpl extends UnicastRemoteObject implements ICalc{

	protected CalkImpl() throws RemoteException {
		super();
	}

	public float echo(double a, char s, double b) throws RemoteException {
		switch(s){
		case '+':
			return (float) (a + b);
		case '-':
			return (float) (a - b);
		case '*':
			return (float) (a * b);
		case '/':
			return (float) (a / b);
		}
		return 0;
	}
}
