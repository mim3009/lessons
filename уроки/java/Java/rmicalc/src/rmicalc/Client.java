package rmicalc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	
	static Scanner scn;
	
	public static void main(String[] args) throws NotBoundException, IOException {
		String name = "rmi://localhost/calc";
		scn = new Scanner(System.in);
		System.out.println("первое число:");
		double a = Double.parseDouble(scn.next());
		System.out.println("знак:");
		String aa = scn.next();
		char s = aa.charAt(0);
		System.out.println("второе число:");
		double b = Double.parseDouble(scn.next());
		ICalc service = (ICalc) Naming.lookup(name);
		System.out.println(service.echo(a, s, b));
		
	}
	
}
