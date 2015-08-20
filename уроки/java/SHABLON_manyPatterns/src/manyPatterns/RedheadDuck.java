package manyPatterns;

public class RedheadDuck implements Quackable{

	Observable observable;
	
	public RedheadDuck() {
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
