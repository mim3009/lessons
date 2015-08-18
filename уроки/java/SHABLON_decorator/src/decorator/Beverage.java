package decorator;

public abstract class Beverage {
	
	String description = "Unknown Bevare";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
	
}
