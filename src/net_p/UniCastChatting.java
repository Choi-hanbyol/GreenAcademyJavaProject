package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UniCastChatting extends JFrame{
	
	DatagramSocket sender_socket = null;
	InetAddress sender_addr;
	

	class UniReceiver extends Thread{
		DatagramSocket socket = null;
		
		@Override
		public void run() {
			
			try {
				socket = new DatagramSocket( Integer.parseInt(port.getText()) );
				while(true) {
									
					byte [] buf = new byte[1024];
					
					DatagramPacket dp = new DatagramPacket(buf, buf.length);
					
					socket.receive(dp);

					String msg = new String(buf);
					
					//System.out.println(dp.getAddress()+":"+msg);
					ta.append(dp.getAddress()+":"+msg+"\n");
					ta.setCaretPosition(ta.getDocument().getLength());
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		}
	}
	
	JTextField ip, port, tf;
	JTextArea ta;
	JButton btnChat;
	
	//UniSender us;
	UniReceiver ur;
	
	public UniCastChatting() {
		
		setBounds(50, 50, 400, 600);
		
		ip = new JTextField("192.168.150.54");
		port = new JTextField("8888");
		btnChat = new JButton("연결");
		
		JPanel np = new JPanel();
		np.add(ip);
		np.add(port);
		np.add(btnChat);
		
		add(np,"North");
		
		ta = new JTextArea();
		ta.setEditable(false);
		add(new JScrollPane(ta),"Center");
		
		tf = new JTextField();
		tf.setEditable(false);
		add(tf,"South");
		
		

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(btnChat.getText().equals("연결종료")) {
					try {
						byte [] buf = tf.getText().getBytes();
						
						DatagramPacket data = new DatagramPacket(
								buf, 
								buf.length, 
								sender_addr, 
								Integer.parseInt(port.getText()) );
						
						sender_socket.send(data);
						
						ta.append("[나]:"+tf.getText()+"\n");
						ta.setCaretPosition(ta.getDocument().getLength());
						
						tf.setText("");
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	
			}
		});
		
		
		btnChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(btnChat.getText().equals("연결")) {
				
					
					try {
						sender_socket = new DatagramSocket();
						sender_addr = InetAddress.getByName(ip.getText());
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					ur = new UniReceiver();
					ur.start();
					
					ip.setEditable(false);
					port.setEditable(false);
					
					btnChat.setText("연결종료");
					
					tf.setEditable(true);
					tf.requestFocus();
					
				}else {
					//us.stop();
					sender_socket.close();
					sender_socket = null;
					
					ur.stop();
					ur.socket.close();
					ur.socket = null;
					
					ip.setEditable(true);
					port.setEditable(true);
					
					tf.setEditable(false);
					
					btnChat.setText("연결");
				}
				
			}
		});
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		new UniCastChatting();
	}

}
