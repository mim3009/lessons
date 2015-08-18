package lab3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
public class Triangle3 extends Shape {
	int dx1;
	int dx2;
	int dx3;
	int dy1;
	int dy2;
	int dy3;
	int k;
	int r;
	int l;
	int j;
	
	public Triangle3(int x, int y, int dx1, int dx2, int dx3,
		int dy1, int dy2, int dy3, int k, int r, int l, int j) {
	super(x, y);
	
	this.dx1 = dx1;
	this.dx2 = dx2;
	this.dx3 = dx3;
	this.dy1 = dy1;
	this.dy2 = dy2;
	this.dy3 = dy3;
	this.k = k;
	this.r = r;
	this.l = l;
	this.j = j;
}

	

	public void draw (Graphics canvas) {
		canvas.setColor(getColor());
		Polygon pol = new Polygon();
		pol.addPoint(getStartPoint().x+dx1 , getStartPoint().y+dy1);
		pol.addPoint(getStartPoint().x +dx2, getStartPoint().y +dy2);
		pol.addPoint(getStartPoint().x +dx3 , getStartPoint().y+dy3 );
		canvas.fillPolygon(pol);
		canvas.setColor(Color.BLACK);
		canvas.fillOval(getStartPoint().x-130,getStartPoint().y+30, k, r);
		canvas.fillRect(getStartPoint().x,getStartPoint().y+10, l, j);
		canvas.fillRect(getStartPoint().x,getStartPoint().y+20, l, j);
	}


}
