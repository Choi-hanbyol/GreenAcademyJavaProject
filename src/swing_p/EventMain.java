package swing_p;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


class MyBtnList implements ActionListener{
	
	JLabel label;
	JButton button;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("눌렀다");
		label.setText("전문기 만세");
		label.setBackground(Color.blue);
		label.setForeground(Color.white);
		button.setEnabled(false);
		
	}
}

public class EventMain {

	public static void main(String[] args) {
		JFrame f = new JFrame("이벤트 발생");
		f.setBounds(50, 50, 300, 200);
		f.setLayout(new FlowLayout());
		
		JButton btn = new JButton("눌러봐");
		JLabel lb = new JLabel("최한별 만세");
		lb.setOpaque(true);
		
		f.add(btn);
		f.add(lb);
		
		MyBtnList mbl = new MyBtnList();
		mbl.label  = lb;
		mbl.button = btn;
		
		//btn : 이벤트 소스 -> 버튼
		//addActionListener : 이벤트 리스너 -> 누른다
		//bml : 이벤트 핸들러 -> 뭔가 나온다
		btn.addActionListener(mbl);
		

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}