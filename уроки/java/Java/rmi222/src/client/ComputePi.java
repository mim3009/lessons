package client;

import java.rmi.*;
import java.math.*;
import compute.*;

public class ComputePi {
	public static void main(String args[]) {
		System.setProperty("java.security.policy", "E:\\rmi2.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			String name = "rmi://localhost/Compute";
			Compute comp = (Compute) Naming.lookup(name);
			Pi task = new Pi(Integer.parseInt("20"));
			BigDecimal pi = (BigDecimal) (comp.executeTask(task));
			System.out.println(pi);
		} catch (Exception e) {
			System.err.println("ComputePi exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
