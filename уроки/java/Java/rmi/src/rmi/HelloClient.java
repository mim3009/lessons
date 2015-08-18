package rmi;

import java.rmi.*;

public class HelloClient {

	public static void main(String[] args) {
		try {
			// адрес RMI Registry и имя сервиса
			String name = "rmi://localhost/HelloService";
			// получаем клиентскую заглушку
			IHelloWorld hw = (IHelloWorld) Naming.lookup(name);
			// вызываем метод удаленного объекта
			System.out.println(hw.WorHello("World"));
		} catch (Exception e) {
			System.err.println("ComputePi exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
