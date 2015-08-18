package fileIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputText {
	
	public static void main(String[] args){
		String str = "";
		int c;
		try{
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("res/text.txt")));
			while((c = in.read()) >= 0){
				str += (char)c;
			}
			in.close();
			System.out.println(str);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
}
