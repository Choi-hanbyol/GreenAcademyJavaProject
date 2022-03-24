package net_p;

import java.io.IOException;
import java.net.Socket;

public class TCPSingleClientMain {

	public static void main(String[] args) {
		try {
			String addr = "192.168.150.50"; //IP채팅방 주소
			Socket socket = new Socket(addr, 8888); //채팅방 입장해주는 역할
			System.out.println("클라이언트 : "+addr+"접속 성공");
			//콘솔창에 해당 클라이언트가 어떤IP주소에 접속했는지 출력하는곳
			
//			System.out.println("게스트"+i+" 입장");
			new TCPSingleFrame(socket,"클라이언트");
			//채팅창을 띄어주는 객체생성(이 객체에는 socket과 "클라이언트"기 포함되있다.)
			
			//new TCPSingleSender(socket).start();
			//new TCPSingleReceiver(socket).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
