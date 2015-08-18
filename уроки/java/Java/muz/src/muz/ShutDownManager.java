package muz;
import java.io.IOException;
public class ShutDownManager {
	public static void shutDownSystem() 
	{
			String[] commands = { "shutdown", "-r" }; 
			try {
				Process process = Runtime.getRuntime().exec( commands );
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
		}		
	}
