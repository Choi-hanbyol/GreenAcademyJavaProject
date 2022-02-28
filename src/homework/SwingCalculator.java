package homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingCalculator {

	public static void main(String[] args) {
		JFrame f1 = new JFrame("계산기");
		f1.setBounds(50,50,300,500);
		f1.setLayout(null);
		
		JMenuBar bar = new JMenuBar();
		f1.setJMenuBar(bar);
		
		//입력 창
		JLabel input = new JLabel("입력");
		input.setBounds(50,90,100,50);
		f1.add(input);
				
		JTextField t2 = new JTextField();
		t2.setBounds(90,90,200,50);
		f1.add(t2);
		
		//결과 창
		JLabel res = new JLabel("결과");
		res.setBounds(50,150,100,50);
		f1.add(res);
		
		JTextField t1 = new JTextField();
		t1.setBounds(90,150,200,50);
		f1.add(t1);
		
		//계산기 메뉴들
		JMenu type = new JMenu("표준계산기");
		bar.add(type);
		//표준계산기 안에 들어가는 소메뉴들
		ImageIcon icon1 = new ImageIcon("pic/enCal.png");
		JMenuItem m1 = new JMenuItem("공학용",icon1);
		type.add(m1);
		ImageIcon icon2 = new ImageIcon("pic/graph.png");
		JMenuItem m2 = new JMenuItem("그래프",icon2);
		type.add(m2);
		ImageIcon icon3 = new ImageIcon("pic/program.png");
		JMenuItem m3 = new JMenuItem("프로그래머",icon3);
		type.add(m3);
		ImageIcon icon4 = new ImageIcon("pic/date.png");
		JMenuItem m4 = new JMenuItem("날짜 계산",icon4);
		type.add(m4);
		type.addSeparator();//줄 긋기
		ImageIcon icon5 = new ImageIcon("pic/exchange.png");
		JMenuItem m5 = new JMenuItem("통화환율",icon5);
		type.add(m5);
		ImageIcon icon6 = new ImageIcon("pic/flask.png");
		JMenuItem m6 = new JMenuItem("부피",icon6);
		type.add(m6);
		ImageIcon icon7 = new ImageIcon("pic/ruler.png");
		JMenuItem m7 = new JMenuItem("길이",icon7);
		type.add(m7);
		
		//숫자패드를 넣기 위한 판넬
		JPanel p1 = new JPanel();
		p1.setBounds(0, 200, 300, 250);
		p1.setBackground(Color.gray);
		f1.add(p1);

		//숫자패드
		p1.setLayout(new GridLayout(5,4));
		String [] p1_button = {
				"%", "CE", "C", "%",
				"7", "8", "9", "x",
				"4", "5", "6", "-",
				"1", "2", "3", "+",
				" ", "0", ".", "="
		};
		for(int i=0; i<20; i++) {//버튼생성 for문
			p1.add(new JButton(p1_button[i]));
		}
		
		
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
