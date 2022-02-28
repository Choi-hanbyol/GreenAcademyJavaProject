package swing_p;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEventMain extends JFrame implements KeyListener {
	JLabel box, enemy;
	int x = 400, y = 300;
	boolean chk = false;
	class Timer extends Thread{
		@Override
		public void run() {
			
			int dx=3, dy=3;
			while(true) {
				try {
					sleep(30);
					
					System.out.println(enemy.getX()+","+x);
					
					if(x<enemy.getX()+70 && 
						x+50> enemy.getX()&& 
						y<enemy.getY()+70  &&
						y+50> enemy.getY()) {
						System.out.println("x 겹침");
						break;
						
					}
					//System.out.println(enemy.getX()+","+enemy.getY());
					
					int ex = enemy.getX()+dx, ey = enemy.getY()+dy;
					if(ey>=490 || ey < 0) {
						dy *= -1;
					}
					if(ex >= 720 || ex <0) {
						dx *= -1;
					}
					enemy.setLocation(ex,ey);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			chk=true;
			removeKeyListener(KeyEventMain.this);
			//KeyEventMain.this --> Outer의 this
		}
	}
	
	public KeyEventMain(){
		super("키 이벤트");
		setBounds(50,50,800,600);
		setLayout(null);
		
		box = new JLabel();
		box.setBounds(400,300,50,50);
		box.setOpaque(true);
		box.setBackground(Color.pink);
		add(box);
		
	
		
		enemy = new JLabel();
		enemy.setBounds(100,100,70,70);
		enemy.setOpaque(true);
		enemy.setBackground(Color.yellow);
		add(enemy);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		
		Timer tm = new Timer();
		tm.start();
	}
	
	public static void main(String[] args) {
		new KeyEventMain();
	}

	@Override
	public void keyTyped(KeyEvent e) { //글자 키만
//		System.out.println("keyType");
	}

	@Override
	public void keyPressed(KeyEvent e) { //키를 눌렀을때
//		System.out.println("keyPressed");
		int key = e.getKeyCode();
//		System.out.println(key);
		int myX = box.getX(), myY = box.getY();
		
		if(myY<5) { // 위쪽 영역제한
			y+=10;
			box.setLocation(x,y);
		}
		else if(myY>510) { //아래쪽 영역제한
			y-=10;
			box.setLocation(x,y);
		}
		if(myX<5) { //왼쪽 영역제한
			x+=5;
			box.setLocation(x,y);
		}
		else if(myX>730) { //오른쪽 영역제한
			x-=5;
			box.setLocation(x,y);
		}
		else {
		switch(key) {
			case 37 :
				x-=5;
//				System.out.println("왼쪽");
				break;
			case 38 :
				y-=5;
//				System.out.println("위쪽");
				break;
			case 39 :
				x+=5;
//				System.out.println("오른쪽");
				break;
			case 40 :
				y+=5;
//				System.out.println("아래쪽");
				break;
			}
		box.setLocation(x, y);
//		box.setLocation(200, 100);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) { //키를 뗐을때
//		System.out.println("keyReleased");
	}

}
