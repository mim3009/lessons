import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FirstApplet extends Applet implements Runnable, MouseListener{
	
	Thread t;
	int x,y;
	Image img1,img2;
	int period = 1000;
	int points = 0;
	int imgNumber = 0;
	
	public void paint(Graphics g){
		if(imgNumber == 0){
			g.drawImage(img1, x-50, y-50, this);
		}
		else{
			g.drawImage(img2, x-50, y-50, this);
		}
		g.drawString("LVL: "+points, 20, 20);
	}
	
	public void init(){
		addMouseListener(this);
		img1 = getImage(getDocumentBase(), "1.jpg");
		img2 = getImage(getDocumentBase(), "2.jpg");
		t = new Thread(this);
		t.start();
	}

	public void run() {
		while(true){
			try{
				x = (int) (Math.random()*400);
				y = (int) (Math.random()*300);
				repaint();
				t.sleep(period);
			}catch(InterruptedException e){}
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		if(x-50<arg0.getX() && arg0.getX() < x+50 && y-50< arg0.getY() && arg0.getY()<y+50){
			points++;
			period =period - 50;
			imgNumber =1;
			repaint();
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		imgNumber = 0;
		repaint();		
	}
	
}
