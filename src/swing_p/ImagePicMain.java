package swing_p;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ImagePicMain extends JFrame{
	
	Image img1, img2, img3, img4;
	
	public ImagePicMain() {
		super("이미지사진!");
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		img1 = kit.getImage("pic/dog2.jpg");
		img2 = kit.getImage("pic/dog1.jpg");
		img3 = kit.getImage("pic/dog3.jpg");
		img4 = kit.getImage("pic/dog4.jpg");
		
		setBounds(50,50,800,700);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if(img1==null) {
			return;
		}
		super.paint(g);
		
		g.drawImage(img1,
				30,50,
				200,200,
				
				30,10,
				700,510,
				this);
		g.drawImage(img2,
				300,400, //그려지는 시작위치
				200,200, //그려지는 크기(넓이, 둘레)
				700,800,
				30,100,
				this);
		
		g.drawImage(img3,
				350,50,
				200,200,
				
				30,10,
				310,470,
				this);
		
		g.drawImage(img4,
				50,100,
				200,200,
				
				300,10,
				590,515,
				this);
	}
	
	public static void main(String[] args) {
		new ImagePicMain();
	}

}
