package net_p;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiCastReceiverMain extends JFrame {
	
MulticastSocket userPort;
InetAddress userIP;

	class ChatReceiver extends Thread {
		
		MulticastSocket ms = null;
		InetAddress addr = null;
		
		@Override
		public void run() {
		
			try {
				ms = new MulticastSocket(Integer.parseInt( port.getText()));
				
				addr = InetAddress.getByName(ip.getText());
				ms.joinGroup(addr);
				
				while(true) {
					byte [] buf = new byte[1024];
					
					DatagramPacket data = new DatagramPacket(buf, buf.length);
					ms.receive(data);
					
					chatLog.append(data.getAddress()+":"+new String(buf)+"\n");	// JFrame에 채팅 보내기 위해
					chatLog.setCaretPosition(chatLog.getDocument().getLength());
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				try {
					ms.leaveGroup(addr);
					ms.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	JButton btn;
	JLabel ipip, poport;
	JTextArea chatLog;
	JTextField ip, port, chat; 
	ChatReceiver cr;
	
	public MultiCastReceiverMain() {//몸통을 만들자
		
		setBounds(50,50,400,600);
		
		ipip = new JLabel("ip주소");
		poport = new JLabel("포트번호");
		
		ip = new JTextField();
		ip.setPreferredSize(new Dimension(90,30));
		
		port = new JTextField();
		port.setPreferredSize(new Dimension(90,30));
		
		btn = new JButton("연결");
		
		JPanel jp = new JPanel();
		
		jp.add(ipip);
		jp.add(ip);
		jp.add(poport);
		jp.add(port);
		jp.add(btn);
		add(jp,"North");
		
		chatLog = new JTextArea();
		chatLog.setEditable(false);
		add(new JScrollPane(chatLog),"Center");
		
		chat = new JTextField();
		chat.setEditable(false);
		add(chat,"South");
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		chat.addActionListener(new ActionListener() {
			//채팅을 치고 엔터를 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					byte [] buf = chat.getText().getBytes();
					
					DatagramPacket data = new DatagramPacket(
							buf, 
							buf.length, 
							userIP, 
							Integer.parseInt(port.getText()) );
					
					userPort.send(data);
					
					chatLog.append("[나]:"+chat.getText()+"\n");
					chatLog.setCaretPosition(chatLog.getDocument().getLength());
					
					chat.setText("");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		btn.addActionListener(new ActionListener() {
			//ip랑 port입력하고 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn.getText().equals("연결")) {
					//연결을 누르면
					System.out.println("Ip주소 : "+ip.getText());
					System.out.println("포트번호 : "+port.getText());
					
					try {
						userIP = InetAddress.getByName(ip.getText());
						userPort = new MulticastSocket();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cr = new ChatReceiver(); //채팅을 보내는 메소드로가자
					cr.start();
					
					ip.setEditable(false);
					port.setEditable(false);
					
					btn.setText("연결종료");
					
					chat.setEditable(true);
					chat.requestFocus();
						
				}
				else {
					//연결종료를 누르면
					userPort.close();
					userPort = null;
					
					cr.stop();
					cr.ms.close();
					cr.ms=null;
					
					chat.setEditable(false);
					ip.setEditable(true);
					port.setEditable(true);
					btn.setText("연결");
				}
			}
		});
	}

	public static void main(String[] args) {
		new MultiCastReceiverMain(); //몸통을 만들자
	}

}
