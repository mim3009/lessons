package vv;

import java.util.Random;

public class dds implements Runnable {
	int time;
	String name;
	Random r = new Random();
	
	public dds(String name){
		this.name = name;
		time = r.nextInt(999);
	}
	
	public void run() {
		System.out.printf("Поток %s спит %d\n", name, time);
		try{
			Thread.sleep(time);
		}catch (Exception e){};
		System.out.printf("Поток %s проснулся и закончился\n", name);
	}

}
