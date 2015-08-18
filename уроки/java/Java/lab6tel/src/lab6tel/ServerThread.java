package lab6tel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
	Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run(){
		String msg = null;
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((msg = bf.readLine())!=null){
				System.out.println("Client send message: " + msg);
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
