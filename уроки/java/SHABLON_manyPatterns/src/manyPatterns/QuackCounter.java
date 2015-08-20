package manyPatterns;

public class QuackCounter implements Quackable{

	Quackable duck;
	static int numberOfQuacks;
	
	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}
	
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}
	
	public static int getQuacks(){
		return numberOfQuacks;
	}

	public void notifyObservers() {
		duck.notifyObservers();
	}

	public void registerObserver(manyPatterns.Observer observer) {
		duck.registerObserver(observer);
	}

}
