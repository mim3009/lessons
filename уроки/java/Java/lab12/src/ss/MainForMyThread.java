package ss;

public class MainForMyThread {

	public static void main(String[] args) {
		Thread t1 = new MyThread("MyThread_1"); t1.start();
		Thread t2 = new MyThread("MyThread_2"); t2.start();
		Thread t3 = new MyThread("MyThread_3"); t3.start();
	}

}
