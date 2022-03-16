package javaProject1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class CardLayoutTest extends JFrame {
	
	class NextButton extends JButton implements ActionListener{

		public NextButton() {
			super(">>");
			addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

//			JButton a = (JButton)e.getSource();
//			JPanel b = (JPanel)a.getParent();
			
			card.show(clt.getContentPane(), arr.indexOf((JPanel)((JButton)e.getSource()).getParent())+1+"");
		}
		
	}
	
	static CardLayoutTest clt;
	CardLayout card;
	ArrayList<JPanel> arr;
	
	Color[] colors = {
			Color.blue,
			Color.red,
			Color.yellow,
	};

	public CardLayoutTest() {
		super("카드레이아웃 테스트");
		
		setBounds(50, 50, 600, 800);
		
		card = new CardLayout();
		setLayout(card);
		
		arr = new ArrayList<JPanel>();
		
		
		
		for (int i = 0; i < colors.length; i++) {
			JPanel jp = new JPanel();
			jp.setBackground(colors[i]);
			arr.add(jp);
			add(jp, i+"");
			jp.add(new NextButton());
		}
	
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		clt = new CardLayoutTest();
		
	}

}