package proc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ProcessList {
	public static void main(String[] args) {
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
		        	if(s[i].equals("smss.exe")){
					JOptionPane.showMessageDialog(null, "SES");
					}
					}
		        	System.out.println(line);
			        }
		        input.close();
			    } catch (Exception err) {
		        err.printStackTrace();
		    }
	}}