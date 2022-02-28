package swing_p;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventMain2 extends JFrame implements WindowListener{
	
	JButton btn = new JButton("눌러바");
	JLabel lb = new JLabel("최한별 만세2");
	
	//이벤트핸들러 클래스 정의 -> ActionListener : 리스너에 해당하는 인터페이스
	class MyBtnList implements ActionListener{
		
		//JLabel label;
		//JButton button;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("눌렀다2");
			lb.setText("전문기 만세2");
			lb.setBackground(Color.blue);
			lb.setForeground(Color.white);
			btn.setEnabled(false);	
		}
		
		
	}
	
	public EventMain2() {
		super("이벤트 발생2");
		setBounds(50, 50, 300,200);
		setLayout(new FlowLayout());
		
		lb.setOpaque(true);
		
		add(btn);
		add(lb);
		
		 MyBtnList mbl = new MyBtnList();
		 //mbl.label = lb;
		 //mbl.button = btn;
		 
		//btn:이벤트소스       				--> 버튼
		//addActionListener : 이벤트 리스너 --> 을 누르면
		//mbl : 이벤트 핸들러               --> actionPerformed: 눌렀다 출력
		btn.addActionListener(mbl);
		
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//창제어 리스너
		addWindowListener(this);
	}

	public static void main(String[] args) {
		new EventMain2();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent e) {

		System.out.println("창 닫힐라구요");
//		e.getWindow().dispose(); //컨테이너 종료
		dispose();
		
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
