import java.awt.Container;

import process.Actor;
import process.Store;
import widgets.ChooseRandom;

public class Road extends Actor {

	private boolean open;
	private Main gui;
	private Model model;
	private ChooseRandom rnd;
	private Store queueRoad;

	public Road(String string, Main gui, Model model) {
		setNameForProtocol(string);
		this.gui = gui;
		this.model = model;
		rnd = gui.getChooseRandom_2();
		queueRoad = model.getQueueRoad();
	}

	public boolean isOpen() {
		return open;
	}

	@Override
	protected void rule() {
		getDispatcher().printToProtocol("����� ������"+String.valueOf(gui.getChooseData_4().getDouble()));
		while (getDispatcher().getCurrentTime() <= gui.getChooseData_4().getDouble()) {
			getDispatcher().printToProtocol("������ �������");
			holdForTime(rnd.next());
			queueRoad.add(1);
			open = true;
			getDispatcher().printToProtocol("������ �������");
			holdForTime(rnd.next());
			open = false;
			queueRoad.remove(1);
		}

	}

}
