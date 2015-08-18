package lab5tel;

import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(1050);
			System.out.println("Server bound");
			byte[] buffer = new byte[1024];
			while (true) {
				DatagramPacket request = new DatagramPacket(buffer,
						buffer.length);
				ds.receive(request);
				System.out.println(new String(request.getData()));
				String[] arrMsg = (new String(request.getData())).split(" ");
				byte[] sendMsg = (arrMsg[1] + " server answer").getBytes();
				int ss = Integer.parseInt(arrMsg[0]);
				for (int i = 0; i < ss; i++) {
					DatagramPacket reply = new DatagramPacket(sendMsg,
							sendMsg.length, request.getAddress(), request.getPort());
					ds.send(reply);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
