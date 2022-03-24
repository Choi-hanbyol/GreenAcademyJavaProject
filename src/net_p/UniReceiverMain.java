package net_p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class UniReceiverMain {

	public static void main(String[] args) {
		
		try {
			while(true) {
				DatagramSocket socket = new DatagramSocket(8888);
				
				byte [] buf = new byte[1024];
				
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				
				
				socket.receive(dp);

				socket.close();
				
//				System.out.println(dp.getAddress());
//				System.out.println(Arrays.toString(buf));
				String msg= new String(buf);
//				System.out.println("수신된 메세지 : "+msg);
				System.out.println(dp.getAddress()+"에게서 수신된 메세지 : "+msg);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
