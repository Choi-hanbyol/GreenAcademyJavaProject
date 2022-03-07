package swing_p;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class ImageMain extends JFrame {
	
	Image img1, img2 ,img3, img4;
	Graphics gg1, gg2 ,gg3, gg4;
	
	public ImageMain() {
		super("이미지 그림판");
		setBounds(50, 50, 600, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//setVisible(true)후에 실행 해야함
		//이미지 생성 : GUI컨테이너 급에서 createImage로 생성
		img1 = createImage(200,200);
		img2 = createImage(200,200);
		img3 = createImage(200,200);
		img4 = createImage(200,200);
		//이미지에 그릴 도구 가져오기
		gg1 = img1.getGraphics();
		gg2 = img2.getGraphics();
		gg3 = img3.getGraphics();
		gg4 = img4.getGraphics();
		
	}

	void meth_1() {
		gg1.setColor(Color.pink);
		gg1.fillRect(50, 50, 80, 80);
		gg2.setColor(Color.yellow);
		gg2.fillOval(50, 50, 80, 80);
		gg3.setColor(Color.red);
		gg3.fillPolygon(
				new int []  {80,150,5},
				new int []  {10,90,90},
				3
				);
		gg4.setColor(Color.blue);
		gg4.drawString("송지은 만세!!", 50, 50);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		meth_1();
		
		g.drawImage(img1, 10, 100, this);
		g.drawImage(img2, 350, 100, this);
		g.drawImage(img3, 350, 300, this);
		g.drawImage(img4, 10, 300, this);
	}
	
	public static void main(String[] args) {
		new ImageMain();
	}

}
