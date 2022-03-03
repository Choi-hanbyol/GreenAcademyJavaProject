package swing_p;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintMain extends JFrame{
	
	public PaintMain() {
		super("그림판");
		System.out.println("생성자다!!");
		
		setBounds(50, 50, 900, 600);
		setLayout(null);
//		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g); //화면을 새로 그려주는 역할 -> 배경을 다시 그려줌
		//화면 갱신이 될때 자동호출
		//화면 갱신 : 화면크기변경(최대,최소화 포함)
		System.out.println("paint()실행");
		g.setColor(Color.blue);
		g.setFont(new Font("휴먼편지체",Font.ITALIC,30));
		g.drawString("송지은 만세", 50, 100);
		
		g.setColor(Color.green);
		g.drawRect(150, 150, 200, 100);
		
		g.setColor(Color.red);
		g.fillRect(50, 120, 200, 100);
		
		g.setColor(Color.pink);
		g.fillOval(50, 250, 200, 100);
		
		g.setColor(Color.blue);
		g.drawOval(100, 300, 70, 70);
		
		g.setColor(Color.blue);
		g.drawLine(50, 50, 30,350);
		
		g.drawRoundRect(50, 370, 200, 100, 100, 50);
		
		g.setColor(Color.red);
		g.drawArc(400, 50, 100, 100, 45, 90);
		
		g.setColor(Color.red);
		g.fillArc(600, 50, 100, 100, 45, 90);
		
		g.setColor(Color.blue);
		g.fillPolygon(
				new int [] {600,700,800,500},
				new int [] {400,370,530,500},
				4);
		
		g.setColor(Color.green);
		g.drawPolygon(
				new int [] {500,600,700,400},
				new int [] {400,370,530,500},
				4);
		
		g.drawPolyline(
				new int [] {700,800,900,600},
				new int [] {400,370,530,500},
				4);
		
		g.setColor(Color.red);
		g.drawPolyline(
				new int [] {600,700,800,500, 600},
				new int [] {200,170,330,300,200},
				5);
		
		
		
	}
	
	public static void main(String[] args) {
		new PaintMain();
	}

}
