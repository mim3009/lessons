package fasad;

public class Amplifier {

	public void on() {
		System.out.println("Amp on");
	}

	public void setDvd(DvdPlayer dvd) {
		System.out.println("Dvd is setting");
	}

	public void setSurroundSound() {
		System.out.println("Surround sound is setting");
	}

	public void setVolume(int i) {
		System.out.println("Volume is setting on: " + i + "%");
	}

	public void off() {
		System.out.println("Amp off");
	}

}
