package swing_p;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FontColorMain extends JFrame{
	public FontColorMain() {
		
		setBounds(100,50,600,600);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		Font [] fs = ge.getAllFonts();
		for(Font ff:fs) {
			System.out.println(ff.getFontName());
		}
		
		String ttt = "그린 Com 01234 !@#$%^&";
		
		//JLabel lb = new JLabel(ttt);
		Font [] ff = {
				new Font("휴먼매직체",Font.ITALIC, 30),
				new Font("휴먼둥근헤드라인",Font.ITALIC, 30),
				new Font("휴먼둥근헤드라인",Font.BOLD, 30),
				new Font("휴먼둥근헤드라인",Font.PLAIN, 30),
				new Font("휴먼옛체",Font.ITALIC, 30),
				new Font("휴먼옛체",Font.BOLD, 30),
				new Font("휴먼옛체",Font.PLAIN, 30),
				new Font("휴먼옛체",Font.ITALIC+Font.BOLD, 30),
				new Font("휴먼편지체",Font.ITALIC, 50),
				new Font("휴먼편지체",Font.ITALIC, 30),
				new Font("휴먼편지체",Font.ITALIC, 10)
				};
		
		Color [] cc = {
				Color.BLUE,
				Color.YELLOW,
				Color.GREEN,
				Color.RED,
				new Color(255, 0, 0), //빨
				new Color(255, 130, 0), //주
				new Color(255, 228, 50), //노
				new Color(0, 180, 0), //초
				new Color(0, 0, 255), //파
				new Color(0, 0, 165), //남
				new Color(113, 18, 255) //보
		};
		
		setLayout(new GridLayout(ff.length, 1));
		
		for(int i = 0; i < ff.length; i++) {
			JLabel lb = new JLabel(ttt);
			lb.setFont(ff[i]);
			lb.setForeground(cc[i]);
			lb.setBackground(new Color(255,200,200));
			lb.setOpaque(true);
			add(lb);
		}
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//무지개를 만들자
		JFrame f1 = new JFrame("~~~무지개~~~");
		f1.setBounds(0,50,300,700);
		f1.setLayout(null);
		
//		Color [] rainbow= {
//				new Color(255, 0, 0), //빨
//				new Color(255, 130, 0), //주
//				new Color(255, 228, 50), //노
//				new Color(0, 180, 0), //초
//				new Color(0, 0, 255), //파
//				new Color(0, 0, 165), //남
//				new Color(113, 18, 255) //보
//		};
		
//		for(int i = 0; i < rainbow.length; i++) {
//			JButton rr = new JButton();
//			rr.setBackground(rainbow[i]);
//			rr.setBounds(50, 30, 100, 50);
//			f1.add(rr);
//		}

		JButton r1 = new JButton();
		r1.setBackground(new Color(255,0,0));//빨
		r1.setBounds(50, 30, 100, 50);
		
		JButton r2 = new JButton();
		r2.setBackground(new Color(255,130,30));//주
		r2.setBounds(50, 80, 100, 50);
		
		JButton r3 = new JButton();
		r3.setBackground(new Color(255, 228, 50));//노
		r3.setBounds(50, 120, 100, 50);
		
		JButton r4 = new JButton();
		r4.setBackground(new Color(0, 180, 0));//초
		r4.setBounds(50, 170, 100, 50);
		
		JButton r5 = new JButton();
		r5.setBackground(new Color(0, 0, 255));//파
		r5.setBounds(50, 220, 100, 50);
		
		JButton r6 = new JButton();
		r6.setBackground(new Color(0, 0, 165));//남
		r6.setBounds(50, 270, 100, 50);
		
		JButton r7 = new JButton();
		r7.setBackground(new Color(113, 18, 255));//보
		r7.setBounds(50, 320, 100, 50);
		
		f1.add(r1);
		f1.add(r2);
		f1.add(r3);
		f1.add(r4);
		f1.add(r5);
		f1.add(r6);
		f1.add(r7);
		f1.setVisible(true);
		//f1.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	
	public static void main(String[] args) {
		new FontColorMain();
		//무지개색을 표현하세요!
	}

}
