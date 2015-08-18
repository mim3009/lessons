package lab4tel;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
	public static void main(String[] ar) {
		int serverPort = 6666;
		String address = "127.0.0.1";
		try {
			InetAddress ipAddress = InetAddress.getByName(address);
			Socket socket = new Socket(ipAddress, serverPort);

			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();
			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);

			Scanner scn = new Scanner(new InputStreamReader(System.in));
			String line = null;
			System.out.println("Type something: ");

			while (in != null) {
				line = scn.nextLine();
				if(line.equals("exit")) break;
				System.out.println("Sending line to the server");
				out.writeUTF(line);
				out.flush();
				line = in.readUTF();
				System.out.println("Server send: " + line);
				System.out.println("Type next message for server: ");
			}
			scn.close();
			socket.close();
			in.close();
			out.close();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}