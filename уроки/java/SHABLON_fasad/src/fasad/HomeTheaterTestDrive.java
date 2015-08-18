package fasad;

public class HomeTheaterTestDrive {
	public static void main(String[] args) {
		
		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		DvdPlayer dvd = new DvdPlayer();
		Projector projector = new Projector();
		TheaterLights lights = new TheaterLights();
		Screen screen = new Screen();
		PopcornPopper popper = new PopcornPopper();
		
		HomeTheaterFasad homeTheater = new HomeTheaterFasad(amp, tuner, dvd, projector, lights, screen, popper);
		
		homeTheater.watchMovie("Lost");
		homeTheater.endMovie();
		
	}
}
