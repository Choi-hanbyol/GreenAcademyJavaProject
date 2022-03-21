/*
 *회원가입 과 로그인을 구현하세요
 *회원정보 -> ID, 암호, 이름
 *ID중복확인검사->할 수 있으면 해보기
*/
 
package homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class SignUpMain {

	public static void main(String[] args) throws Exception {
		String name = "";
		String id = "";
		String pw = "";
		int chk = 0;
		Boolean ck = true;
		Scanner sc = new Scanner(System.in);
		
		while(ck) {
			System.out.println("회원가입 : 1 / 종료 : 2");
			System.out.print("선택 : ");
			chk = sc.nextInt();
			switch(chk) {
			case 1 :
				System.out.print("ID 입력 : ");
				id = sc.next();
				System.out.print("PW 입력 : ");
				pw = sc.next();
				System.out.print("이름 입력 : ");
				name = sc.next();
				System.out.println("회원가입 완료!!");
				System.out.println("========================");
				System.out.println(id+"/"+pw+"/"+name);
				
				FileWriter fw = new FileWriter("fff/userInfo.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(id+",");
				bw.write(pw+",");
				bw.write(name+"\n");

				bw.close();
				fw.close();
				
				break;
			case 2 :
				System.out.println("회원가입을 종료합니다.");
				System.out.println("========================");
				ck=false;
				break;
			}
		}
		
	}	
}