package ss2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.TimerTask;

public class MyTask1 extends TimerTask{
	Component p;
	Graphics g;
	public MyTask1(Component p){
		this.p = p;
		this.g = p.getGraphics();
	}
	
	public void run() {
		int j = 0;
		int k = 40;
		int l = 0;
		int o = 0;
		int m = 40;
		int b = 40;
		for(int i = 0; i < 40 ; i++){
			switchColor(Color.YELLOW, 10, i, j, l, o);
			switchColor(p.getBackground(), 5, i, j, l, o);
			j++;
			l++;
			o++;
		}
		for(int r = 40; r < 80; r++){
			switchColor(Color.YELLOW, 10, r, k, m, b);
			switchColor(p.getBackground(), 5, r, k, m, b);
			k--;
			m--;
			b--;
		}
	}

	private void switchColor(Color color, int period, int i, int j, int l, int o) {
		g.setColor(color);
		g.fillOval(50, 50, 50+l, 50+o);
		try {
			Thread.sleep(period);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
