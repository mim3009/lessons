package mvc;

public class HeartController implements ControllerInterface {
	
	HeartModelInterface model;
	DJVIew view;

	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJVIew(this, new HeartAdapter(model));
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}

	public void start() {}

	public void stop() {}

	public void increaseBPM() {}

	public void decreaseBPM() {}

	public void setBPM(int bpm) {}

}
