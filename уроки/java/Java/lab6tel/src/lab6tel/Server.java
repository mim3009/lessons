package lab6tel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PORT = 4444;

	public static void main(String[] args) {
		new Server().runServer();
	}

	public void runServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Server bound");
			while (true) {
				Socket socket = serverSocket.accept();
				new ServerThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
