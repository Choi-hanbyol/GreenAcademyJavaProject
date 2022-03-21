package net_p;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InfoMain {

	public static void main(String[] args) {
		/*
		 빅엔디안 리틀엔디안
		 a,b,c,d -> 네트워크(IBM)
		 d,c,b,a -> MS(인텔)
		*/
		
		try {
			InetAddress addr = InetAddress.getByName("www.naver.com");
			System.out.println(addr);
			System.out.println(addr.getHostName());
			System.out.println(addr.getHostAddress());
			
			System.out.println("===================================");
			
			InetAddress [] addrs = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress ia : addrs) {
				System.out.println(ia);
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
