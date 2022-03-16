package javaProject1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import javaProject1.TrendPanelMain.ButtonMove;
import javaProject1.TrendPanelMain.TrendPanel;
import javaProject1.TrendPanelMain.TrendResult;
import javaProject1.TrendPanelMain.TrendTimer;

public class PsychologicalTestMain extends JFrame {

	class FirstHome extends JPanel implements ActionListener{	// 초기 화면 - 시작버튼

		public FirstHome() {

			setBounds(0, 0, 600, 650);
			setLayout(null);

			JLabel wel = new JLabel("2022 테스트에 오신걸 환영합니다.");
			wel.setBounds(50, 45, 600, 100);
			Font welf = new Font("휴먼둥근헤드라인", Font.PLAIN, 30);
			wel.setFont(welf);

			// 첫 화면 이미지
			ImageIcon icon = new ImageIcon("pic1/science.png");
			ImageIcon icon2 = new ImageIcon("pic1/science2.png");
			JLabel ic = new JLabel(icon);
			JLabel ic2 = new JLabel(icon2);
			ic.setBounds(95, 200, 250,200);
			ic2.setBounds(280, 200, 250, 200);
			add(ic);
			add(ic2);


			//세 가지 테스트 시작 버튼
			JButton start = new JButton("성격 유형 검사 하러가기");	// 첫 번째 검사 버튼
			Font startf = new Font("휴먼모음T", Font.BOLD, 25);
			start.setFont(startf);
			start.setBounds(120, 450, 350, 80);
			start.setBackground(new Color(92, 209, 229));
			start.setName("upPanel");
			start.addActionListener(this);	// 첫 번째 테스트 버튼 눌렀을 시

			JButton start2 = new JButton("사막 심리 테스트");	// 두 번째 검사 버튼
			start2.setFont(startf);
			start2.setBounds(120, 540, 350, 80);
			start2.setBackground(new Color(153, 112, 0));
			start2.setName("Desert");
			start2.addActionListener(this);	// 두 번째 테스트 버튼 눌렀을 시

			JButton start3 = new JButton("트렌드 능력고사 보러가기");	//세 번째 검사 버튼
			start3.setFont(startf);
			start3.setBounds(120, 630, 350, 80);
			start3.setBackground(new Color(67, 116, 217));
			start3.setName("Trend");
			start3.addActionListener(this);	//세 번째 테스트 버튼 눌렀을 시

			add(wel);
			add(start);
			add(start2);
			add(start3);
		}

		@Override
		public void actionPerformed(ActionEvent e) {	// start버튼 눌렀을때
			frameCard.show(getContentPane(), ((JButton)e.getSource()).getName());
			if(((JButton)e.getSource()).getName().equals("upPanel")) {
				qaPanelArr.get(mbtiNow).requestFocus();
			}
			else if(((JButton)e.getSource()).getName().equals("Trend")) {
				tt = new TrendTimer();
				tt.start();
			}
		}
	}

	//성격 유형 테스트 문제
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
			"다른 사람과 대화할 때 거슬린다고 생각하는 것은?",
			"누군가를 설득할 때 나는?",
			"화났을 때 나는?",

