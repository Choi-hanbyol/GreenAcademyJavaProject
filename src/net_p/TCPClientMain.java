package net_p;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPClientMain {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.150.55",8888);
			System.out.println("클라이언트 : 접속성공!!!");
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			System.out.println("클라이언트 : "+dis.readUTF());
			
			dis.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
