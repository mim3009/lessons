package lab3;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class Main extends JComponent{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setSize(1000, 400);
	frame.setTitle("Shape Example");
	frame.getContentPane().add(new Main());
	frame.setVisible(true);
}
	public void paint(Graphics g) {
//		Shape obj = new Triangle( 200, 200, 0, 0, -45, -5, -90, 10);
//		obj.setColor(Color.BLUE);
//		obj.draw(g);
//		
//		Shape obj1 = new Triangle( 220, 220, -20, -5, -70, -5, +40, -15);
//		obj1.setColor(Color.BLUE);
//		obj1.draw(g);
//		
//		Shape obj2 = new Triangle( 205, 180, 0,0, -100,0, 40, 40);
//		obj2.setColor(Color.RED);
//		obj2.draw(g);
			
		
		Shape obj3 = new Triangle( 400, 200, 0, 0, -45, -5, -90, 10 );
		obj3.setColor(Color.BLUE);
		obj3.draw(g);
		
		Shape obj4 = new Triangle( 420, 220, -20, -5, -70, -5, +40, -15);
		obj4.setColor(Color.BLUE);
		obj4.draw(g);
		
		Shape obj5 = new Triangle2( 410, 190, 0,0, -150,0, 40, 40,10,10);
		obj5.setColor(Color.RED);
		obj5.draw(g);
		
		
		Shape obj12 = new Triangle( 600, 200, 0, 0, -45, -5, -90, 10 );
		obj12.setColor(Color.BLUE);
		obj12.draw(g);
		
		Shape obj13 = new Triangle( 620, 220, -20, -5, -70, -5, +40, -15);
		obj13.setColor(Color.BLUE);
		obj13.draw(g);
		
		Shape obj14 = new Triangle2( 605, 180, 0,0, -100,0, 40, 40,15,10);
		obj14.setColor(Color.RED);
		obj14.draw(g);
		
		Shape obj15 = new Triangle2( 805, 180, 0,0, -100,0, 40, 40,15,10);
		obj15.setColor(Color.RED);
		obj15.draw(g);
		
//		Shape obj6 = new Triangle( 600, 200, 0, +5, -25, -5, -90, 10 );
//		obj6.setColor(Color.BLUE);
//		obj6.draw(g);
//		
//		Shape obj7 = new Triangle( 620, 220, -20, -5, -70, -5, +40, -15);
//		obj7.setColor(Color.BLUE);
//		obj7.draw(g);
//		
//		Shape obj8 = new Triangle3( 610, 190, 0,0, -150,0, 40, 40,10,10,10,5);
//		obj8.setColor(Color.RED);
//		obj8.draw(g);
//		
//		
//		Shape obj9 = new Triangle( 800, 200, 0, +5, -25, -5, -90, 10 );
//		obj9.setColor(Color.BLUE);
//		obj9.draw(g);
//		
//		Shape obj11 = new Triangle4( 810, 190, 0,0, -150,0, 40, 40,10,10,10,5,5,10);
//		obj11.setColor(Color.RED);
//		obj11.draw(g);
//		
//		Shape obj10 = new Triangle( 800, 200, 0, +5, -25, -5, -90, 10);
//		obj10.setColor(Color.BLUE);
//		obj10.draw(g);
		
		
	}
}
