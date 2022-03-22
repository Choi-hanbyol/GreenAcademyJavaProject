package net_p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPMultiServerMain {

	ArrayList<DataOutputStream> list;
	
	public TCPMultiServerMain() {
		try {
			list = new ArrayList<DataOutputStream>();
			
			ServerSocket server = new ServerSocket(8888);
			System.out.println("서버시작");
			
			while(true) {
				Socket client = server.accept();

				new TCPMulSeverReceiver(client).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class TCPMulSeverReceiver extends Thread{
		DataInputStream dis;
		DataOutputStream dos;
		String name;
		
		public TCPMulSeverReceiver(Socket client) {
			try {
				dos = new DataOutputStream(client.getOutputStream());
				dis = new DataInputStream(client.getInputStream());
				name = "["+client.getInetAddress()+"]";
				System.out.println(name+"접속");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				//System.out.println("서버 리시버 시작");
				sendToAll(name+" 접속");
				list.add(dos);
				sendToAll("[현재 접속자 수]"+list.size());
				while(dis!=null) {
					
						sendToAll(dis.readUTF());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				list.remove(dos);
				sendToAll(name+" 퇴장");
				sendToAll("[현재 접속자 수]"+list.size());
			}
		}
	}
	
	void sendToAll(String msg) {
		for (DataOutputStream dd : list) {
			try {
				dd.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		new TCPMultiServerMain();

	}

}
