package client;

import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;

import compute.Compute;

public class ComputePass {

	public static void main(String args[]) {

		final Compute comp;
		final Compute comp2;
		final Pass task;
		Thread mT;
		Thread mT2;

		System.setProperty("java.security.policy", "E:\\rmi2.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("введите md5:");
		String str = sc.next();
		System.out.println("введите первое значение диапазона:");
		String str2 = sc.next();
		System.out.println("введите последнее значение диапазона:");
		String str3 = sc.next();
		sc.close();
		try {
			// String name = "rmi://169.254.93.82/ComputePass";
			//String name = "rmi://192.168.56.1/ComputePass";
			String name = "rmi://localhost/ComputePass";
			String name2 = "rmi://localhost/ComputePass";
			comp = (Compute) Naming.lookup(name);
			comp2 = (Compute) Naming.lookup(name2);
			task = new Pass(str + " " + str2 + " " + str3);
			if (comp != null && comp2 != null) {

				mT = new Thread(new Runnable() {

					public void run() {
						try {
							String pass = (String) comp.executeTask(task);
							System.out.println("Finded Pass is: " + pass + " (First Server)");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});
				mT.start();

				mT2 = new Thread(new Runnable() {

					public void run() {
						try {
							String pass2 = (String) comp2.executeTask2(task);
							System.out.println("Finded Pass is: " + pass2 + " (Second Server)");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});
				mT2.start();

			} else if (comp != null && comp2 == null) {
				String pass = (String) comp.executeTask(task);
				System.out.println("Finded Pass is: " + pass);
			} else if (comp == null && comp2 != null) {
				String pass2 = (String) comp2.executeTask2(task);
				System.out.println("Finded Pass is: " + pass2);
			}
		} catch (Exception e) {
			System.err.println("ComputePi exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
