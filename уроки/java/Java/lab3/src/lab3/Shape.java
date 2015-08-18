package lab3;
import java.awt.Color;
import java.awt.Point;

public abstract class Shape implements IShape {


	private Point startPoint;

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	private Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Shape(int x, int y) {
		this.startPoint = new Point(x, y);
	}
}
