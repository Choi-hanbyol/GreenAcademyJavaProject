package net_p;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MultiCastSenderMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			while(true) {
				MulticastSocket ms = new MulticastSocket();
				String msg = sc.nextLine();
				byte [] buf = msg.getBytes();
				
				InetAddress addr = InetAddress.getByName("230.0.0.1");
				
				DatagramPacket data = new DatagramPacket(
						buf, 
						buf.length, 
						addr, 
						8888);
				
				ms.send(data);
			}
			
//			ms.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
