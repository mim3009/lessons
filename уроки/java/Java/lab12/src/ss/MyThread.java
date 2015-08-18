package ss;

public class MyThread extends Thread {
	public MyThread(String str){
		super(str);
	}
	public void run(){
		System.out.println(this.getName() + " started.");
		double sum = 0;
		for(long i = 0; i < 1000000000; i++) sum+=i;
		System.out.println(this.getName() + " accum sum " + sum);
		System.out.println(this.getName() + " finished.");
	}
}
