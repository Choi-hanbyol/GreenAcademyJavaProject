package swing_p;

import java.awt.Color;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ComponentMain {

	public static void main(String[] args) {

		JFrame f = new JFrame("제목이지롱요");
		
		//int ox = 1920;
		f.setSize(800,600);
		//f.setLocation(ox+100, 50);

		f.setBounds(100, 50, 800,600);
		f.setLayout(null);
		
		JButton b1 = new JButton("버튼1");
		b1.setBounds(50, 30, 100, 50);
		b1.setBackground(Color.pink);
		f.add(b1); // 먼저 add한 객체가 위에 위치한다.
		
		JButton b2 = new JButton("버튼2");
		b2.setBounds(160, 30, 100, 50);
		b2.setBackground(Color.yellow);
		f.add(b2);
		
		JButton b3 = new JButton("버튼3");
		b3.setBounds(270, 30, 100, 50);
		b3.setBackground(Color.green);
		b3.setEnabled(false);
		f.add(b3);
		
		ImageIcon icon = new ImageIcon("pic/포메.jpg");
		
		JButton b4 = new JButton("버튼3",icon);
		b4.setVerticalTextPosition(0);
		b4.setHorizontalTextPosition(0);
		b4.setBounds(380, 30, 100, 50);
		b4.setBackground(Color.green);
		//b4.setEnabled(false);
		f.add(b4);
		
		JToggleButton tb1 = new JToggleButton("김치찌개");
		tb1.setBounds(50, 90, 100, 50);
		tb1.setBackground(Color.yellow);
		f.add(tb1);
		
		ButtonGroup bg = new ButtonGroup();
		
		JToggleButton tb2 = new JToggleButton("떡라면");
		tb2.setBounds(50, 150, 100, 50);
		tb2.setBackground(Color.yellow);
		f.add(tb2);
		
		JToggleButton tb3 = new JToggleButton("만두라면",true);
		tb3.setBounds(150, 150, 100, 50);
		tb3.setBackground(Color.yellow);
		f.add(tb3);
		
		JToggleButton tb4 = new JToggleButton("치즈라면");
		tb4.setBounds(250, 150, 100, 50);
		tb4.setBackground(Color.yellow);
		f.add(tb4);
		
		bg.add(tb2);
		bg.add(tb3);
		bg.add(tb4);
		
		Vector<String> email = new Vector<String>();
		email.add("구그래");
		email.add("나베르");
		email.add("다음");
		email.add("나테");
		
		JComboBox<String> box = new JComboBox<String>(email);
		box.setBounds(200, 90, 100, 50);
		box.setSelectedItem("다음");
		f.add(box);
		
		JLabel genLB = new JLabel("성별");
		genLB.setBounds(50, 220, 100, 50);
		f.add(genLB);
		
		JRadioButton rb1 = new JRadioButton("남");
		JRadioButton rb2 = new JRadioButton("여");
		JRadioButton rb3 = new JRadioButton("it인",true);
		JRadioButton rb4 = new JRadioButton("SCV");
		
		rb1.setBounds(100, 220, 60, 50);
		rb2.setBounds(160, 220, 60, 50);
		rb3.setBounds(220, 220, 100, 50);
		rb4.setBounds(320, 220, 100, 50);
		
		f.add(rb1);
		f.add(rb2);
		f.add(rb3);
		f.add(rb4);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rb1);
		bg1.add(rb2);
		bg1.add(rb3);
		bg1.add(rb4);
		
		JLabel hobLB = new JLabel("취미");
		hobLB.setBounds(50, 280, 100, 50);
		f.add(hobLB);
		
		JCheckBox hb1 = new JCheckBox("코딩");
		JCheckBox hb2 = new JCheckBox("디버깅");
		JCheckBox hb3 = new JCheckBox("개발");
		JCheckBox hb4 = new JCheckBox("프로젝트");
		
		hb1.setBounds(100, 280, 60, 50);
		hb2.setBounds(160, 280, 100, 50);
		hb3.setBounds(260, 280, 100, 50);
		hb4.setBounds(360, 280, 100, 50);
		
		f.add(hb1);
		f.add(hb2);
		f.add(hb3);
		f.add(hb4);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(hb1);
		bg2.add(hb2);
		bg2.add(hb3);
		bg2.add(hb4);
		
		
		String [] mm = "소주,양주,닭주,개주,상주".split(",");
		JList<String> menu = new JList<String>(mm);
		menu.setBounds(50,330,100,200);
		menu.setSelectedValue("개주", true);
		f.add(menu);
		
		JTextArea area = new JTextArea("아이고 1분 남았어!!!");
		JScrollPane aJP = new JScrollPane(area);
		aJP.setBounds(170,330,200,200);
		f.add(aJP);
		
		JTextField id = new JTextField();
		id.setBounds(400,50,200,50);
		f.add(id);
		
		JPasswordField pw = new JPasswordField();
		pw.setBounds(400,110,200,50);
		f.add(pw);
		
		Object [][] data = {
				{"현빈", 77, 78, 72},
				{"원빈", 67, 68, 62},
				{"투빈", 97, 98, 92},
				{"쓰리빈", 87, 88, 82}
				
		};
		
		Object [] title = {"이름","국어","영어","수학"};
		
		JTable tt = new JTable(data, title);
		JScrollPane ttJp = new JScrollPane(tt);
		ttJp.setBounds(500,200,250,200);
		f.add(ttJp);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
