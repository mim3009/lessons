package lab4tel;

import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] ar) {
		int port = 6666;
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Server bound");
			Socket socket = ss.accept();

			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();
			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);

			String line = null;
			while (in != null) {
				line = in.readUTF();
				if(line.equals("exit")) break;
				System.out.println("client send the line: " + line);
				System.out.println("sending line back");
				out.writeUTF(line);
				out.flush();
			}
			ss.close();
			socket.close();
			in.close();
			out.close();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}