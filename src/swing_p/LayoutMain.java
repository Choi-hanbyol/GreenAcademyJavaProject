package swing_p;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutMain {

	public static void main(String[] args) {
		
		JFrame f1 = new JFrame("border");
		f1.setLayout(new BorderLayout());
//		f1.setLayout(null);
//		f1.setLayout(new FlowLayout());
		f1.setBounds(0,0,300,200);
		
		f1.add("North",new JButton("북쪽"));
		f1.add(new JButton("동쪽"),"East");
		f1.add(new JButton("남쪽"),"South");
		f1.add(new JButton("서쪽"),"West");
		f1.add("Center",new JButton("중앙"));

		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//flowLayout
		JFrame f2 = new JFrame("Flow");
		f2.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10)); //(방향,간격,간격)
		f2.setBounds(300,0,300,200);
		
		for(int i = 0; i < 10; i++) {
			f2.add(new JButton("버튼"+i));
		}

		f2.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//gridLayout
		JFrame f3 = new JFrame("Grid");
		f3.setLayout(new GridLayout(3,2,10,5)); //(행,열,간격,간격)
		f3.setBounds(0,200,300,200);
		
		for(int i = 0; i < 10; i++) {
			f3.add(new JButton("버튼"+i));
		}

		f3.setVisible(true);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//boxLayout
		JFrame f4 = new JFrame("Box");
		f4.setLayout(new BoxLayout(f4.getContentPane(),BoxLayout.X_AXIS));
		f4.setBounds(300,200,300,200);
		
		for(int i = 0; i < 10; i++) {
			f4.add(new JButton("버튼"+i));
		}

		f4.setVisible(true);
		f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//cardLayout
		JFrame f5 = new JFrame("Card");
		CardLayout card = new CardLayout();
		f5.setLayout(card);
		f5.setBounds(600,200,300,200);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.red);
		f5.add(p1,"빨강이");
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.blue);
		f5.add(p2,"파랑이");
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.yellow);
		f5.add(p3,"노랑이");
		
		
		
		f5.setVisible(true);
		f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String [] arr = {"빨강이","파랑이","노랑이"};
		int i = 0;
		while(true) {
			i++;
			i%=3;
			card.show(f5.getContentPane(), arr[i]);
	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
