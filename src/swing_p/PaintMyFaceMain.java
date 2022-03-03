package swing_p;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintMyFaceMain extends JFrame{
	
	public PaintMyFaceMain() {
		super("My Face!!");
		System.out.println("생성자다!!");
		
		setBounds(50, 50, 900, 600);
		setLayout(null);
//		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g); 
	
		g.drawPolygon( //얼굴
				new int [] {300,300,550,550,500,350},
				new int [] {230,130,130,230,400,400},
				6);
		
		g.drawPolygon( //코
				new int [] {425,390,425},
				new int [] {280,280,210},
				3);
		

		g.drawOval(330, 160, 70, 40); //왼쪽 눈
		g.drawOval(450, 160, 70, 40); //오른쪽 눈
		
		g.fillOval(350, 165, 30, 30); //왼쪽 눈알
		g.fillOval(470, 165, 30, 30); //오른쪽 눈알
		
		g.setColor(Color.red);
		g.drawArc(380, 270, 100, 100, 180, 180); //입
		
		g.setColor(Color.black);
		g.drawPolygon( //따봉!!!
				new int [] {300,320,320,350,350,300},
				new int [] {400,400,430,430,500,500},
				6);
		
		g.fillArc(290, 50, 270, 200, 360, 180); //머리카락
		
	}
	
	public static void main(String[] args) {
		new PaintMyFaceMain();
	}

}
