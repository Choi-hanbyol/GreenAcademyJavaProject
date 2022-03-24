package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TCPSingleSender extends Thread{
	String name;
	DataOutputStream dos;
	public TCPSingleSender(Socket soc) {
		try {
			name = "["+InetAddress.getLocalHost()+"]";
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
				dos.writeUTF(name+str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}





class TCPSingleFrame extends JFrame implements ActionListener{
	
	String name;
	DataOutputStream dos;
	DataInputStream dis;
	
	JTextArea ta;
	JTextField tf;
	
	class TCPSingleReceiver extends Thread{
		
		@Override
		public void run() {
			try {
				while(dis!=null) {
					//System.out.println(dis.readUTF());
					ta.append(dis.readUTF()+"\n");
					ta.setCaretPosition(ta.getDocument().getLength());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public TCPSingleFrame(Socket soc,String title) {
		super(title);
		//jframe 이름
		try {
			name = "["+InetAddress.getLocalHost()+"]";
			//name에 유저IP주소를 저장
			dos = new DataOutputStream(soc.getOutputStream());
			//서버->유저들에게 채팅내역을 보내기위한 빨대 생성
			dis = new DataInputStream(soc.getInputStream());
			//유저->서버한때 자신의 채팅을 보내기 위한 빨대 생성
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		setBounds(50, 50, 400,500);
		//jframe의 크기와 띄워지는 위치 조정
		ta = new JTextArea();
		//채팅이 출력되는 곳 생성
		tf = new JTextField();
		//채팅을 입력하는 곳 생성
		ta.setEditable(false);
		//ta는 수정이 안되게 설정
		add(new JScrollPane(ta),"Center");
		//jframe에 ta를 넣고 ta에 스크롤바를 추가해주고 위치를 센터로 고정
		add(tf,"South");
		//jframe에 tf를 넣고 위치를 남(아래)쪽으로 소정
		
		setVisible(true);
		//jframe을 보여주게하는것
		tf.requestFocus();
		//tf를 우선적으로 쓸수있게 해주는 역할
		tf.addActionListener(this);
		//tf에 액션을 동작을 할 수 있게 해줌
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//x누르면 창이 꺼지고 프로그램도 꺼지도록 설정
		
		new TCPSingleReceiver().start();
		//    요 안에 있는 		run()을 실행해라
	}

	@Override
	public void actionPerformed(ActionEvent e) {//entet누르면 실행
		//액션을 설정
		String msg = tf.getText();
		//msg에 채팅창에 입력한 내용을 저장
		//System.out.println(msg);
		
		ta.append("[나] "+msg+"\n");
		//ta 채팅기록 누적을 위한것
		ta.setCaretPosition(ta.getDocument().getLength());
		//아래로 스크롤하기 위함
		try {
			dos.writeUTF(name+">"+msg);
			//유저들이 입력한 채팅을 보여주는 역할
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tf.setText("");
		tf.requestFocus();
		//위에 두 구문은 엔터치고 기존에 썼던거 날려버리는 역할
		
		
	}
}



public class TCPSingleServerMain {

	public static void main(String[] args) {

		try {

			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			System.out.println("서버 : "+client.getInetAddress()+" 접속성공");
			
		
			new TCPSingleFrame(client,"서버");
			//new TCPSingleSender(client).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
