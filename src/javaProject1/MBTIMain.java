package javaProject1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.*;

public class MBTIMain extends JFrame {
	
	class FirstHome extends JPanel implements ActionListener{	// 초기 화면 - 시작버튼
		
		public FirstHome() {
			
			setBounds(0, 0, 600, 650);
			setLayout(null);
			
			JLabel wel = new JLabel("2022 테스트에 오신걸 환영합니다.");
			wel.setBounds(50, 45, 600, 100);
			Font welf = new Font("휴먼둥근헤드라인", Font.PLAIN, 30);
			wel.setFont(welf);
			
			// 첫 화면 이미지
			ImageIcon icon = new ImageIcon("pho/science.png");
			ImageIcon icon2 = new ImageIcon("pho/science2.png");
			JLabel ic = new JLabel(icon);
			JLabel ic2 = new JLabel(icon2);
			ic.setBounds(95, 200, 250,200);
			ic2.setBounds(280, 200, 250, 200);
			add(ic);
			add(ic2);
			
			
			// 두 가지 테스트 시작 버튼 두 가지
			JButton start = new JButton("성격 유형 검사 하러가기");	// 첫 번째 검사버튼
			Font startf = new Font("휴먼모음T", Font.BOLD, 25);
			start.setFont(startf);
			start.setBounds(120, 450, 350, 80);
			start.setBackground(new Color(92, 209, 229));
			start.addActionListener(this);	// 첫 번째 테스트 버튼 눌렀을 시
			
			JButton start2 = new JButton("사막 심리 테스트");	// 다른 검사 버튼
			start2.setFont(startf);
			start2.setBounds(120, 540, 350, 80);
			start2.setBackground(new Color(153, 112, 0));
//			start2.addActionListener(this);	// 두 번째 테스트 버튼 눌렀을 시
			
			JButton start3 = new JButton("트렌드 능력고사 보러가기");
			start3.setFont(startf);
			start3.setBounds(120, 630, 350, 80);
			start3.setBackground(new Color(67, 116, 217));
			
			add(wel);
			add(start);
			add(start2);
			add(start3);
		}

		@Override
		public void actionPerformed(ActionEvent e) {	// start버튼 눌렀을때
			frameCard.show(getContentPane(), "upPanel");
		}
	}

	String[] questions = {
			"친구의 소개로 소개팅에 나온 나는?",
			"주말에 난?",
			"다른 사람과 이야기 할 때 나는?",
			"친구들과의 약속이 취소된다면 나는?",
			"갑자기 약속이 잡히게 된다면?",

			"연인이 길을 가다가 누군가와 부딪혔다. 그때의 나는?",
			"<html><body><center>애인이 나 변한 거 없어?<br> <br>라고 물어볼때 나는?</center></body></html>",
			"<html><body><center>직장 상사가 짜증나게 할 때<br> <br>연인과 통화하면 나는?</center></body></html>",
			"연인과의 말다툼 중 나는?",
			"아래의 말 중 내가 동료들에게 들은 말은?",

			"<html><body><center>고민을 얘기하는 친구, 듣다 보니<br> <br>친구의 잘못인 것 같다. 그럴 때 나는?</center></body></html>",
			"누군가의 부탁을 거절해야 하는 상황이 오면 나는?",
			"다른 사람과 대화할 때 거슬린다고 생각되는 것은?",
			"누군가를 설득할 때 나는?",
			"화났을 때 나는?",

			"여행을 갔을 때 나의 모습과 비슷한 것은?",
			"내가 편안함을 느낄 때는?",
			"계획이란",
			"준비물을 준비할 때 나는?",
			"<html><body><center>끝나고 집에 가서 공부하려 했는데,<br> <br>친구들이 놀자고 붙잡는다.</center></body></html>"
	};

