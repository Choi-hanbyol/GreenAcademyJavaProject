package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LogInMain {

	public static void main(String[] args) throws Exception{
		String uid, upw;
//		String [] user = null;
		String str;
		String id, pw, name;
		
		FileReader fr = new FileReader("fff/userInfo.txt");
		BufferedReader br = new BufferedReader(fr);
		
//		ArrayList<String> userinfo = new ArrayList<String>();
		String[] userinfo = null;

		while((str=br.readLine()) != null) {
			userinfo=str.split(","); //txt에서 불러온걸 userinfo에 저장
			id = userinfo[0];
			pw = userinfo[1];
			name = userinfo[2];
			//로그인창
			Boolean ck = true;
			System.out.println("=====로그인창=====");
			Scanner sc = new Scanner(System.in);
			while(ck) {
				System.out.print("ID입력 : ");
				uid = sc.next();
				
				if(uid.equals(id)) {
					System.out.print("PW입력 : ");
					upw = sc.next();
					
					if(upw.equals(pw)) {
						System.out.println("로그인완료! "+name+"님 반갑습니다.");
						ck=false;
					}
					else {
						System.out.println("!!!비밀번호 오류!!!");
						ck=true;
					}
				}
				else {
					System.out.println("!!!아이디 오류!!!");
					ck=true;
				}	
			}

		}

		br.close();
		fr.close();
	}

}
