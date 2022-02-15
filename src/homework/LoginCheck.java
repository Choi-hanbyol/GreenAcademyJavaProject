/*
회원 가입 유효성 검사를 실시하세요
1. 아이디 : 영문 숫자 조합
2. 비번 , 비번확인 
3. 전화번호 - 숫자 : ###-####-####, ##(#)-###-####
4. 이름 (한글만 가능) 
5. 사진 첨부-->영문,숫자.이미지 확장자
이미지(jpg, jpeg, bmp, png, gif) -- 대소문자 구분없음
6. 우편번호 검색 - 구단위 (초성검색)
ㄱㅈ,광ㅈ,ㄱ진,광진,진,ㅈ,ㄱ,광
예외처리로 처리할 것 
*/
package homework;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginCheck {

	public static void main(String[] args) {
		String Id, Pw, PwCheck, PhoneNum, Name, Image, PostNum;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) { //ID 확인 (영문+숫자)
			try {
				System.out.print("가입할 아이디 입력 : ");
				Id = sc.next();
			
				if(!Pattern.matches("[a-zA-Z0-9].*", Id)) {
					throw new Exception("ID 타입이 옳지 않습니다! 다시 입력하세요!");
				}
				
				System.out.println("ID 생성!");
				System.out.println();
				break;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
		
		while(true) { //비밀번호 확인(두번다 같은 비번 입력)
			try {
				System.out.print("가입할 비밀번호 입력 : ");
				Pw = sc.next();
				System.out.print("입력한 비밀번호 확인 : ");
				PwCheck = sc.next();
				
				if(!Pw.equals(PwCheck)) {
					throw new Exception("비밀번호가 일치하지 않습니다! 다시 입력하세요!");
				}
				System.out.println("PW 생성!");
				System.out.println();
				break;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
		
		while(true) {//전화번호 확인(010-1234-1234 or 02-123-1234)
			try {
				System.out.print("전화번호 입력 : ");
				PhoneNum = sc.next();
				
				if(!(Pattern.matches("[0-9]{3}-[0-9]{4}-[0-9]{4}", PhoneNum)||Pattern.matches("[0-9]{2}-[0-9]{3}-[0-9]{4}",  PhoneNum))) {
					throw new Exception("전화번호 형식이 올바르지 않습니다! 다시 입력하세요!");
				}
				System.out.println("전화번호 입력완료!");
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
		
		while(true) { //이름확인 (한글이름)
			try {
				System.out.print("성함 : ");
				Name=sc.next();
				
				if(Pattern.matches("[a-zA-Z]*", Name)) {
					throw new Exception("한글 이름만 입력가능!!");
				}
				System.out.println("성함 입력완료!");
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
		
		while(true) { //첨부사진 확인(jpg, jpeg, bmp, png, gif -- 대소문자 구분없음)
			try {
				System.out.print("업로드할 프로필 사진 첨부 : ");
				Image = sc.next();
				String [] file = Image.split("\\.");
				String fileName = file[0];
				String fileType = file[1];
				
				if(!Pattern.matches("[a-zA-Z0-9]*", fileName)) {
					throw new Exception("파일 이름은 영어+숫자만 가능합니다. 다시 첨부해주세요!");
				}
				else if(!Pattern.matches("(jpg|JPG|jpeg|JPEG|bmp|BMP|png|PNG|gif|GIF)", fileType)) {
					throw new Exception("확장자 형식이 옳지 않습니다! 다시 첨부해주세요!");
				}
				System.out.println("프로필사진 설정완료!");
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
		System.out.println("=====회원가입 완료=====");
		System.out.println("ID : "+Id);
		System.out.println("PW : "+Pw);
		System.out.println("전화번호 : "+PhoneNum);
		System.out.println("이름 : "+Name);
		System.out.println("프로필사진 : "+Image);
		
	}
}