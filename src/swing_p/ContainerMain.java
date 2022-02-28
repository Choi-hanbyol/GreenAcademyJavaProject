package swing_p;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ContainerMain {

	public static void main(String[] args) {
		int ox = 0;
		
		JFrame f1 = new JFrame("JPanel");
		f1.setBounds(ox+0,50,300,200);
		f1.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(10, 10, 100, 100);
		p1.setBackground(Color.yellow);
		
		JPanel p2 = new JPanel();
		p2.setBounds(120, 10, 100, 100);
		p2.setBackground(Color.pink);
		
		f1.add(p1);
		f1.add(p2);
		
		Container c1 = f1.getContentPane();
		System.out.println(c1.getComponentCount());
		
		Component [] arr = c1.getComponents();
		System.out.println(arr[0].getBackground());
		System.out.println(arr[1].getBackground());
		
		
//		for (int i = 0; i < 5; i++) {
//			p1.add(new JButton("버튼 "+i));
//			p2.add(new JButton("버튼 "+i));
//		}
		
		f1.setVisible(true);
		
		
		JFrame f2 = new JFrame("JScrollPane");
		f2.setBounds(ox+300,50,300,200);
		f2.setLayout(null);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.yellow);
		
		JScrollPane jp3 = new JScrollPane(p3);
		jp3.setBounds(10, 10, 100, 100);
		
		
		JPanel p4 = new JPanel();
		//p4.setBounds(120, 10, 100, 100);
		p4.setPreferredSize(new Dimension(80, 300));
		p4.setBackground(Color.pink);
		
		JScrollPane jp4 = new JScrollPane(p4);
		jp4.setBounds(120, 10, 100, 100);
		
		f2.add(jp3);
		f2.add(jp4);
		
		for (int i = 0; i < 5; i++) {
			p3.add(new JButton("버튼 "+i));
			p4.add(new JButton("버튼 "+i));
		}
		
		f2.setVisible(true);
		
		JFrame f3 = new JFrame("JDialog");
		f3.setBounds(ox+0,250,300,200);
		Container con = f3.getContentPane();
		con.setBackground(Color.green);
		
		
		
		
		// true - doModal  : 현재 대화창을 닫아야 owner 창 열림
		// false - Modaless : 현재 대화창과 같이 owner 창 열림
		JDialog dd = new JDialog(f3, "메세지창", false);
		dd.setBounds(ox+300, 250, 100, 100);
		dd.setLayout(new FlowLayout());
		
		dd.add(new JLabel("경고창 입니다."));
		dd.add(new JButton("확인"));
		
		dd.setVisible(true);
		
		f3.setVisible(true);
		
		
		JFrame f4 = new JFrame("FileDialog");
		f4.setBounds(ox+0,450,300,200);
		f4.setBackground(Color.green);  //적용되지 않음
		
		
		FileDialog fd = new FileDialog(f4, "파일열기입니다", FileDialog.LOAD);
		//fd.setBounds(ox+300, 450, 100, 100);
		fd.setLocation(ox+300, 450);
		fd.setDirectory("C:\\1.한별 잡다한것들\\영화");

		fd.setVisible(true);
		f4.setVisible(true);
		
		System.out.println(fd.getDirectory());
		System.out.println(fd.getFile());
		
	}

}