	String[] answers1 = {

			"먼저 말 걸면서 분위기를 띄운다.",
			"혼자 있는 게 싫지 않은 편이다.",
			"내가 주로 말 하는 편이다.",
			"친구들을 만나지 못해 아쉽다.",
			"갑작스런 만남은 재밌고 좋다.",

			"저기요! 사과하셔야죠! 일단 따지고 본다. ", //S
			"앞머리 잘랐어? 틀린 그림 찾기처럼 다 찾아낸다.", //S
			"<html><body><center>오늘 나에게 일어난 일을<br> <br>처음부터 끝까지 다 이야기한다.</center></body></html>", //S
			"연인의 기분이 조금 상하더라도 팩트가 우선이다.",
			"과장님은 너무 칼같아요. 먼저 다가가기 어려워요.",
			
			"논리적으로 친구의 잘못된 점을 말해 준다.",
			"단호하게 할 수 없다고 말한다.",
			"대화의 주제에 벗어나거나 잘못된 사실을 말할 때",
			"<html><body><center>상대방의 의견보다 더<br> <br>합리적이고 논리적인 방안을 제시한다.</center></body></html>",
			"논리적으로 잘 말하면서 따진다.",

			"<html><body><center>기존에 내가 미리 준비한 계획이 틀어지면<br> <br>마음이 불안하지만 플랜B를 꺼낸다.</center></body></html>",
			"<html><body><center>준비되어 있다는 편안함을 위해<br> <br>미리미리 계획해야 마음의 안정감을 느낀다.</center></body></html>",
			"<html><body><center>세세하게 세우지 않더라도 전체적인 틀이나<br> <br>그 날 하루의 가이드라인 같은 것</center></body></html>",
			"하루 전 날 미리 준비한다.",
			"계획에 없던 일인데...매우 당황스럽다."
	};

	String[] answers2 = {
			"말을 걸어올 때까지 기다리고 본다.",
			"사람들과 만나는 것을 즐긴다.",
			"내가 주로 듣는 편이다.",
			"<html><body><center>친구들을 만나는게 싫진 않지만,<br> <br>약속이 취소되어 혼자있게 된 시간이 좋다.</center></body></html>",
			"<html><body><center>갑작스런 만남은 부담스럽다.<br> <br> 최소 며칠 전에 약속하고 만나는게 좋다.</center></body></html>",

			"괜찮아? 다친데 없어? 연인을 위로한다.", //N
			"스타일이 바뀌었네? 잘 눈치 못채서 삐질삐질", //N
			"일단 상사 욕부터 하고 있었던 일은 대충 얘기한다.", //N
			"팩트보다는 연인의 기분이 우선이다. ",//N
			"<html><body><center>과장님은 따뜻하고 상냥하세요.<br> <br>사회생활하기에 너무 여려요</center></body></html>",//N

			"<html><body><center>직접적으로 말하면 친구가 그래 할까봐<br> <br>최대한 돌려서 말한다.</center></body></html>",
			"고민하다가 대부분 들어주는 편이다.",
			"다른 사람의 감정을 무시하는 표현을 할 때",
			"<html><body><center>상대방의 감정을 공감하면서<br> <br>대화하며 설득하려고 노력한다.</center></body></html>",
			"할 말이 많지만 너무 분해서 눈물부터 난다.",

			"그날의 기분, 날씨에 따라 유동적으로 계획을 세운다.",
			"<html><body><center>내가 하고 싶은 일을 자유롭게 할 수 있을 때<br> <br>마음이 편하다.</center></body></html>",
			"계획? 무계획도 계획의 일부다.",
			"'내일 챙겨야지' 하다가 까먹고 놓고 오는 일이 많다.",
			"오케이! 역시 계획대로 안 되는 것이 인생! 놀자!!!"
	};

	String[] types = {
			"EI",
			"SN",
			"TF",
			"JP"
	};
	
	ArrayList<Character> answerArr;

	class QAPanel extends JPanel implements ActionListener{

		JLabel question;
		JToggleButton answer1;
		JToggleButton answer2;
		JButton back;
		JButton next;
		String type;

		public QAPanel() {

			setBackground(Color.white);
			setLayout(null);
			
			Font qfont = new Font("함초롬돋움", Font.BOLD, 18);
			Font afont = new Font("함초롬돋움", Font.BOLD, 15);

			question = new JLabel();
			answer1 = new JToggleButton();
			answer2 = new JToggleButton();
			back = new MoveButton("<<");
			next = new MoveButton(">>");
			
			answer1.setName("answer1");
			answer2.setName("answer2");
			answer1.addActionListener(this);
			answer2.addActionListener(this);

			ButtonGroup bg = new ButtonGroup();
			bg.add(answer1);
			bg.add(answer2);

			question.setBounds(-5, 150, 600, 100);
			question.setHorizontalAlignment(JLabel.CENTER);
			question.setFont(qfont);
			
			answer1.setBounds(95, 300, 400, 100);
			answer1.setHorizontalAlignment(SwingConstants.CENTER);
			answer1.setBackground(Color.white);
			answer1.setFont(afont);
			answer2.setBounds(95, 450, 400, 100);
			answer2.setHorizontalAlignment(SwingConstants.CENTER);
			answer2.setBackground(Color.white);
			answer2.setFont(afont);
			
			back.setBounds(30, 180, 50, 50);
			back.setBackground(Color.white);
			back.setBorderPainted(false);
			next.setBounds(500, 180, 50, 50);
			next.setBackground(Color.white);
			next.setBorderPainted(false);
			
			add(question);
			add(answer1);
			add(answer2);
			add(back);
			add(next);
			
			answerArr = new ArrayList<Character>();
			for (int i = 0; i < questions.length; i++) {
				answerArr.add(null);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JToggleButton now = (JToggleButton)e.getSource();
			String name = ((QAPanel)now.getParent()).getName();
			System.out.println(name);
			String type = ((QAPanel)now.getParent()).type;
			if(now.getName()=="answer1") {
				answerArr.set(Integer.parseInt(name), type.charAt(0));
			}else {
				answerArr.set(Integer.parseInt(name), type.charAt(1));
			}
		}
	}
	
