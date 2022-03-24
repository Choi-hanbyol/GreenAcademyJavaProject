package net_p;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



class TCPMulFrame extends JFrame implements ActionListener {
	
	String name;
	ObjectOutputStream dos;
	ObjectInputStream dis;
	JTextArea ta;
	JTextField tf,ipAddress,nickname,port;
	JComboBox<String> dstTF;
	JButton jb;
	String userIP;
	int userPort;
	class TCPSingleReceiver extends Thread{//-> 6.유저가 입력한 채팅을 창에 보여준다.
		
		@Override
		public void run() {
			try {
				TCPChatData first = new TCPChatData();
				first.src = name;
				first.dst = "서버";
				first.msg = "서버는 처음이야";
				dos.writeObject(first);
				dos.flush();
				dos.reset();
				
				while(dis!=null) {
					//System.out.println(dis.readUTF());
					TCPChatData data = (TCPChatData)dis.readObject();
					System.out.println(data);
					
					if(data.dst.equals("서버")) {
						//화면을 갱신해주셈
						dstTF.removeAllItems();
						dstTF.addItem("a");
						
						for (String vv: data.mems) {
							dstTF.addItem(vv);	
						}
						
						getContentPane().revalidate();
					}
					
					
					if(name.equals(data.src)) {
						ta.append("[나]"+data.msg+"\n");
					}else {
						ta.append("["+data.src+"]"+data.msg+"\n");
					}
					
					
					ta.setCaretPosition(ta.getDocument().getLength());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public TCPMulFrame() { //-> 2. 여기서 채팅창을 띄워준다.
		super("채팅방");	
		
		setBounds(50, 50, 500,500);
		ta = new JTextArea();
		ta.setEditable(false);
		
		tf = new JTextField();
		jb = new JButton("연결");

		
		Vector<String>items = new Vector<String>();
		items.add("a");
//		items.add("현석");
//		items.add("찬욱");
//		items.add("경준");
		dstTF = new JComboBox<String>(items);
		
		dstTF.setPreferredSize(new Dimension(100, 50));
		tf.setPreferredSize(new Dimension(270, 50));
		
		
		add(new JScrollPane(ta),"Center");
		JPanel jp = new JPanel();
		JPanel jjp = new JPanel();
		JLabel jl = new JLabel("ip");
		JLabel j2 = new JLabel("닉네임");
		JLabel j3 = new JLabel("포트");
		ipAddress = new JTextField();
		nickname = new JTextField();
		port = new JTextField();
		ipAddress.setPreferredSize(new Dimension(100, 30));
		nickname.setPreferredSize(new Dimension(100, 30));
		port.setPreferredSize(new Dimension(40, 30));
		jjp.add(jl);
		jjp.add(ipAddress);
		
		jjp.add(j2);
		jjp.add(nickname);
		
		jjp.add(j3);
		jjp.add(port);
		
		jjp.add(jb);
		
		
		jp.add(dstTF);
		jp.add(tf);
		add(jp,"South");
		add(jjp,"North");
		
		setVisible(true);
		
		tf.requestFocus();
		tf.addActionListener(this);
		jb.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==jb) { //연결 버튼 누르면
			System.out.println("IP주소->"+ipAddress.getText());
			//textfield에 입력한 ip주소
			System.out.println("닉네임->"+nickname.getText());
			//textfield에 입력한 닉네임
			System.out.println("포트번호->"+port.getText());
			//textfield에 입력한 포트번호
			userIP = ipAddress.getText(); //ip주소 저장
			name = nickname.getText(); //유저 닉네임 저장
			userPort = Integer.parseInt(port.getText()); //포트번호 저장
			//각각의 textfield에 입력받은 값을 변수들에 저장
			new LoginProcess(); //-> 3.로그인으로 가자
			//위에 저장한 정보를 가지고 로그인을 진행하는 클래스로 갑시다.
		}
		else {
			try {
				//dos.writeUTF(msg);
				TCPChatData data = new TCPChatData();
				
				//String [] arr = msg.split("_");
				//data.dst = arr[0];
				//data.msg = arr[1];
				
				data.src = name;
				data.dst = (String)dstTF.getSelectedItem();
				data.msg = tf.getText();
				
				dos.writeObject(data);
				dos.flush();
				dos.reset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			tf.setText("");
			tf.requestFocus();
		}
	}
	class LoginProcess {// 여기가 로그인관련 클래스
		
		public LoginProcess() { //-> 4. 로그인정보를 가지고 서버 접속
			try {
				Socket socket = new Socket(userIP,userPort);
				System.out.println("클라이언트 : "+userIP+"접속 성공");
				dos = new ObjectOutputStream(socket.getOutputStream());
				
				dis = new ObjectInputStream(socket.getInputStream());
				
				new TCPSingleReceiver().start(); //-> 5.채팅정보 보내기 실행
				
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}



public class MutiChatUserMain {

	public static void main(String[] args) {
		new TCPMulFrame(); //-> 1. 여기서 jframe으로 먼저 간다.

	}

}
