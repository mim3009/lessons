package command;

public class Light {

	String location;
	
	public Light(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println("Light is on in: " + this.location);
	}

	public void off() {
		System.out.println("Light is off in: " + this.location);
	}
}

