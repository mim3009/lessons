package roman.zhuhylskiy.stu.cn.ua;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		int port = 1781;
		int serverPort = 3001;
		String address = "127.0.0.1";
		try{
			InetAddress ipAddress = InetAddress.getByName(address);
			Socket socket2 = new Socket(ipAddress, serverPort);
			OutputStream sout = socket2.getOutputStream();
			DataOutputStream out = new DataOutputStream(sout);
			
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Waiting for a client...");
			Socket socket = ss.accept();
			System.out.println("New Client");
			InputStream input = socket.getInputStream();
			
			while(true){
				String inputString = Server.inputStreamAsString(input);
			    System.out.println(inputString);
			    Thread.sleep(5000); 
				out.writeBoolean(true);
			    out.flush(); 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

    public static String inputStreamAsString(InputStream stream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        br.close();
        return sb.toString();
    }
}
