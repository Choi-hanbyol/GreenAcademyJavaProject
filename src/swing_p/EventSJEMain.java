package swing_p;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class EventSJEMain extends JFrame implements ActionListener{
	
	JLabel timerLB = new JLabel("시간 : ");
	JLabel res = new JLabel("결과 : ");
	JButton btn = new JButton("시험제출");
	ArrayList<JRadioButton>qq1 = new ArrayList<JRadioButton>();
	ArrayList<JCheckBox>qq2 = new ArrayList<JCheckBox>();
	boolean chk = false;
	
	class Timer extends Thread{
		@Override
		public void run() {
			for(int i = 10; i>=0; i--) { 
					
				
					try {
						sleep(1000);
						timerLB.setText("시간 : "+i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				
			}
			btn.setEnabled(false);
			if(!chk) {
			res.setText("시간초과");
			}
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		chk=true;
		int jum = 0;
		if(qq1.get(1).isSelected()) {
			jum+=20;

		}
		for(JCheckBox box : qq2) {
			if(box.isSelected()) {
				jum+=20;
			}
		}
		res.setText("시험종료 :"+jum);
		timerLB.setText("시험종료");
		
		
	}
	
	public EventSJEMain() {
		super("송지은 퀴즈");
		setBounds(50, 50, 400, 600);
		setLayout(new GridLayout(13, 1));
		timerLB.setHorizontalAlignment(JLabel.RIGHT);
		add(timerLB);
		//1번문제
		add(new JLabel("송지은의 특기는?"));
		
		ButtonGroup bg = new ButtonGroup();
		for (String tt : "잠자기,코딩,누워있기,전문기놀리기".split(",")) {
			JRadioButton rb1 = new JRadioButton(tt);
			qq1.add(rb1);
			bg.add(rb1);
			add(rb1);
			
			btn.addActionListener(this);
		}
		
		//2번 문제
		add(new JLabel("송지은의 취미는?"));
		
		for (String tt : "야구시청, 코노가기, 넷플릭스시청".split(",")) {
			JCheckBox rb1 = new JCheckBox(tt);
			qq2.add(rb1);
			//bg.add(rb1);
			add(rb1);
		}
		
		add(btn);
		add(res);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Timer timer = new Timer();
		timer.start();
		
	}
	
	public static void main(String[] args) {
		
		new EventSJEMain();
	}
}
