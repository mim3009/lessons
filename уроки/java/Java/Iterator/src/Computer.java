import java.util.Vector;

public class Computer {
	private int data;

	public Computer(int data) {
		this.data = data;
	}

	public void SetData(int data) {
		this.data = data;

	}

	public int getData() {
		return this.data;
	}

	public String toString() {
		return String.valueOf(data);
	}

}
