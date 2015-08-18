package factory;

public class CalifornyPizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new CalifornyPizzaIngredientFactory();
		
		if(item.equals("cheese")){
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Californy Style Cheese Pizza");
		}else if(item.equals("veggie")){
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Californy Style Veggie Pizza");
		}else if(item.equals("clam")){
			pizza = new CLamPizza(ingredientFactory);
			pizza.setName("Californy Style Clam Pizza");
		}else if(item.equals("pepperoni")){
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Californy Style Pepperoni Pizza");
		}
		return pizza;
	}
	
}
