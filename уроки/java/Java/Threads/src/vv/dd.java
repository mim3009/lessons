package vv;

public class dd {
	public static void main(String[] args){
		Thread t1 = new Thread(new dds("1"));
		Thread t2 = new Thread(new dds("2"));
		Thread t3 = new Thread(new dds("3"));
		t1.start();
		t2.start();
		t3.start();
	}

}
