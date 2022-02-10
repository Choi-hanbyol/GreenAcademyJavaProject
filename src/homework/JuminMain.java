//성별, 국적, 생년월일, 한국나이, 만나이, 올해생일, 다가올 생일, 생일D-day를 출력하는 프로그램
//960317-1234567

package homework;
import java.util.Scanner;

public class JuminMain {
	
	public static void main(String[] args) {
		int nowyear = 2022;
		int nowdate = 207;
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요 : ");
		String jumin = sc.nextLine();
		//성별,국적
		int gender = jumin.charAt(7);
		if(gender == '1' || gender=='3') {
			System.out.println("내국인 남자 입니다.");
		}
		else if(gender=='2'|| gender=='4') {
			System.out.println("내국인 여자 입니다.");
		}
		else if(gender=='5'||gender=='7') {
			System.out.println("외국인 남자 입니다.");
		}
		else if(gender=='6'|| gender=='8') {
			System.out.println("외국인 여자 입니다.");
		}
		
		//생년월일, 한국나이, 만나이
		int birth = Integer.parseInt(jumin.substring(0,6));
		int age = Integer.parseInt(jumin.substring(0,2));
		if(gender == '1' || gender=='2'|| gender=='5'|| gender=='6') {
			System.out.println("생년 월일 : 19"+birth);
			System.out.println("한국 나이 : "+(2022-(1900+age)+1));
			System.out.println("만 나이 : "+(2022-(1900+age)));
		}
		else if(gender =='3' || gender =='4' || gender=='7'|| gender=='8') {
			System.out.println("생년 월일 : 20"+birth);
			System.out.println("한국 나이 : "+(2022-(2000+age)+1));
			System.out.println("만 나이 : "+(2022-(2000+age)));
		}
				
		//올해생일
		System.out.println("올해 생일 : "+nowyear+"년 "+jumin.substring(2,4)+"월 "+jumin.substring(4,6)+"일");
		//다가올 생일
		//생일 D-day
	}
}