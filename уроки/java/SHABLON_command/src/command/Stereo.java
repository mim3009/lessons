package command;

public class Stereo {
	
	int volume;
	String location;

	public Stereo(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println("Stereo is on in: " + this.location);
	}

	public void off() {
		System.out.println("Stereo is off in: " + this.location);
	}
	
	public void setCD(){
		System.out.println("CD is setting...");
	}
	
	public void setVolume(int volume){
		this.volume = volume;
		System.out.println("Volume is: " + this.volume);
	}
	
}
