package oops_p;

import java.util.Scanner;

public class UserLoginMain {

	public static void main(String[] args) {
		
		String pid = "aaa", ppw = "1234";
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				
				System.out.println("ID 입력 : ");
				String id = sc.next();
				
				if(!id.equals(pid)) {
					throw new Exception("ID 에러!!!");
				}
				
				System.out.println("PW 입력 : ");
				String pw = sc.next();
				
				if(!pw.equals(ppw)) {
					throw new Exception("PW 에러!!!");
				}
				
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("로그인 성공!");
	}

}
