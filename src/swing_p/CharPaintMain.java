package swing_p;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;

public class CharPaintMain extends JFrame implements MouseMotionListener, ActionListener{

	public CharPaintMain() {

		System.out.println("생성자");
		setBounds(50, 50, 600, 500);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		Color [] ccs = {Color.red, Color.orange, Color.yellow,
				Color.green, Color.blue, Color.pink,
				Color.black,Color.white
		};
		
		for (int i = 0; i < ccs.length; i++) {
			JButton btn = new JButton();
			btn.setBounds(0, 50*i, 50,50);
			btn.setBackground(ccs[i]);
			btn.addActionListener(this);

			add(btn);
		}
		
		JSlider jb = new JSlider(JSlider.HORIZONTAL, 5,80, 20);
		jb.setBounds(50, 350, 200,100);
		add(jb);
		
		jb.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				JSlider jjj = (JSlider)e.getSource();
				System.out.println(jjj.getValue());
				
				size = jjj.getValue();
			}
		});
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//paint(getGraphics());
		
		//repaint();  //다시그리기
		
		addMouseMotionListener(this);
	}
	
	int x = -100, y = -100, size = 20;
	
	boolean first = true;
	
	Color cc = Color.black;
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g);
		//System.out.println("paint() 실행");
		if(first) {
			g.setColor(Color.white);
			g.fillRect(100, 0, 550, 350);
			
			
		}
			g.setFont(new Font("휴먼편지체", Font.PLAIN, size));
			g.setColor(cc);
			g.drawString("●",x, y );
		
		
	}
	public static void main(String[] args) {
		
		new CharPaintMain();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		first = false;
		// TODO Auto-generated method stub
		//System.out.println("dragged"+e.getX()+","+e.getY());
		if(e.getX()>=100 && e.getY()<=350) {
			x = e.getX();
			y = e.getY();
			repaint();  //화면 다시 그리기
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton nowBtn = (JButton)e.getSource();
		//getSource() --> Object 형태로 리턴 : 이벤트소스객체를 받아옴
		//System.out.println("눌렀다"+nowBtn.getBackground());
		cc = nowBtn.getBackground();
		
	}

}
