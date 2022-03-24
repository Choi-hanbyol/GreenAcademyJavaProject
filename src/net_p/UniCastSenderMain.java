package net_p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UniCastSenderMain {

	public static void main(String[] args) {
		try {
			
			String msg = "노트북은 다 49로가서 ";
			
			byte [] buf = msg.getBytes();
			
			InetAddress addr = InetAddress.getByName("192.168.150.50");
			
			DatagramPacket data = new DatagramPacket(buf, buf.length, addr, 8888);
			
			DatagramSocket socket = new DatagramSocket();
			
			socket.send(data);
			
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sender 전송완료");
	}

}
