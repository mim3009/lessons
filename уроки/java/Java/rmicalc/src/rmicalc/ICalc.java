package rmicalc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalc extends Remote{
		public float echo(double a, char s, double b) throws RemoteException;
}
