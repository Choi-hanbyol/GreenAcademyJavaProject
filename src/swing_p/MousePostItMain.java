package swing_p;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MousePostItMain extends JFrame implements MouseMotionListener, MouseListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("e.getComponent : "+e.getComponent());
		e.getComponent().setLocation(e.getComponent().getX()-70+e.getX(),
				e.getComponent().getY()-20+e.getY());
//		pp2.setLocation(pp2.getX()-70+e.getX(), pp2.getY()-20+e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
//		System.out.println("move:"+e.getX()+","+e.getY());
	}
//	ArrayList panels = new ArrayList();
	JPanel pp,pp2;
	ImageIcon icon,icon2, iconp;
	JLabel backLB, backLB2;
	
	public MousePostItMain() {
		super("마우스포스트잇");
		setBounds(50, 50, 900, 600);
		setLayout(null);
		
		pp = new JPanel();
		pp.setLayout(null);
		pp.setBounds(50, 50, 170,170);
		
		JTextArea area = new JTextArea("포스트잇 1");
		area.setBounds(50, 50, 120,120);
		//area.setBackground(new Color(255,0,0,0));
		area.setOpaque(false);
		pp.add(area);
		
		
		//2번쨰 포스트잇
		pp2 = new JPanel();
		pp2.setLayout(null);
		pp2.setBounds(300, 50, 170, 170);
		
		JTextArea area1 = new JTextArea("포스트잇 2");
		area1.setBounds(50, 50, 120,120);
		//area.setBackground(new Color(255,0,0,0));
		area1.setOpaque(false);
		pp2.add(area1);
		
		icon = new ImageIcon("pic/post.png");
		icon2 = new ImageIcon("pic/post3.png");
		iconp = new ImageIcon("pic/post2.png");
		
		backLB = new JLabel(icon);
		backLB2 = new JLabel(icon2);
		
		backLB.setBounds(0, 0, 170,170);
		backLB2.setBounds(0, 0, 170, 170);
		
		pp.add(backLB);
		pp2.add(backLB2);
		
		
		add(pp);
		add(pp2);
		
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pp.addMouseMotionListener(this);
		pp.addMouseListener(this);
		pp2.addMouseMotionListener(this);
		pp2.addMouseListener(this);
	}

	public static void main(String[] args) {
		new MousePostItMain();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		backLB.setIcon(iconp);
		backLB2.setIcon(iconp);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		backLB.setIcon(icon);
		backLB2.setIcon(icon2);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
