package swing_p;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseBenerMain extends JFrame implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();

	}
	
	int curr, dst;

	@Override
	public void mouseReleased(MouseEvent e) {
		if(!moving) {
			int dir = 0;
			
			if(lastX>e.getX()&&imgs.getX()!=-600) {
				dir=-200;
				curr=-2;
			}
			else if(lastX<e.getX()&&imgs.getX()!=0) {
				dir=200;
				curr=2;
			}
			dst = imgs.getX()+dir;
			System.out.println(imgs.getX()+","+dir+","+curr);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	JPanel imgs;
	
	int lastX;
	
	public MouseBenerMain() {
		super("마우스배너");
		setBounds(50, 50, 600, 500);
		setLayout(null);
		
		JPanel outer = new JPanel();
		outer.setBounds(200,100,200,300);
		outer.setLayout(null);
		
		outer.setBackground(Color.pink);
		add(outer);
		
		imgs =  new JPanel();
		imgs.setBounds(0,0,800,200);
		imgs.setLayout(new GridLayout(1,4));
		//imgs.setBackground(Color.YELLOW);
		outer.add(imgs);
		
		for (int i = 1; i <= 4; i++) {
			JLabel lb = new JLabel(new ImageIcon("pic/dog"+i+".jpg"));
			imgs.add(lb);
		}
		
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(this);
		//addMouseMotionListener(this);
		
		new Timer().start();
	}
	
	boolean moving;
	
	class Timer extends Thread{
		@Override
		public void run() {
			while(true) {
				
				try {
					sleep(10);

					if(moving = dst!=imgs.getX()) {
						imgs.setLocation(imgs.getX()+curr, 0);
					}
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseBenerMain();
	}

}
