package lab6tel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 4444);
			Scanner scn = new Scanner(System.in);
			System.out.println("Write a name: ");
			String name = scn.nextLine();
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("Print some text: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String rI = br.readLine();
				pw.println(name + ": " + rI);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
