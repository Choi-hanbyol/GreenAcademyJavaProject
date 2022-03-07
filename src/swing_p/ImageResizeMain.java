package swing_p;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ImageResizeMain extends JFrame{
	
	Image img1, img2, img3;
	
	public ImageResizeMain() {
		super("이미지 크기변경");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		img1 = kit.getImage("pic/프로필.jpg");
		img2 = img1.getScaledInstance(540,720 , Image.SCALE_SMOOTH);
		img3 = img1.getScaledInstance(310, 310, Image.SCALE_SMOOTH);
		
		
		setBounds(50,50,800,700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void paint(Graphics g) {
		if(img1==null) {
			return;
		}
		super.paint(g);
		
		g.drawImage(img1, 400,60, this);
		g.drawImage(img2, 50,60, this);
		g.drawImage(img3, 300,160, this);
	}
	public static void main(String[] args) {
		new ImageResizeMain();
	}

}