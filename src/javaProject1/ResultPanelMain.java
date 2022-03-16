package javaProject1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultPanelMain extends JFrame{
	
	String [] features = {
			"별따먹자", //INFP_박수지
			"프레첼", //ESFJ_최한별
			"꿀꽈배기" //ISFJ_송지은
	};
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
	
	String [] MBTItype= {
			"INFP",
			"ESFJ",
			"ISFJ"
	};
	
	ImageIcon IMG;
	
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
			
			
			feats = new TextArea("", 10, 10,1);
//			feats.SCROLLBARS;
			feats.setBounds(50, 380, 500, 110);
			feats.setEditable(false);
			
			JLabel friendship = new JLabel("인간관계");
			friendship.setBounds(50,500,80,50);
			Font friendshipF = new Font("휴먼둥근헤드라인", Font.PLAIN,20);
			friendship.setFont(friendshipF);
			
			friends = new TextArea("", 10, 10,1);
			friends.setBounds(50, 550, 500, 100);
			friends.setEditable(false);
			
			//ImageIcon img1 = new ImageIcon("pic1/INFP.png");
			JLabel resImg = new JLabel(IMG);
			resImg.setBounds(190,70,225,230);

			add(resImg);
			add(you);
			add(name);
			add(features);
			add(feats);
			add(friendship);
			add(friends);
			}
		}
	
	public ResultPanelMain() {
		super("결과창");
		setBounds(200, 10, 600, 800);
	    setLayout(null);
	    for(int i = 0; i<feats.length; i++) {
	    	IMG = new ImageIcon("pic1/MBTI"+(i+1)+".png");
	    	ResultPanel rr = new ResultPanel();
	    	rr.features.setText(features[i]);
	    	rr.feats.setText(feats[i]);
	    	rr.friends.setText(friends[i]);
	    	
	    	rr.setName(MBTItype[i]);
	    	add(rr,MBTItype[i]);
	    }
	    
	    
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ResultPanelMain();
	}

}
