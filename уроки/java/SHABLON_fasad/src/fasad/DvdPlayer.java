package fasad;

public class DvdPlayer {

	public void on() {
		System.out.println("Dvd on");
	}

	public void play(String movie) {
		System.out.println("Dvd start playing movie: " + movie);
	}

	public void stop() {
		System.out.println("Dvd stopping");
	}

	public void eject() {
		System.out.println("Dvd ejecting");
	}

	public void off() {
		System.out.println("Dvd off");
	}

}
