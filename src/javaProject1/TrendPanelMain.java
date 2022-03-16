package javaProject1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class TrendPanelMain extends JFrame{
	
class firstHome extends JPanel implements ActionListener{	// 초기 화면 - 시작버튼
		
		public firstHome() {
			
			setBounds(0, 0, 600, 650);
			setLayout(null);
			
			JLabel wel = new JLabel("자 드가자");
			wel.setBounds(50, 45, 600, 100);
			Font welf = new Font("휴먼둥근헤드라인", Font.PLAIN, 30);
			wel.setFont(welf);
			
			JButton start = new JButton("드가자");
			start.setBounds(180, 450, 200, 80);
			start.setBackground(Color.green);
			start.addActionListener(this);
			
			add(wel);
			add(start);
		}

		@Override
		public void actionPerformed(ActionEvent e) {	// start버튼 눌렀을때
			frameCard2.show(getContentPane(), "UpPanel");
			tt = new TrendTimer();
			tt.start();
		}
	}
	
	
	String [] Qu = { //트렌드 퀴즈 문항
			"1. 다음 빈칸에 들어갈 대답은?",
			"2. 둘리가 하는 말로 옳은 것은?",
			"3. 학생들이 외치는 말로 옳은 것은?",
			"4. 다음 인물을 유행어로 옳지 않은 것은?",
			"5. 위 사진과 어울릴 말은?",
			"6. 위 사진과 관련 없는 대사는?",
			"7. 위 사진에 어울리는 대사는?",
			"8. 다음 빈칸에 들어갈 대답은?",
			"9. 다음 빈칸에 들어갈 알맞은 대답은?",
			"10. 다음 빈칸에 들어갈 대답은?"
	};
	
	String [] A1 = { //1번보기
			"무한!도전~",
			"초능력 맛 좀 볼래?",
			"우린 신화예요!",
			"철이 없었죠",
			"호우! 무대를 뒤집어 놓으셨다...",
			"<html><body>엄청작은 모기가<br>나의 발을 물었어!</body></html>",
			"아 눈부셔",
			"농구가 하고 싶어요...",
			"무사트! 특별과정",
			"누나가 왜 거기서 나와...?"
			
	};
	
	String [] A2 = { //2번보기
			"무야~호~",
			"호이! 호이!",
			"지금은~ 소녀시대~!",
			"안녕 나의 꼬마아가씨?",
			"자 가즈아~~ 무대를 뒤집으러",
			"아무생각 없이 나는 발을 긁었어",
			"불 좀 꺼줄래?",
			"축구가 하고 싶어요...",
			"이 X끼 뭐야. 너 인성 문제 있어?",
			"엄마가 왜 거기서 나와...?"
			
	};
	
	String [] A3 = { //3번보기
			"야~뽀로로다!!",
			"1+1은 귀요미",
			"멈춰!!!",
			"어? 예쁘다",
			"<html><body>오우.. 완전 무대를 뒤집어<br>놓으셨다..진.촤.! 최고의 선배</body></html>",
			"간지러웠어!",
			"네 실력을 차마 볼 수가 없다",
			"배구가 하고 싶어요...",
			"야 너! 머리부터 발끝까지",
			"아빠가 왜 거기서 나와...?"
			
	};
	
	String [] A4 = { //4번보기
			"1박! 2일!!",
			"요리보고 조리봐도 둘리",
			"가즈아~~!!",
			"안녕~! 난 준이라고 해~",
			"자 드가자!~~",
			"그래서 참았어! 간지러웠어!",
			"내 컴퓨터 좀 보게",
			"야구가 하고 싶어요...",
			"니 엉덩이 자랑하고 싶냐?",
			"형이 왜 거기서 나와...?"
			
	};

	String [] RightAnswer = {"2", "1", "3", "4", "3", "4", "2", "1", "2", "4"};

	ArrayList<String> myAnswer = new ArrayList<String>();
	
	ImageIcon IMG;
	int score;
	TrendTimer tt;
	
	
	class TrendTimer extends Thread {	// 시간제한 쓰레드

		@Override
		public void run() {
			while(true) {
				for (int i = 5; i >= 0; i--) {
					TrendPanelArr.get(Integer.parseInt(now)).tiLabel.setText(i+"");
					try {
						Thread.sleep(1000);

					} catch (Exception e) {
					}
				}
				TrendCard.show(UpPanel, Integer.parseInt(now)+1+"");
				now = Integer.parseInt(now)+1+"";
			}
		}

	}
	
	
	class TrendPanel extends JPanel implements ActionListener{
		JLabel Qu;
		JRadioButton A1;
		JRadioButton A2;
		JRadioButton A3;
		JRadioButton A4;
		JButton Back;
		JButton Next;
		String CA;
		JLabel tiLabel;
		
		public TrendPanel() {
			setBounds(0,0,600,790);
			setLayout(null);

			Qu = new JLabel();
			Font QuF = new Font("함초롬돋움", Font.BOLD, 15);
			Qu.setFont(QuF);
			Qu.setBounds(100,350,300,20);
			
			A1 = new JRadioButton();
			A1.setName("1");
			Font A1F = new Font("함초롬돋움", Font.BOLD, 12);
			A1.setFont(A1F);
			A1.setBounds(100,445,200,30);
			
			A1.addActionListener(this);
			
			A2 = new JRadioButton();
			A2.setName("2");
			Font A2F = new Font("함초롬돋움", Font.BOLD, 12);
			A2.setFont(A2F);
			A2.setBounds(340,450,200,20);
			A2.addActionListener(this);
			
			A3 = new JRadioButton();
			A3.setName("3");
			Font A3F = new Font("함초롬돋움", Font.BOLD, 12);
			A3.setFont(A3F);
			A3.setBounds(100,595,200,30);
			A3.addActionListener(this);
			
			A4 = new JRadioButton();
			A4.setName("4");
			Font A4F = new Font("함초롬돋움", Font.BOLD, 12);
			A4.setFont(A4F);
			A4.setBounds(340,600,200,20);
			A4.addActionListener(this);
		
			Next = new ButtonMove("Next");
			Next.setBounds(210,670,100,50);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(A1);
			bg.add(A2);
			bg.add(A3);
			bg.add(A4);
			
			JLabel Qimg1 = new JLabel(IMG);
			Qimg1.setBounds(100,40,400,300);
			
			tiLabel = new JLabel();
			tiLabel.setLayout(null);
			tiLabel.setBounds(10, 20, 100, 80);
			Font ff = new Font("한컴산뜻돋움", Font.BOLD, 15);
			tiLabel.setFont(ff);
			
			add(Qu);
			add(Qimg1);
			add(A1);
			add(A2);
			add(A3);
			add(A4);
			add(Next);
			add(tiLabel);
			
			for(int i = 0; i < RightAnswer.length; i++) { //답을 선택안했을때 답을 0으로 넣게
				myAnswer.add(i,"0");
			}

		}
		 
		@Override  //사용자가 누른 답
		public void actionPerformed(ActionEvent e) { //21343
			String Qa = (((JRadioButton)e.getSource()).getParent()).getName(); //해당페널의 이름 //0,1,2,3,4
			String Btype = ((JRadioButton)e.getSource()).getName(); //누른 버튼의 이름 1, 2, 3, 4
			
			myAnswer.add(Integer.parseInt(Qa), Btype); //몇번문항의 무슨답을 myAnswer에 저장한다.
		}
	}
	String now = "0";
	class ButtonMove extends JButton implements ActionListener{
		public ButtonMove(String name1) {
			super(name1);
			setName(name1);
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			now = ((JButton)e.getSource()).getParent().getName();
			int me = Integer.parseInt(now);
			
			if(((JButton)e.getSource()).getName()=="Next"){ //>>
				if(now.equals("9")) {
					
					for(int i=0; i<RightAnswer.length; i++) {
						
						String youAnswer = myAnswer.get(i);
						if(youAnswer.equals(RightAnswer[i])) {
							score++;
						}
					}
					
					if(score>=0&&score<=2) { //하수로 가라
						frameCard2.show(getContentPane(), "res3"); 
					}else if(score>=3&&score<=5) {
						frameCard2.show(getContentPane(), "res2"); 
					}
					else if(score>=6&&score<=8) {
						frameCard2.show(getContentPane(), "res1"); 
					}
					else { //고수로 가라
						frameCard2.show(getContentPane(), "res0"); 
					}
				}
				else {
					tt.stop();
					me++;
					now=me+"";
					TrendCard.show(UpPanel, now);
					tt = new TrendTimer();
					tt.start();
				}
			}
		}
	}
	
	String[] res1st = {
			"A급 고인물",	
			"B급 고인물",	
			"C급 고인물",	
			"F급 고인물",	
		};

		String[] res2nd = {
			"근처만 가도 냄새나는 하수",	
			"공원 중심에 고여있는 호수",
			"유유자적 흘러가는 강물",	
			"세상 청정한 1급수 계곡물",	
		};
		
		String[] res3rd = {
			"<html><body><center>#피대신_흐르는밈<br> <br>#1문장1밈</center></body></html>",
			"<html><body><center>#핵인싸 #유행의중심<br> <br>#밈활용도99%</center></body></html>",
			"<html><body><center>#고이진_않은듯<br> <br>#짤린이</center></body></html>",	
			"<html><body><center>#2G #자연친화<br> <br>#인터넷_청정구역</center></body></html>"	
		};
		
		String[] res4th = {
			"<html><body><center>대화할 때마다 인터넷 냄새를 뿜뿜하는 당신<br> <br>인터넷 언어들이 당신에겐 일상이지만<br> <br>주변사람들에겐 외계어라 대화가 잘 되지 않겠군요!<br> <br>가끔은 인터넷 언어를 내려놓아보면 어떨까요?</center></body></html>",
			"<html><body><center>핵인싸가 되어 주변에 사람이 끊이지 않는 당신<br> <br>인터넷 밈에 대한 이해가 높아<br> <br>적재적소에 밈을 사용하여<br> <br>주변사람들의 웃음을 담당하는군요!</center></body></html>",
			"<html><body><center>아직 고이려면 멀었군요!<br> <br>고인물 친구들 덕분에 많은 인터넷 밈을 줍줍하였지만<br> <br>활용은 그닥...F급은 아니니 희망이 있어요~<br> <br>지금 바로 구글에 '짤모음'을 검색해서 공부하세요!</center></body></html>",
			"<html><body><center>인터넷과는 거리가 멀어<br> <br>깨끗한 언어 속 도룡뇽이 살고 있는 당신!<br> <br>인터넷 유머 따위엔 관심이 없고<br> <br>이 테스트마저 친구가 시켜서 억지로 했겠군요!</center></body></html>",
		};
		
		ImageIcon rimg;

		class TrendResult extends JPanel{
			
			JLabel res1;
			JLabel res2;
			JLabel res3;
			JLabel res4;
			JLabel resImg;
			
			public TrendResult() {
				setBounds(0,0,600,790);
				setLayout(null);
				setBackground(Color.white);
				
				Font f1 = new Font("함초롬돋움", Font.BOLD, 20);
				Font f2 = new Font("함초롬돋움", Font.BOLD, 25);
				Font f3 = new Font("함초롬돋움", Font.BOLD, 15);
				
				res1 = new JLabel();
				res1.setBounds(0, 70, 600, 30);
				res1.setHorizontalAlignment(JLabel.CENTER);
				res1.setFont(f1);
				
				res2 = new JLabel();
				res2.setBounds(0, 80, 600, 100);
				res2.setHorizontalAlignment(JLabel.CENTER);
				res2.setFont(f2);
				
				resImg = new JLabel(rimg);
				resImg.setBounds(100, 180, 400, 220);
				
				res3 = new JLabel();
				res3.setBounds(0, 420, 600, 130);
				res3.setHorizontalAlignment(JLabel.CENTER);
				res3.setFont(f1);
				
				res4 = new JLabel();
				res4.setBounds(0, 530, 600, 200);
				res4.setHorizontalAlignment(JLabel.CENTER);
				res4.setFont(f3);
				
				JButton rec = new JButton();
				rec.setBounds(100, 420, 400, 310);
				rec.setEnabled(false);
				rec.setBackground(Color.white);
				rec.setOpaque(false);
				
				add(res1);
				add(res2);
				add(resImg);
				add(res3);
				add(res4);
				add(rec);
			}
		}
	
	
	ArrayList<TrendPanel> TrendPanelArr;
	CardLayout frameCard2;
	CardLayout TrendCard;
	JPanel UpPanel;
	
	public TrendPanelMain() {
		super("트랜드 검사");
		setBounds(200, 100, 600, 800);
		frameCard2 = new CardLayout();
		setLayout(frameCard2);
		
		firstHome FH = new firstHome();
		add(FH, "FH");
		
		UpPanel = new JPanel();
		UpPanel.setBounds(0,0,600,790);
		UpPanel.setBackground(Color.green);
		
		TrendCard = new CardLayout();
		UpPanel.setLayout(TrendCard);
		
		add(UpPanel, "UpPanel");
		
		TrendPanelArr = new ArrayList<TrendPanel>();
		
		for(int i = 0; i < Qu.length; i++) {
			IMG = new ImageIcon("pic1/Q"+i+".png");
			TrendPanel tp = new TrendPanel();
			tp.Qu.setText(Qu[i]);
			tp.A1.setText(A1[i]);
			tp.A2.setText(A2[i]);
			tp.A3.setText(A3[i]);
			tp.A4.setText(A4[i]);


			TrendPanelArr.add(tp);
			tp.setName(i+""); //각 패널들 이름 지정
			UpPanel.add(tp,i+"");

		}
		
		for (int i = 0; i < res1st.length; i++) {
			rimg = new ImageIcon("image/R"+(i+1)+".jpg");
			TrendResult tr = new TrendResult();
			tr.res1.setText(res1st[i]);
			tr.res2.setText(res2nd[i]);
			tr.res3.setText(res3rd[i]);
			tr.res4.setText(res4th[i]);
			
			add(tr, "res"+i);
			tr.setName("res"+i);
		}
		
		frameCard2.show(getContentPane(), "FH");
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new TrendPanelMain();
	}

}