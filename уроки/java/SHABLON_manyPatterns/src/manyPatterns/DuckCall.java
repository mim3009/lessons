package manyPatterns;

public class DuckCall implements Quackable{

	Observable observable;
	
	public DuckCall() {
		observable = new Observable(this);
	}
	
	public void quack() {
		System.out.println("Kwak");
		notifyObservers();
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

	public void registerObserver(manyPatterns.Observer observer) {
		observable.registerObserver(observer);
	}

}
