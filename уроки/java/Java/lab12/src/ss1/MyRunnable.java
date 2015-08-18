package ss1;

public class MyRunnable implements Runnable{
	Thread pred;
	String name;
	public MyRunnable(String name, Thread pred){
		this.name = name;
		this.pred = pred;
	}

	public void run() {
		System.out.println(this.name + " started.");	
		double sum = 0;
		for(double i = 0; i < 1000000000; i++) sum+=i;
		System.out.println(this.name + " accum sum " + sum);
		if(pred != null)
			try{
				pred.join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		System.out.println(this.name + " finished.");
	}
}
