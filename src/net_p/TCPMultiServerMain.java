package net_p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPMultiServerMain {//서버를 여는 클래스

	ArrayList<DataOutputStream> list;
	//서버가 유저에게 보내는 역할을 하는 빨대를 저장할수있는 list를 생성
	
	public TCPMultiServerMain() {
		try {
			list = new ArrayList<DataOutputStream>();
			//서버가 유저에게 보내는 역할을 하는 빨대를 저장할수있는 list를 생성
			ServerSocket server = new ServerSocket(8888);
			//8888 포트를 연다
			System.out.println("서버시작");
			//서버시작이란 글을 콘솔에 출력한다
			while(true) { //무한반복
				Socket client = server.accept();
				//채팅할 유저를 받는다
				new TCPMulSeverReceiver(client).start();
				//       유저가 들어오면 실행         run()실행
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class TCPMulSeverReceiver extends Thread{// 유저들을 받는 역할을 하는 클래스
		
		DataInputStream dis;
		DataOutputStream dos;
		String name;
		
		public TCPMulSeverReceiver(Socket client) {
			try {
				dos = new DataOutputStream(client.getOutputStream());
				//서버->유저들에게 채팅내역을 보내기위한 빨대 생성
				dis = new DataInputStream(client.getInputStream());
				//유저->서버한때 자신의 채팅을 보내기 위한 빨대 생성
				name = "["+client.getInetAddress()+"]";
				//사용자들의 IP주소를 name에 저장
				System.out.println(name+"접속");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() { //실행
			try {
				//System.out.println("서버 리시버 시작");
				sendToAll(name+" 접속");
				//해당 서버에 있는 모두에게 누가 들어왔는지 알려주는거
				list.add(dos);
				//list에 서버가->유저 빨대를 저장
				sendToAll("[현재 접속자 수]"+list.size());
				//해당 서버에 있는 모두에게 몇명있는지 알려주는거
				while(dis!=null) {//유저->서버 빨대가 연결되있으면 계속실행/반대면 끝
					
					sendToAll(dis.readUTF());
					//유저들이 한 유저가 친 채팅을 모두에게 보낸다.
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally { //try,catch와 상관없이 반드시 진행되는곳
				list.remove(dos);
				//유저가 나가면 서버가 그 유저에게 연결된 빨대를 제거
				sendToAll(name+" 퇴장");
				//서버에 있는 모두에게 나간 사람 알려주는거
				sendToAll("[현재 접속자 수]"+list.size());
				//서버에 있는 모두에게 서버에 누가 남았는지 알려주는거
			}
		}
	}
	
	void sendToAll(String msg) {//모든 유저에게 메세지보내는 메소드
		for (DataOutputStream dd : list) { //dd에 list(dos값)의 값을 순차적으로 대입
			try {
				dd.writeUTF(msg);
				//list에는 서버가 유저들에게 보내는 역할을 하는 빨대가 있음
				//그래서 위에 구문은 모두에게 한 유저가 쓴 채팅을 모두에게 띄워주는 역할을 함
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	void earchat(username,msg) {
//		
//	}
	
	public static void main(String[] args) {
		
		new TCPMultiServerMain(); //클래스 호출

	}

}
