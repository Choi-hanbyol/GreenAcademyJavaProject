/*
이메일을 검사하세요
ex)abcd123@aaaaa.bb.cc
     아이디   도메인
1. @가 1개만 있어야 한다---> @를 기준으로 아이디, 도메인이 분리
2. 아이디는 영문, 숫자로만 구성, 5글자 이상
3. 도메인은 . 갯수가 1,2 이어야 하며
	1개  :  기관명. 기관종류   daum.net
	2개  :  기관명. 기관종류.국가    yahoo.co.kr
	단, 기관종류, 국가명은 특정 값은 없는 걸로 인지(영문 소문자이면 가능)
	기관명은 영문, 숫자가능, 4자 이상
*/
package util_p;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailCheck {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("이메일을 입력 : ");
			String email = sc.nextLine();
			String ttt = "[a-zA-Z0-5]{5,}@[a-zA-Z0-9]{4,}[.]([a-z]{3}|[a-z]{2}[.][a-z]{2})";
			if(!Pattern.matches(ttt,email)) {
				System.out.println("error");
				continue;
			}
			break;
		}
		System.out.println("입력 종료");
	}

}
