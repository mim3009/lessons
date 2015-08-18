package duck;

public class MiniDuckSimulator {
	public static void main(String[] args){
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		mallard.display();
		System.out.println("---------------------------");
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
