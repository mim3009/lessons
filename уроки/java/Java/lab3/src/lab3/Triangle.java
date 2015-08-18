package lab3;
import java.awt.Graphics;
import java.awt.Polygon;
public class Triangle extends Shape {
  int dx1;
	int dx2;
	int dx3;
	int dy1;
	int dy2;
	int dy3;
	
	public Triangle(int x, int y, int dx1, int dx2, int dx3,
		int dy1, int dy2, int dy3) {
	super(x, y);
	
	this.dx1 = dx1;
	this.dx2 = dx2;
	this.dx3 = dx3;
	this.dy1 = dy1;
	this.dy2 = dy2;
	this.dy3 = dy3;
}

	

	public void draw (Graphics canvas) {
		canvas.setColor(getColor());
		Polygon pol = new Polygon();
		pol.addPoint(getStartPoint().x+dx1 , getStartPoint().y+dy1);
		pol.addPoint(getStartPoint().x +dx2, getStartPoint().y +dy2);
		pol.addPoint(getStartPoint().x +dx3 , getStartPoint().y+dy3 );
		canvas.fillPolygon(pol);
	
	}


}
