package pack1;

public class MyReader implements Runnable {
	Info in;
	Thread go;

	MyReader(Info in) {
		this.in = in;
		go = new Thread(this);
		go.start();
	}

	public void run() {
		Thread t = Thread.currentThread();
		while (go == t) {
			System.out.println("Read " + in.getInfo());
		}
	}

	public void stop() {
		go = null;
	}

}