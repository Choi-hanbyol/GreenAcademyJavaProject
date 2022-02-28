package swing_p;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MenuMain extends JFrame{
	
	public MenuMain(String name) {
		super(name);
		setBounds(100,50,600,400);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu main1 = new JMenu("파일");
		JMenu main2 = new JMenu("편집");
		JMenu main3 = new JMenu("보기");
//		main3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
//		JMenu에 단축키 적용불가
		JMenuItem main4 = new JMenuItem("도구");
		
		bar.add(main1);
		bar.add(main2);
		bar.add(main3);
		bar.add(main4);
		bar.add(new JButton("버튼"));
		bar.add(new JLabel("라벨이야"));
		bar.add(new JTextField("써봐"));
		
		JMenuItem m1_1 = new JMenuItem("새로만들기");
		
		ImageIcon icon1 = new ImageIcon("pic/dog.png");
		JMenuItem m1_2 = new JMenuItem("개로만들기",icon1);
		m1_2.setText("고양이로 변신");

		ImageIcon icon = new ImageIcon("pic/load.png");
		JMenuItem m1_3 = new JMenuItem("소로만들기");
		m1_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
													//m1_3를 ctrl+D로 누를 수 있게 해주는 명령어
		main1.add(m1_1);
		main1.add(m1_2);
		main1.add(m1_3);
		JButton bb = new JButton("저장",icon);
		bb.setText("고장");
		main1.add(bb);
		main1.addSeparator();
		main1.add(new JLabel("소장"));
		main1.add(new JTextField("간장게장"));
		
		JMenu m2_1 = new JMenu("속성");
		JMenu m2_2 = new JMenu("환경설정");
		m2_1.add(new JMenuItem("머릿글"));
		m2_1.add(new JMenuItem("꼬리글"));
		
		JMenuItem m2_2_1 = new JMenuItem("글꼴");
		JMenuItem m2_2_2 = new JMenuItem("결과창");
		
		m2_2_1.setEnabled(false);
		m2_2_2.setSelected(true);
		
		m2_2.add(m2_2_1);
		m2_2.add(m2_2_2);
		
		main2.add(m2_1);
		main2.add(m2_2);
		
		main3.add(new JLabel("보기"));
		
		JCheckBoxMenuItem m3_1 = new JCheckBoxMenuItem("안내선",true);
		JCheckBoxMenuItem m3_2 = new JCheckBoxMenuItem("격자");
		m3_2.setSelected(true);
		main3.add(m3_1);
		main3.add(m3_2);
		main3.addSeparator();
		main3.add(new JLabel("장비"));
		JRadioButtonMenuItem m3_3 = new JRadioButtonMenuItem("핸드폰",true);
		JRadioButtonMenuItem m3_4 = new JRadioButtonMenuItem("태블릿");
		JRadioButtonMenuItem m3_5 = new JRadioButtonMenuItem("데스크탑");
		main3.add(m3_3);
		main3.add(m3_4);
		main3.add(m3_5);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(m3_3);
		bg.add(m3_4);
		bg.add(m3_5);
		
		setVisible(true);
		setResizable(false); //창크기 변경 유무
		//setExtendedState(MAXIMIZED_BOTH); //창크기 최대로!!!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MenuMain("메뉴바입니다.");
	}

}
