package lab5tel;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		DatagramSocket ds;
		try {
			ds = new DatagramSocket();
			System.out.println("Print a message(int str): ");
			Scanner scn = new Scanner(System.in);
			String msg = scn.nextLine();
			msg = msg + " ";
			byte[] b = msg.getBytes();
			InetAddress host = InetAddress.getByName("localhost");
			int sock = 1050;
			DatagramPacket dp = new DatagramPacket(b, b.length, host, sock);
			ds.send(dp);
			scn.close();

			while (true) {
				byte[] buffer = new byte[1024];
				DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				ds.receive(reply);
				if(new String(reply.getData()).equals("")) break;
				System.out.println(new String(reply.getData()));
			}
			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}