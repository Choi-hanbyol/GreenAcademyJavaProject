package javaProject1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class CardLayoutTest2 extends JFrame {

	public CardLayoutTest2() {
		
		super("Test2");
		
		setBounds(200, 100, 600, 800);
		setLayout(null);
		
		JPanel up = new JPanel();
		up.setBounds(0, 0, 600, 600);
		CardLayout upCard = new CardLayout();
		up.setLayout(upCard);
		
		ArrayList<JPanel> upJpanel = new ArrayList<JPanel>();
		
		for (int i = 0; i < 5; i++) {
			JPanel jp = new JPanel();
			jp.add(new JLabel(i+""));
			jp.setBackground(Color.lightGray);
			jp.setName(i+"");
			up.add(jp, i+"");
			upJpanel.add(jp);
		}
		
		Collections.shuffle(upJpanel);
		
		JPanel down = new JPanel();
		down.setBounds(0, 600, 600, 200);
		CardLayout downCard = new CardLayout();
		down.setLayout(downCard);
		
		
		for (int i = 0; i < 5; i++) {
			JPanel jp = new JPanel();
			jp.add(new JLabel(i+""));
			jp.setBackground(Color.pink);
			jp.setName(i+"");
			down.add(jp, i+"");
		}
		
		add(up);
		add(down);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for (int i = 0; i < upJpanel.size(); i++) {
			String name = upJpanel.get(i).getName();
			upCard.show(up, name);
			downCard.show(down, i+"");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new CardLayoutTest2();
	}
}