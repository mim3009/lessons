package muz;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class n {

	public static void main(String[] args) throws IOException {
		for(Boolean h = true;h == true;){
//			try {
//			Thread.sleep(300000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		  try {
		        String line;
		        Process p = Runtime.getRuntime().exec
		                (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
		        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        while ((line = input.readLine()) != null) {
		        	StringTokenizer st= new StringTokenizer(line);
		        	String[] s = new String[st.countTokens()];
		        	for (int i = 0; st.hasMoreTokens(); i++){
		        		s[i] = new String(st.nextToken());
		        	if(s[i].equals("Steam.exe")){
		        		try {
		        			for (int j = 0;i<=2; j++){
		        			Thread.sleep(900);
		        			if(j==0){
		        			Toolkit.getDefaultToolkit().beep();
		        			JOptionPane.showMessageDialog(null, "Ты уже играешь 15 минут пора бы подумать над тем чтобы остановиться!");
		        			}
		        			if(j==1){
		        			Toolkit.getDefaultToolkit().beep();
		        			JOptionPane.showMessageDialog(null, "пол часа прошло, хватит(");
		        			}
		        			if(j==2){
		        			a d = new a();
		        			d.setVisible(true);
		        			}
		        	}
		        		} catch (InterruptedException e) {
		        			e.printStackTrace();
		        			}}
					}
					}
		        input.close();
			    } catch (Exception err) {
		        err.printStackTrace();
		    }
		}
	}
}