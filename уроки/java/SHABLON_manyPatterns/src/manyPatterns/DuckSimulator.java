package manyPatterns;

public class DuckSimulator {
	public static void main(String[] args) {
		
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);
		
	}
	
	void simulate(AbstractDuckFactory duckFactory){
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		Flock flockOfDucks = new Flock();
		
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
		
		Flock flockOfMallards = new Flock();
		
		Quackable malardOne = duckFactory.createMallardDuck();
		Quackable malardTwo = duckFactory.createMallardDuck();
		Quackable malardThree = duckFactory.createMallardDuck();
		Quackable malardFour = duckFactory.createMallardDuck();
		
		flockOfMallards.add(malardOne);
		flockOfMallards.add(malardTwo);
		flockOfMallards.add(malardThree);
		flockOfMallards.add(malardFour);
		
		flockOfDucks.add(flockOfMallards);
		
		Quacklogist quacklogist = new Quacklogist();
		flockOfDucks.registerObserver(quacklogist);
		
		System.out.println("\nDuck Simulator: with adapter & decorator & abstract factory & komponowschik & iterator & observer");
		System.out.println("---------------All---------------");
		simulate(flockOfDucks);
		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
	}

	void simulate(Quackable duck) {
		duck.quack();
	}
	
}
