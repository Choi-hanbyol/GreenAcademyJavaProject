package net_p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class TCPSingleSender extends Thread {
	String name;
	DataOutputStream dos;
	
	public TCPSingleSender(Socket soc) {
		try {
			name="["+InetAddress.getLocalHost()+"]";
			dos = new DataOutputStream(soc.getOutputStream());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			while(dos!=null) {
				String str = sc.nextLine();
				dos.writeUTF(name+" : "+str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class TCPSingleReceiver extends Thread {
	DataInputStream dis;
	
	public TCPSingleReceiver(Socket soc) {
		try {
			dis = new DataInputStream(soc.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try {
			while(dis!=null) {
				System.out.println(dis.readUTF());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


public class TCPSingleServerMain {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			System.out.println("서버 : "+client.getInetAddress()+"접속성공");
			
			new TCPSingleSender(client).start();
			new TCPSingleReceiver(client).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
