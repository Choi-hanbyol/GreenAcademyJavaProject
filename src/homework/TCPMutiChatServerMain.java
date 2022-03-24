package homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatFrame extends JFrame {
	String id;
	DataOutputStream dos;
	DataInputStream dis;
	
	JTextArea ta;
	JTextField tf;
	JOptionPane op = new JOptionPane();
}

public class TCPMutiChatServerMain {

	HashMap<String, DataOutputStream> list;
	
	public TCPMutiChatServerMain() {
		try {
			list = new HashMap<String, DataOutputStream>();
			
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
				sendToAll(name+" 접속",dos);
				list.put(name, dos);
				sendToAll("[현재 접속자 수]"+list.size(),dos);

				while(dis!=null) {
					sendToAll(dis.readUTF(),dos);	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				list.remove(dos);
				sendToAll(name+" 퇴장",dos);
				sendToAll("[현재 접속자 수]"+list.size(),dos);
			}
		}
	}
	
	void sendToAll(String msg, DataOutputStream dos) {
		for (DataOutputStream dd : list.values()) {
			try {
				dd.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void earChat(String msg, DataOutputStream dos) {
		
		for(DataOutputStream dd : list.values()) {
			
		}
	}
	
	
	
	public static void main(String[] args) {
		
		new TCPMutiChatServerMain();

	}

}
