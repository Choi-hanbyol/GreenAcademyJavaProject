package javaProject1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import javaProject1.DesertResultPanelMain.DesertResultPanel;

public class DesertPanelMain extends JFrame{
	
	class DesertPanel extends JPanel implements MouseMotionListener, MouseListener, ActionListener{
	
		public DesertPanel() {
			setBounds(0, 0, 600, 800);
			setLayout(null);
			
			Font f1 = new Font("함초롬돋움", Font.BOLD, 25);
			Font f2 = new Font("함초롬돋움", Font.BOLD, 15);
			
			JLabel text1 = new JLabel("사막에서 마지막까지 데리고 갈 동물은?");
			text1.setBounds(-5, 100, 600, 50);
			text1.setHorizontalAlignment(JLabel.CENTER);
			text1.setFont(f1);
			
			JLabel text2 = new JLabel("<html><body><center>사막에서의 여정이 힘에 부쳤던 당신은<br> <br>"
					+ "어쩔 수 없이 함께 가던 동물들을<br> <br>"
					+ "차례대로 버리고 가기로 결심한다.<br> <br>"
					+ "이 때 당신은 다음 동물들을 어떤 순서로 버리겠는가?</center></body></html>");
			text2.setBounds(-5, 100, 600, 300);
			text2.setHorizontalAlignment(JLabel.CENTER);
			text2.setFont(f2);
			ImageIcon animalImg;

			for (int i = 0; i < 5; i++) {
				animalImg = new ImageIcon("pic1/animal"+(i+1)+".png");
				JLabel animal = new JLabel(animalImg);
				animal.setBounds(55+100*i, 500, 80, 80);
				animal.setName("D"+(i+1));
				animal.addMouseMotionListener(this);
				animal.addMouseListener(this);
				add(animal);
			}
			
			for (int i = 0; i < 5; i++) {
				JButton blank = new JButton();
				blank.setBounds(55+100*i, 380, 80, 80);
				blank.setEnabled(false);
				add(blank);
			}
			
			JButton goResult = new JButton();
			goResult.setName("goResult");
			goResult.setBounds(195, 640, 200, 60);
			goResult.setText("결과 보기");
			goResult.setFont(f2);
			goResult.setBackground(Color.lightGray);
			goResult.addActionListener(this);
			
			add(goResult);
			
			add(text1);
			add(text2);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			int x = e.getComponent().getX()-40+e.getX();
			int y = e.getComponent().getY()-40+e.getY();
			
			e.getComponent().setLocation(x, y);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
			int x = e.getComponent().getX()-40+e.getX();
			int y = e.getComponent().getY()-40+e.getY();

			for (int i = 0; i < 5; i++) {
				if(x >= 55+100*i && x <= 55+100*i+80 && y >= 380 && y <= 380+80) {
					e.getComponent().setLocation(55+100*i, 380);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override //액션리스너추가_한별
		public void actionPerformed(ActionEvent e) {
			System.out.println(getComponentAt(60, 390).getName());
//			card.show(getContentPane(),animalsType[1]);
			if((getComponentAt(60, 390).getName()).equals("D1")) {
				card.show(getContentPane(),animalsType[0]);
			}else if((getComponentAt(60, 390).getName()).equals("D2")){
				card.show(getContentPane(),animalsType[1]);
			}
			else if((getComponentAt(60, 390).getName()).equals("D3")){
				card.show(getContentPane(),animalsType[2]);
			}
			else if((getComponentAt(60, 390).getName()).equals("D4")){
				card.show(getContentPane(),animalsType[3]);
			}
			else {
				card.show(getContentPane(),animalsType[4]);
			}
		}
		
	}
	
	////결과판넬시작부분
	String [] animalsType = {
			"lion", "horse", "cow", "sheep","monkey"
	};
	
	String [] animals = {
			"사자", "말", "소", "양", "원숭이"
	};
	
	String [] results = {
			"<html><body><center>사자는 자존심을 의미한다.<br>"
			+ "<br>사자를 제일 먼저 버린다면 힘든 일 앞에서<br>"
			+ "<br>자존심쯤은 쉽게 버릴 수 있는 성격이며,<br>"
			+ "<br>반대로 마지막까지 사자를 지킨 사람들은<br>"
			+ "<br>자존심이 세며 능력과 야망을 가진 사람이다.<br>"
			+ "<br>때로는 이기적이고 냉정하다는 말을 듣기도 하지만<br>"
			+ "<br>자신의 일에 최선을 다해 인정받으려는 욕구를 지닌 사람이다.</center></body></html>",
			
			"<html><body><center>말은 가족을 뜻한다.<br>"
			+ "<br>제일 먼저 말을 버리는 사람은 인생에 위기가 닥쳤을 때<br>"
			+ "<br>가족을 제일 먼저 포기할 가능성이 높다.<br>"
			+ "<br>마지막까지 말을 버리지 않은 사람은<br>"
			+ "<br>안정감을 중요시하고 배려심이 많으며<br>"
			+ "<br>주변으로부터 두터운 신뢰를 받으며,<br>"
			+ "<br>겸손하고 묵묵하게 자신의 일을 해내는 뚝심 있는 성격이지만<br>"
			+ "<br>때로는 고지식하다는 말을 듣기도 한다.</center></body></html>",
			
			"<html><body><center>소는 직업과 목표를 의미한다.<br>"
			+ "<br>소를 가장 먼저 버린 사람은 야망이 크지 않은 사람이며,<br>"
			+ "<br>소소한 행복에 안주하는 성격이다.<br>"
			+ "<br>마지막까지 소를 남겨둔 사람이라면 <br>"
			+ "<br>자신의 일에 자부심이 강하고 활발하며 분주한 성격의 소유자이고,<br>"
			+ "<br>역동적이며 능동적인 성향의 소유자이다.</center></body></html>",
			
			"<html><body><center>양이 가리키는 것은 사랑이다.<br>"
			+ "<br>만약 제일 먼저 양을 버린다면 힘든 일이 생겼을 때<br>"
			+ "<br>사랑하는 연인이나 배우자와의 행복을 가장 먼저 포기하는 것이다.<br>"
			+ "<br>반면 양을 마지막까지 버리지 않는 사람은<br>"
			+ "<br>사랑에 목숨을 거는 열정의 소유자이며,<br>"
			+ "<br>종종 내성적이라는 말을 듣기도 하지만<br>"
			+ "<br>온순함 속에 남다른 뜨거움을 품은 사람이다.</center></body></html>",
			
			"<html><body><center>원숭이는 친구를 의미한다.<br>"
			+ "<br>마지막까지 원숭이를 버리지 않고 함께 가는 사람은<br>"
			+ "<br>우정을 중요하게 여기는 사람이며, 사교적인 성격의 소유자다.<br>"
			+ "<br>때때로 실속 없고 가벼운 사람이라는 평을 듣기도 하지만<br>"
			+ "<br>놀라운 친화력과 의리를 지닌 사람이다.<br>"
			+ "<br>겉으로는 인기가 많고 밝은 모습을 보여주지만 <br>"
			+ "<br>고독한 내면을 지니고 있기도 하다.</center></body></html>"
	};
	ImageIcon animalImg;
	class DesertResultPanel extends JPanel{
		JLabel animals;
		JLabel results;
		public DesertResultPanel() {
			setBounds(0,0,600,700);
			setLayout(null);
			
			JLabel exp = new JLabel("<html><body><center>여기서 사막은 인생을 뜻하며<br>"
					+ "<br>선택한 동물은 당신이 힘들 때 가장 먼저 포기하게 되는 삶의 요소를 가리킨다.<br>"
					+ "<br>따라서 마지막까지 오래 남은 동물일수록 당신이 중요하게 여기는 가치관을 가리킨다.<br>"
					+ "<br>선택지에 따른 답은 다음과 같다.</center></body></html>");
			exp.setBounds(50,50,500,120);
			Font expF = new Font("휴먼둥근헤드라인", Font.PLAIN,12);
			exp.setFont(expF);
			
			
			
			animals = new JLabel();
			animals.setBounds(170,200,80,50);
			Font animalsF = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			animals.setFont(animalsF);
			
			JLabel Dm = new JLabel("당신의 선택 : ");
			Dm.setBounds(20,200,250,50);
			Font DmF = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			Dm.setFont(DmF);
			
			JLabel Aimg = new JLabel(animalImg);
			Aimg.setBounds(220,270,95,90);
			
			results = new JLabel();
			results.setBounds(75,220,500,600);
			Font resultF = new Font("휴먼둥근헤드라인", Font.PLAIN,14);
			results.setFont(resultF);
			
			
			add(exp);
			add(Dm);
			add(animals);
			add(Aimg);
			add(results);
		}
	}// 결과판넬 끝부분
	
	CardLayout card;
	
	public DesertPanelMain() {
		super("사막오막육막칠막");
		setBounds(200, 100, 600, 800);
		card = new CardLayout();
		setLayout(card);
		add(new DesertPanel());
		
		for(int i = 0; i < animals.length; i++) {
			animalImg = new ImageIcon("pic1/animal"+(i+1)+".png");
			DesertResultPanel DP = new DesertResultPanel();
			DP.animals.setText(animals[i]);
			DP.results.setText(results[i]);
			
			DP.setName(animalsType[i]);
			add(DP,animalsType[i]);
		}
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	
	public static void main(String[] args) {
		new DesertPanelMain();

	}

}