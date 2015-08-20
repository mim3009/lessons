package manyPatterns;

public class Quacklogist implements Observer{

	public void update(QuackObservable duck) {
		System.out.println("Quacklogist: " + duck + " just quacked.");
	}

}
