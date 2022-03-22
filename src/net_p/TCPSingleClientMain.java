package net_p;

import java.io.IOException;
import java.net.Socket;

public class TCPSingleClientMain {

	public static void main(String[] args) {
		
		try {
			String addr = "192.168.20.22";
			Socket socket = new Socket(addr,8888);
			System.out.println("클라이언트 : "+addr+" 서버접속성공");
			
			new TCPSingleSender(socket).start();
			new TCPSingleReceiver(socket).start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
