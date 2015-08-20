package manyPatterns;

import java.util.Observer;

public class MallardDuck implements Quackable{

	Observable observable;
	
	public MallardDuck() {
		observable = new Observable(this);
	}
	
	public void quack() {
		System.out.println("Quack");
		notifyObservers();
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

	public void registerObserver(manyPatterns.Observer observer) {
		observable.registerObserver(observer);
	}

}
