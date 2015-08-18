package rmi;

import java.rmi.*;

public class HelloClient {

	public static void main(String[] args) {
		try {
			// ����� RMI Registry � ��� �������
			String name = "rmi://localhost/HelloService";
			// �������� ���������� ��������
			IHelloWorld hw = (IHelloWorld) Naming.lookup(name);
			// �������� ����� ���������� �������
			System.out.println(hw.WorHello("World"));
		} catch (Exception e) {
			System.err.println("ComputePi exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