			"여행을 갔을 때 나의 모습과 비슷한 것은?",
			"내가 편안함을 느낄 때는?",
			"계획이란?",
			"준비물을 준비할 때 나는?",
			"<html><body><center>끝나고 집에 가서 공부하려 했는데,<br> <br>친구들이 놀자고 붙잡는다.</center></body></html>"
	};

	//성격 유형 테스트 답변1
	String[] answers1 = {

			"먼저 말 걸면서 분위기를 띄운다.",
			"사람들과 만나는 것을 즐긴다.",
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

	//성격 유형 테스트 답변2
	String[] answers2 = {
			"말을 걸어올 때까지 기다리고 본다.",
			"혼자 있는 게 싫지 않은 편이다.",
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

	//각 문제가 어떤 지표를 판단하는 문제인지 지정해 주기 위함
	String[] types = {
			"EI",
			"SN",
			"TF",
			"JP"
	};

	//사용자의 답변을 저장할 ArrayList
	ArrayList<Character> answerArr;
	
	
	int mbtiNow = 0;

	//성격 유형 테스트 문제 화면
	class QAPanel extends JPanel implements ActionListener, KeyListener{

		JLabel question;
		JToggleButton answer1;
		JToggleButton answer2;
		JButton back;
		JButton next;
		JProgressBar progress;
		JLabel progressText;
		String type;
		

		public QAPanel() {

			setBackground(new Color(235, 248, 255));
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
			back.setOpaque(false);
			next.setBounds(500, 180, 50, 50);
			next.setBackground(Color.white);
			next.setOpaque(false);
			next.setBorderPainted(false);

			progress = new JProgressBar(JProgressBar.HORIZONTAL, 0, 20);
			progress.setBounds(95, 620, 400, 20);
			progress.setBackground(Color.white);
			progress.setForeground(new Color(181, 178, 255));

			progressText = new JLabel();
			progressText.setBounds(-5, 645, 600, 20);
			progressText.setFont(afont);
			progressText.setHorizontalAlignment(JLabel.CENTER);

			add(question);
			add(answer1);
			add(answer2);
			add(back);
			add(next);
			add(progress);
			add(progressText);
			
			addKeyListener(this);

			//사용자의 답변을 저장할 ArrayList에 미리 문항 갯수에 맞게 자리를 만들어줌
			answerArr = new ArrayList<Character>();
			for (int i = 0; i < questions.length; i++) {
				answerArr.add(null);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//답변을 선택하면 answerArr에 저장하도록 하는 actionlistener
			
			JToggleButton ans = (JToggleButton)e.getSource();			//선택한 답변의 번호
			String name = ((QAPanel)ans.getParent()).getName();			//현재 풀고 있는 문제의 번호
			String type = ((QAPanel)ans.getParent()).type;				//현재 풀고 있는 문제의 타입
			if(ans.getName()=="answer1") {
				//첫번째 답변을 선택했으면 타입의 앞글자를 answerArrayList에 저장  ex) EI => E
				answerArr.set(Integer.parseInt(name), type.charAt(0));
			}else {
				//두번째 답변을 선택했으면 타입의 뒷글자를 answerArrayList에 저장  ex) EI => I
				answerArr.set(Integer.parseInt(name), type.charAt(1));
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_1) {
				answer1.doClick();
			}
			if(e.getKeyCode()==KeyEvent.VK_2) {
				answer2.doClick();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

	//문항 이전, 다음 이동 버튼
	class MoveButton extends JButton implements ActionListener{

		public MoveButton(String name) {
			super(name);
			setName(name);
			addActionListener(this);
		}

		//이전, 다음으로 이동하는 actionListener
		@Override
		public void actionPerformed(ActionEvent e) {

			//현재 풀고 있는 문제의 번호
			mbtiNow = Integer.parseInt(((JButton)e.getSource()).getParent().getName());

			if(((JButton)e.getSource()).getName()=="<<") {					//이전 버튼을 누르면
				if(mbtiNow!=0) {
					mbtiNow--;
					qaCard.show(upPanel,mbtiNow+"");			//이전 문항으로 이동
					qaPanelArr.get(mbtiNow).requestFocus();
				}
			}
			else { //다음 버튼을 누르면
				if(mbtiNow==19) {									//마지막 문항일 경우
					boolean check = true;

					String nonSel = "";
					int cnt = 0;

					for (int i = 0; i < answerArr.size(); i++) {		//답변에 null이 들어간 문제가 있는지 체크한다.
						if(answerArr.get(i)==null) {
							nonSel += (i+1)+"번, ";						//답변이 null인 문제를 저장
							cnt++;
							if(cnt%5==0) {								//답변을 선택하지 않은 문제가 많을 경우
								nonSel += "<br>";						//줄바꿈을 해줌
							}
							check = false;								//답변이 null이면 결과화면으로 넘어가지 못하도록 한다
						}
					}

					if(check) {		//모든 문제의 답변이 선택되었을 경우
						frameCard.show(getContentPane(), "resload");	//결과 로딩창으로 넘어간다.
						resl.thread.start();							//5초 후 결과 보기 버튼이 생성된다.
					}
					else {			//답변이 선택되지 않은 문항이 있는 경우
						Warning warn = new Warning();	//경고창을 띄운다.
						warn.warnText.setText("<html><body><center>"+nonSel.substring(0, nonSel.length()-2)+"<br>문항의 답변이<br>선택되지 않았습니다.</body></html>");
						warn.setVisible(true);
					}
				}
				else {
					mbtiNow++;
					
					//마지막 문항이 아닌 경우 다음 문항으로 넘어간다.
					qaCard.show(upPanel, mbtiNow+"");
					qaPanelArr.get(mbtiNow).requestFocus();
				}
			}

		}
	}

	//답변을 모두 선택하지 않았는데 다음 버튼을 누른 경우에 뜨는 경고창
	class Warning extends JDialog{

		JLabel warnText;

		public Warning() {
			super(PsychologicalTestMain.this, "Warning", true);
			setBounds(400, 400, 200, 150);
			setLayout(new BorderLayout());
			warnText = new JLabel();
			warnText.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
			warnText.setHorizontalAlignment(JLabel.CENTER);
			add(warnText);
		}
	}

	
	class ResultLoading extends JPanel implements ActionListener{	// 결과 로딩창

		Thread thread;

		public ResultLoading() {

			setLayout(null);
			setBounds(0, 0, 600, 800);
			ImageIcon img = new ImageIcon("pic1/loading.gif");
			JLabel imgp = new JLabel(img);
			imgp.setBounds(130, 200, 300, 300);

			// 5초뒤 결과보기 버튼 쨘
			JButton resb = new JButton("결과보기");
			Font resf = new Font("휴먼편지체", Font.BOLD, 15);
			resb.setFont(resf);
			resb.setBackground(Color.white);
			resb.setBounds(230, 450, 100, 50);
			resb.addActionListener(this);

			thread = new Thread() {

				@Override
				public void run() {
					for (int i = 2; i > 0; i--) {
						try {
							add(imgp);
							Thread.sleep(1000);	// 1초마다
						} catch (InterruptedException e) {

						}

					}
					add(resb);
				}

			};
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//결과 로딩창에서 결과 보기 버튼을 누르면 결과를 계산해서 해당하는 결과 화면을 띄운다.
			frameCard.show(getContentPane(), rr.resultCal(answerArr));
		}

	}

	//성격 유형 테스트 결과 화면(타입)
	String [] features = {
			"별따먹자", //INFP_박수지
			"프레첼", //ESFJ_최한별
			"꿀꽈배기" //ISFJ_송지은
	};
	//성격 유형 테스트 결과 화면(설명)
	String [] feats = {
			"심리테스트, mbti테스트가 나오면 일단 무조건 하고 보는 편임.\n"
			+ "관종이지만 막상 관심을 받으면 어색해하고 어쩔 줄 모르는 모습이 관찰됨. 끈기 없고,\n"
			+ "계획적이지 못해 벼락치기를 하는 편이지만 막상 하면 잘 해내는 학생임.\n"
			+ "집에 있을 때면 연락은 잘 안되는 편이고, 혼자 있는 것을 선호할 때가 있음.\n"
			+ "가끔은 우울한 모습을 보이는데, 본인의 우울한 감정을 싫어하지 않는 편임.\n"
			+ "사람들한테 상처 주는 것도, 받는 것도 정말 싫어함.",

			"철저하고 질서정연한 학생으로 계획을 잘 세우고 그에 맞춰 생활하고자 노력함.\n"
			+ "공감능력이 뛰어나 평소 남의 일도 내 일처럼 생각하고 고민상담을 해주는 편임.\n"
			+ "그러나 쓸데없이 걱정이 너무 많은 면모도 있어 이를 조금 고칠 필요가 있음.\n"
			+ "핵인싸기질이 있어서 사회생활도 잘하고 자연스럽게 분위기를 풀어나가는 학생임.",

			"하자고 하면 거의 다 해주고 거절, 부탁을 잘 못하는 편의 학생임.\n"
			+ "게으른 완벽주의자 성향이 있어 계획을 세우고 그대로 지켜야 마음이 편함.\n"
			+ "상황에 따라 외향, 내향 왔다갔다하는 편이라 가끔 본인도 본인을 잘 모르겠음.\n"
			+ "배려심도 많고 공감도 잘해주고 사람들이랑 어울리는 거 좋아하는 편임.\n"
			+ "그렇지만 또 혼자 노는 것도 되게 좋아함.\n"
			+ "사람들은 내 인생이 노잼이라지만 난 나름대로 내 인생 재밌고 좋음."
	};
	
	String [] friends = {
			"남이 나를 어떻게 생각할지 늘 고민하고 걱정하는 모습이 보임.\n"
			+ "인간 관계에 조금 예민하게 반응하는 편이라 본인을 소중하게 대해줬으면 함.\n"
			+ "친구랑 있는 게 좋지만 혼자만의 시간도 중요하게 생각하는 학생임.\n"
			+ "친구의 얘기를 잘 들어주지만 속으로 딴 생각 하는 모습이 종종 관찰됨.",

			"사람을 좋아하는 편이라 본인의 사람들이 힘들면 본인도 같이 힘들어지는 편임.\n"
			+ "인간관계가 틀어지면 받는 스트레스가 큰 편이고 타인의 눈치를 조금 보는 편임.\n"
			+ "새로운 사람과 만나서 친해지는 것을 정말 좋아하고 배려왕으로 소문남.",

			"본인을 편안하게 해주는 쪽의 사람, 이벤트 잘 챙겨주고 표현을 잘해주는 학생들을 좋아함.\n"
			+ "외로움은 좀 타는데 그렇다고 많은 사람이랑 놀고 싶지는 않음.\n"
			+ "티는 안 나지만 사실은 인간 관계에서 스트레스를 많이 받는 편임."
	};

	String [] mbtiType= {
			"INFP",
			"ESFJ",
			"ISFJ"
	};

	ImageIcon img;

	//성격 유형 테스트 결과 화면
	class ResultPanel extends JPanel{

		JLabel features;
		TextArea feats;
		TextArea friends;

		public ResultPanel() {

			setBounds(0,0,600,650);
			setLayout(null);

			JLabel you = new JLabel("당신은...");
			you.setBounds(50,15,80,50);
			Font youF = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			you.setFont(youF);

			JLabel name = new JLabel("특징");
			name.setBounds(50,330,80,50);
			Font nameF = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			name.setFont(nameF);

			features = new JLabel();
			features.setBounds(250,300,80,50);
			Font featureF = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			features.setFont(featureF);


			feats = new TextArea();
			feats.setBounds(50, 380, 500, 110);
			feats.setEditable(false);

			JLabel friendship = new JLabel("인간관계");
			friendship.setBounds(50,500,80,50);
			Font friendshipF = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			friendship.setFont(friendshipF);

			friends = new TextArea();
			friends.setBounds(50, 550, 500, 100);
			friends.setEditable(false);

			JLabel resImg = new JLabel(img);
			resImg.setBounds(190,70,225,230);

			add(resImg);
			add(you);
			add(name);
			add(features);
			add(feats);
			add(friendship);
			add(friends);

		}

		
		//성격 유형 테스트 결과를 계산하는 메소드
		String resultCal(ArrayList<Character> arr){

			String resultType = "";
			String types = "EISNTFJP";

			//점수를 저장할 Map 생성
			LinkedHashMap<Character, Integer> calMap = new LinkedHashMap<Character, Integer>();
			//Map에 key로 E, I, S, N, T, F, J, P 값을 넣고 점수를 0으로 초기화한다.
			for (int i = 0; i < types.length(); i++) {
				calMap.put(types.charAt(i), 0);
			}


			for (Character c : arr) {//사용자의 답변을 저장한 ArrayList를 불러와서
				//답변이 E이면 E의 value값 1씩 증가
				for (Character key : calMap.keySet()) {
					if(c==key) {
						calMap.put(key, calMap.get(key)+1);
					}
				}
			}

			//최종적으로 E와 I의 value 중 큰 것, S와 N의 value 중 큰 것, ... 계산 해서
			for (int i = 0; i < types.length()-1; i+=2) {
				if(calMap.get(types.charAt(i)) > calMap.get(types.charAt(i+1))) {
					resultType += types.charAt(i);
				}
				else {
					resultType += types.charAt(i+1);
				}
			}

			return resultType;
			//최종 결과 반환
		}
	}
	
	
	
	//----------------------------------------------성격 유형 테스트 끝----------------------------------------------------------
	
	
	
	//---------------------------------------------사막 심리 테스트 시작----------------------------------------------------------
	
	//사막 심리 테스트 문제 화면
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
			
			//동물 이미지 5개
			for (int i = 0; i < 5; i++) {
				animalImg = new ImageIcon("pic1/D"+(i+1)+".png");
				JLabel animal = new JLabel(animalImg);
				animal.setBounds(55+100*i, 500, 80, 80);
				animal.setName("D"+(i+1));
				animal.addMouseMotionListener(this);
				animal.addMouseListener(this);
				add(animal);
			}
			
			//동물 이미지를 배열할 빈칸 5개
			for (int i = 0; i < 5; i++) {
				JButton blank = new JButton();
				blank.setBounds(55+100*i, 380, 80, 80);
				blank.setEnabled(false);
				add(blank);
			}
			
			//결과 보기 버튼
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
			//동물 이미지를 마우스로 옮길 수 있게 함
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
			//동물 이미지가 빈칸에 착 달라붙도록
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

		@Override //첫번째 빈칸에 위치한 동물로 결과 화면 불러옴
		public void actionPerformed(ActionEvent e) {
			try {
				if((getComponentAt(60, 390).getName()).equals("D1")) {
					frameCard.show(getContentPane(),animalsType[0]);
				}else if((getComponentAt(60, 390).getName()).equals("D2")){
					frameCard.show(getContentPane(),animalsType[1]);
				}
				else if((getComponentAt(60, 390).getName()).equals("D3")){
					frameCard.show(getContentPane(),animalsType[2]);
				}
				else if((getComponentAt(60, 390).getName()).equals("D4")){
					frameCard.show(getContentPane(),animalsType[3]);
				}
				else {
					frameCard.show(getContentPane(),animalsType[4]);
				}
				
			} catch (Exception e2) {//첫번째 빈칸에 동물을 배치하지 않은 경우 경고창 띄움
				Warning2 warn2 = new Warning2();
				warn2.setVisible(true);
			}
			
		}
		
	}
	
	//경고창
	class Warning2 extends JDialog{
		public Warning2() {
			super(PsychologicalTestMain.this, "Warning", true);
			setBounds(400, 400, 200, 150);
			setLayout(new BorderLayout());
			JLabel warnText2 = new JLabel("배치되지 않은 동물이 있습니다.");
			warnText2.setHorizontalAlignment(JLabel.CENTER);
			add(warnText2);
		}
	}
	
	//사막 심리 테스트 결과 화면
	String [] animalsType = {
			"lion", "horse", "cow", "sheep","monkey"
	};
	
	String [] animals = {
			"사자", "말", "소", "양", "원숭이"
	};
	
	String [] results = {
			"<html><body><center>사자는 자존심을 의미한다.<br>"
			+ "<br>사자를 제일 먼저 버린다면 힘든 일 앞에서<br>"
			+ "<br>자존심 쯤은 쉽게 버릴 수 있는 성격이며,<br>"
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
	

	//---------------------------------------------사막 심리 테스트 끝----------------------------------------------------
	
	//--------------------------------------------트렌드 퀴즈 테스트 시작--------------------------------------------------
	String [] qu = { //트렌드 퀴즈 문항
			"1. 다음 빈칸에 들어갈 대답은?",
			"2. 둘리가 하는 말로 옳은 것은?",
			"3. 학생들이 외치는 말로 옳은 것은?",
			"4. 다음 인물의 유행어로 옳지 않은 것은?",
			"5. 위 사진과 어울릴 말은?",
			"6. 위 사진과 관련 없는 대사는?",
			"7. 위 사진에 어울리는 대사는?",
			"8. 다음 빈칸에 들어갈 대답은?",
			"9. 다음 빈칸에 들어갈 알맞은 대답은?",
			"10. 다음 빈칸에 들어갈 대답은?"
	};

	String [] a1 = { //1번보기
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

	String [] a2 = { //2번보기
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

	String [] a3 = { //3번보기
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

	String [] a4 = { //4번보기
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
	
	String [] rightAnswer = {"2", "1", "3", "4", "3", "4", "2", "1", "2", "4"};
	ArrayList<String> myAnswer = new ArrayList<String>();

	int score;
	TrendTimer tt;
	boolean check = true;
	
	class TrendTimer extends Thread {	// 시간제한 쓰레드

		@Override
		public void run() {
			while(check) {
				for (int i = 5; i >= 0; i--) {
					trendPanelArr.get(Integer.parseInt(now)).tiLabel.setText("타이머:"+ i);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
				trendCard.show(upPanel2, Integer.parseInt(now)+1+"");
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
		JLabel tiLabel;	// 타이머 멤버

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

			JLabel Qimg1 = new JLabel(img);
			Qimg1.setBounds(100,40,400,300);

			tiLabel = new JLabel("타이머");
			tiLabel.setLayout(null);
			tiLabel.setBounds(400, 320, 100, 80);
			Font ff = new Font("한컴산뜻돋움", Font.BOLD, 20);
			tiLabel.setFont(ff);

			add(Qu);
			add(Qimg1);
			add(A1);
			add(A2);
			add(A3);
			add(A4);
			add(Next);
			add(tiLabel);

			for(int i = 0; i < rightAnswer.length; i++) { //답을 선택안했을때 답을 0으로 넣게
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

					for(int i=0; i<rightAnswer.length; i++) {

						String youAnswer = myAnswer.get(i);

						if(youAnswer.equals(rightAnswer[i])) {
							score++;
						}
					}

					if(score>=0&&score<=2) { //하수로 가라
						frameCard.show(getContentPane(), "res3"); 
					}else if(score>=3&&score<=5) {
						frameCard.show(getContentPane(), "res2"); 
					}
					else if(score>=6&&score<=8) {
						frameCard.show(getContentPane(), "res1"); 
					}
					else { //고수로 가라
						frameCard.show(getContentPane(), "res0"); 
					}
					check = false;
				}
				else {
					tt.stop();
					me++;
					now=me+"";
					trendCard.show(upPanel2, now);
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
	
	//--------------------------------------------JFrame의 Main 시작----------------------------------------------------
	
	ArrayList<QAPanel> qaPanelArr;
	CardLayout frameCard;
	CardLayout qaCard;
	JPanel upPanel;
	ResultPanel rr;
	ResultLoading resl;
	ArrayList<TrendPanel> trendPanelArr;
	CardLayout trendCard;
	JPanel upPanel2;

	public PsychologicalTestMain() {

		super("JavaProject 1");
		setBounds(200, 10, 600, 800);
		frameCard = new CardLayout();		//JFrame의 레이아웃 설정
		setLayout(frameCard);

		FirstHome fm = new FirstHome();		//JFrame에 초기화면 추가
		add(fm, "fm");

		//--------------------------------성격 유형 테스트 화면 추가---------------------------------------

		upPanel = new JPanel();					//성격 유형 테스트 문제 화면이 나올 패널
		upPanel.setBounds(0, 0, 600, 800);
		upPanel.setBackground(Color.pink);

		qaCard = new CardLayout();
		upPanel.setLayout(qaCard);

		add(upPanel, "upPanel");

		qaPanelArr = new ArrayList<QAPanel>();	//성격 유형 테스트 문제 화면들을 저장

		//성격 유형 테스트 문제 화면 생성
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

			qa.progress.setValue(i+1);
			qa.progressText.setText((i+1)+"/20");

			qaPanelArr.add(qa);
			qa.setName(i+"");
			upPanel.add(qa, i+"");

		}
		//성격 유형 테스트 결과 로딩 화면 생성
		resl = new ResultLoading();
		add(resl, "resload");
		
		//성격 유형 테스트 결과 화면 생성
		for(int i = 0; i<feats.length; i++) {
			img = new ImageIcon("pic1/MBTI"+(i+1)+".png");
			rr = new ResultPanel();
			rr.features.setText(features[i]);
			rr.feats.setText(feats[i]);
			rr.friends.setText(friends[i]);

			rr.setName(mbtiType[i]);
			add(rr, mbtiType[i]);
		}
		
		//--------------------------------성격 유형 테스트 화면 끝----------------------------------------

		
		//--------------------------------사막 심리 테스트 화면 시작---------------------------------------
		
		//사막 심리 테스트 문제 화면 추가
		add(new DesertPanel(), "Desert");

		//사막 심리 테스트 결과 화면 추가
		for(int i = 0; i < animals.length; i++) {
			animalImg = new ImageIcon("pic1/D"+(i+1)+".png");
			DesertResultPanel DP = new DesertResultPanel();
			DP.animals.setText(animals[i]);
			DP.results.setText(results[i]);

			DP.setName(animalsType[i]);
			add(DP,animalsType[i]);
		}
		
		//-------------------------------사막 심리 테스트 화면 끝-----------------------------
		
		//-------------------------------트렌드 테스트 화면 시작-------------------------------
		
		upPanel2 = new JPanel();
		upPanel2.setBounds(0,0,600,790);
		upPanel2.setBackground(Color.green);

		trendCard = new CardLayout();
		upPanel2.setLayout(trendCard);

		add(upPanel2, "Trend");

		trendPanelArr = new ArrayList<TrendPanel>();

		for(int i = 0; i < qu.length; i++) {
			img = new ImageIcon("pic1/Q"+i+".png");
			TrendPanel tp = new TrendPanel();
			tp.Qu.setText(qu[i]);
			tp.A1.setText(a1[i]);
			tp.A2.setText(a2[i]);
			tp.A3.setText(a3[i]);
			tp.A4.setText(a4[i]);


			trendPanelArr.add(tp);
			tp.setName(i+""); //각 패널들 이름 지정
			upPanel2.add(tp,i+"");

		}

		for (int i = 0; i < res1st.length; i++) {
			rimg = new ImageIcon("pic1/R"+(i+1)+".jpg");
			TrendResult tr = new TrendResult();
			tr.res1.setText(res1st[i]);
			tr.res2.setText(res2nd[i]);
			tr.res3.setText(res3rd[i]);
			tr.res4.setText(res4th[i]);

			add(tr, "res"+i);
			tr.setName("res"+i);
		}
		
		//---------------------------트렌드 테스트 화면 끝---------------------------
		
		//프로그램이 실행되면 시작 화면이 나오도록 설정
		frameCard.show(getContentPane(), "fm");

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}

	public static void main(String[] args) {
		new PsychologicalTestMain();
	}

}