	class MoveButton extends JButton implements ActionListener{
		
		public MoveButton(String name) {
			super(name);
			setName(name);
			addActionListener(this);
		}

 @Override
		public void actionPerformed(ActionEvent e) {
			
			String now = ((JButton)e.getSource()).getParent().getName();
			
			if(((JButton)e.getSource()).getName()=="<<") {
				QACard.show(upPanel, Integer.parseInt(now)-1+"");
			}
			else {
				if(now.equals("19")) {
					boolean check = true;

					for (int i = 0; i < answerArr.size(); i++) {
						if(answerArr.get(i)==null) {
							check = false;
						}
					}
					
					if(check) {
						rr.resultCal(answerArr);
						frameCard.show(getContentPane(), "resultPanel");
					}
				}
					QACard.show(upPanel, Integer.parseInt(now)+1+"");
			}
			
		}
	}

	class ResultPanel extends JPanel{
		
		public ResultPanel() {
			
			setBounds(0,0,600,650);
			setLayout(null);

			JLabel res = new JLabel("당신은...");
			res.setBounds(50,45,600,100);
			Font resf = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			res.setFont(resf);

			ImageIcon img1 = new ImageIcon("pic/dog2.jpg"); //이미지로 한번 넣어봤습니다.
			JLabel resImg = new JLabel(img1);
			resImg.setBounds(20,200,550,400);
			resImg.setBackground(Color.cyan);
			add(resImg);
			add(res);

		}
		
		String resultCal(ArrayList<Character> arr){
			
			String resultType = "";
			String types = "EISNTFJP";
			
			LinkedHashMap<Character, Integer> calMap = new LinkedHashMap<Character, Integer>();
			for (int i = 0; i < types.length(); i++) {
				calMap.put(types.charAt(i), 0);
			}
			
			for (Character c : arr) {
				for (Character key : calMap.keySet()) {
					if(c==key) {
						calMap.put(key, calMap.get(key)+1);
					}
				}
			}
			
			for (int i = 0; i < types.length()-1; i+=2) {
				if(calMap.get(types.charAt(i)) > calMap.get(types.charAt(i+1))) {
					resultType += types.charAt(i);
				}
				else {
					resultType += types.charAt(i+1);
				}
			}
			
			System.out.println(resultType);
			
			return resultType;
		}
	}
	
	ArrayList<QAPanel> qaPanelArr;
	CardLayout frameCard;
	CardLayout QACard;
	JPanel upPanel;
	ResultPanel rr;

	public MBTIMain() {

		super("제목");
		setBounds(200, 100, 600, 800);
		frameCard = new CardLayout();
		setLayout(frameCard);

		FirstHome fm = new FirstHome();
		add(fm, "fm");
		
		
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 600, 650);
		upPanel.setBackground(Color.pink);

		QACard = new CardLayout();
		upPanel.setLayout(QACard);

		add(upPanel, "upPanel");
		
		qaPanelArr = new ArrayList<QAPanel>();

		for (int i = 0; i < questions.length; i++) {
			QAPanel qa = new QAPanel();
			qa.question.setText(questions[i]);
			qa.answer1.setText(answers1[i]);
			qa.answer2.setText(answers2[i]);
			if(i<5) {
				qa.type = types[0];
			}
			else if(i<10) {
				qa.type = types[1];
			}
			else if(i<15) {
				qa.type = types[2];
			}
			else{
				qa.type = types[3];
			}
			
			qaPanelArr.add(qa);
			qa.setName(i+"");
			upPanel.add(qa, i+"");
		}
		
		rr = new ResultPanel();
		add(rr, "resultPanel");
		
		frameCard.show(getContentPane(), "fm");

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new MBTIMain();
	}

}