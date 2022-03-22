package net_p;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMain {

	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			
			server = new ServerSocket(8888);
			while(true) {
				System.out.println("서버는 돈다...!!!");
				Socket client = server.accept();
				
				System.out.println("서버 : 클라이언트 접속성공!!!");
				
				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.writeUTF("형님들 오점뭐??????");
				
				
				dos.close();
				os.close();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}