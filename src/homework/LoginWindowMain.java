package homework;

import java.awt.Color;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindowMain {

	public static void main(String[] args) {
		//회원가입창 생성
		JFrame f = new JFrame("회원가입 창");
		f.setSize(800,800);
		f.setBounds(100, 50, 800,700);
		f.setLayout(null);
		
		//대문글자 출력상자
		JLabel main = new JLabel("회원가입");
		main.setBounds(350, 20, 100, 50);
		f.add(main);
		
		//'ID' 출력상자
		JLabel idLB = new JLabel("ID");
		idLB.setBounds(150, 80, 100, 50);
		f.add(idLB);
		//아이디 입력상자
		JTextField id = new JTextField();
		id.setBounds(200,95,100,20);
		f.add(id);
		
		//'PW' 출력상자
		JLabel pwLB1 = new JLabel("PW");
		pwLB1.setBounds(150, 120, 100, 50);
		f.add(pwLB1);
		
		//비밀번호 입력상자
		JPasswordField pw1 = new JPasswordField();
		pw1.setBounds(200,135,100,20);
		f.add(pw1);
		
		//주의사항 출력상자
		JLabel pn = new JLabel("(※영문대소문자,숫자,특수기호로 조합하여 8자리이상)");
		pn.setBounds(155, 155, 500, 20);
		f.add(pn);
		
		//'PW확인' 출력상자
		JLabel pwLB2 = new JLabel("PW확인");
		pwLB2.setBounds(150, 165, 100, 50);
		f.add(pwLB2);
		
		//pw 입력상자
		JPasswordField pw2 = new JPasswordField();
		pw2.setBounds(200,180,100,20);
		f.add(pw2);
		
		//'이름' 출력상자
		JLabel nameLB = new JLabel("이름");
		nameLB.setBounds(150, 200, 100, 50);
		f.add(nameLB);
		
		//이름 입력상자
		JTextField name = new JTextField();
		name.setBounds(200,215,100,20);
		f.add(name);
		
		//'생년월일' 출력상자
		JLabel birthLB = new JLabel("생년월일");
		birthLB.setBounds(140, 240, 100, 50);
		f.add(birthLB);
		
		 //년도 입력상자
		JTextField year = new JTextField();
		year.setBounds(200,255,50,20);
		f.add(year);
		
		//'년' 출력상자
		JLabel year1 = new JLabel("년");
		year1.setBounds(255, 240, 100, 50);
		f.add(year1);
		
		//월 선택 콤보상자
		Vector<String> month = new Vector<String>();
		month.add("월");
		month.add("1월");
		month.add("2월");
		month.add("3월");
		month.add("4월");
		month.add("5월");
		month.add("6월");
		month.add("7월");
		month.add("8월");
		month.add("9월");
		month.add("10월");
		month.add("11월");
		month.add("12월");
		JComboBox<String> box = new JComboBox<String>(month);
		box.setBounds(280, 255, 60, 20);
		f.add(box);

		//일(날짜)입력상자
		JTextField date = new JTextField();
		date.setBounds(355,255,50,20);
		f.add(date);
		
		//'일' 출력상자
		JLabel date1 = new JLabel("일");
		date1.setBounds(410, 240, 100, 50);
		f.add(date1);
		
		//성별 선택
		JLabel gender = new JLabel("성별");
		gender.setBounds(150, 285, 100, 50);
		f.add(gender);
		
		//성별 선택 콤보상자
		Vector<String> gender1 = new Vector<String>();
		gender1.add("성별");
		gender1.add("남자");
		gender1.add("여자");
		JComboBox<String> box1 = new JComboBox<String>(gender1);
		box1.setBounds(200,300,60,20);
		f.add(box1);
		
		//이메일
		JLabel email = new JLabel("E-Mail");
		email.setBounds(150, 330, 100, 50);
		f.add(email);
		
		//이메일 앞자리 입력상자
		JTextField email1 = new JTextField();
		email1.setBounds(200,345,80,20);
		f.add(email1);
		
		//'@'출력상자
		JLabel email2 = new JLabel("@");
		email2.setBounds(290, 330, 100, 50);
		f.add(email2);
		
		//도메인 콤보상자
		Vector<String> domain = new Vector<String>();
		domain.add("도메인");
		domain.add("naver.com");
		domain.add("daum.com");
		domain.add("gmail.com");
		domain.add("yahoo.com");
		domain.add("co.kr");
		domain.add("직접입력");
		JComboBox<String> box3 = new JComboBox<String>(domain);
		box3.setBounds(315, 345, 95, 20);
		f.add(box3);
		
		//휴대폰 번호
		JLabel phone = new JLabel("휴대전화 번호");
		phone.setBounds(150, 370, 100, 50);
		f.add(phone);
		
		//010 콤보박스
		Vector<String> phone1 = new Vector<String>();
		phone1.add("010");
		phone1.add("011");
		phone1.add("070");
		phone1.add("02");
		JComboBox<String> box4 = new JComboBox<String>(phone1);
		box4.setBounds(150, 420, 60, 20);
		f.add(box4);
		
		//'-'출력상자
		JLabel slash = new JLabel("-");
		slash.setBounds(220, 420, 20, 20);
		f.add(slash);
		
		//뒷자리 번호 입력
		JTextField phone2 = new JTextField();
		phone2.setBounds(235,420,100,20);
		f.add(phone2);
		
		//주의사항 출력상자
		JLabel notice = new JLabel("(※'-'제외하고 입력해주세요.)");
		notice.setBounds(340, 420, 200, 20);
		f.add(notice);
		
		//'주소입력' 출력상자
		JLabel adress = new JLabel("주소입력");
		adress.setBounds(150, 450, 100, 50);
		f.add(adress);
		
		//주소 입력상자
		JTextField adressin = new JTextField();
		adressin.setBounds(150,490,400,20);
		f.add(adressin);
		
		//주소검색 버튼
		JButton a1 = new JButton("주소 검색");
		a1.setBounds(400, 465, 110, 20);
		a1.setBackground(Color.gray);
		f.add(a1);
		
		//프로필 사진 첨부
		ImageIcon icon = new ImageIcon("pic/시바견.jpg");
		JButton p1 = new JButton("프로필 첨부",icon);
		p1.setBounds(480, 90, 200, 250);
		p1.setBackground(Color.yellow);
		f.add(p1);
		
		//확인 버튼
		JButton b1 = new JButton("가입 확인");
		b1.setBounds(390, 600, 110, 30);
		b1.setBackground(Color.yellow);
		f.add(b1);
		
		//취소 버튼
		JButton b2 = new JButton("취 소");
		b2.setBounds(240, 600, 110, 30);
		b2.setBackground(Color.pink);
		f.add(b2);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
