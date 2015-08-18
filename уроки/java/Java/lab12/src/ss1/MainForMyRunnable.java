package ss1;

public class MainForMyRunnable {
	public static void main(String[] args) {
		Runnable r1 = new MyRunnable("MyRunnable_1", null);
		Thread t1 = new Thread(r1); t1.start();
		Runnable r2 = new MyRunnable("MyRunnable_2", t1);
		Thread t2 = new Thread(r2); t2.start();
		Runnable r3 = new MyRunnable("MyRunnable_3", t2);
		Thread t3 = new Thread(r3); t3.start();
	}
}
