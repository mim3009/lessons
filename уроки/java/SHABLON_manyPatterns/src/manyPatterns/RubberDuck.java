package manyPatterns;

public class RubberDuck implements Quackable{

	Observable observable;
	
	public RubberDuck() {
		observable = new Observable(this);
	}

	
	public void quack() {
		System.out.println("Squeak");
		notifyObservers();
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}


	public void registerObserver(manyPatterns.Observer observer) {
		observable.registerObserver(observer);
	}

}
