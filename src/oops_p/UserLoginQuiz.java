package oops_p;

import java.util.Scanner;

class UserData{
	String id, pw, name;

	public UserData(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
}

public class UserLoginQuiz {

	public static void main(String[] args) {
		UserData [] users = {
			new UserData("", "", ""),	
			new UserData("aa", "1111", "이효리"),
			new UserData("bb", "2222", "삼효리"),
			new UserData("cc", "3333", "사효리"),
			new UserData("dd", "4444", "오효리"),
			new UserData("ee", "5555", "육효리")
		};
		
		Scanner sc = new Scanner(System.in);
		
		UserData log;
		while(true) {
			try {
				log = null;
				System.out.print("ID 입력 :");
				String id = sc.next();
				
				for (UserData ud : users) {
					if(id.equals(ud.id)) {
						log = ud;
						break;
					}
				}
				
				if(log==null) {
					throw new Exception("ID 에러!!");
				}
				
				System.out.print("PW 입력 :");
				String pw = sc.next();
				
				if(!log.pw.equals(pw)) {
					throw new Exception("PW 에러!!");
				}

				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
		System.out.println(log.name+"님으로 로그인 성공");

	}

}
