package util_p;

import java.util.Scanner;
import java.util.regex.Pattern;

class RegexMem{
	class Data{
		String title, data;
		
		public Data(String title) {
			this.title = title;
		}

		@Override
		public String toString() {
			return title + " : " + data;
		}	
	}
	
	Data [] data;
	
	public RegexMem() {
		String [] arr = "id,pw,tel,pname,img,addr,schGu".split(",");
		data = new Data[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			data[i] = new Data(arr[i]);
		}
	}
	
	void ppp() {
		
		for (Data dd : data) {
			System.out.println(dd);
		}
	}
	
	void input(RRQQ rq) {
		for (Data dd : data) {
			if(dd.title.equals(rq.title)) {
				dd.data = rq.answer;
			}
		}
	}
}

class RRQQ{
	String qq, title, regex, answer;

	public RRQQ(String qq, String title, String regex) {
		super();
		this.qq = qq;
		this.title = title;
		this.regex = regex;
		
	}
	
	void question(RegexMem rm) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print(qq+":");
		answer = sc.next();
		
		if(!Pattern.matches(regex, answer.toLowerCase())) {
			throw new Exception(qq+" 입력에러");
		}
		rm.input(this);
	}
}

class RegZipCode{
	
	String gu, zipcode;

	public RegZipCode(String str) {
		String [] arr = str.split("_");
		this.gu = arr[0];
		this.zipcode = arr[1];
	}

	@Override
	public String toString() {
		return gu + "=>" + zipcode;
	}
	
	
	
}





public class RegexRegisterMain {

	public static void main(String[] args) {
		
		/*회원 가입 유효성 검사를 실시하세요
		1.  : 영문 숫자 조합 
		2.  ,  [a-zA-Z0-9]*
		3.  - 숫자 : ###-####-####, ##(#)-###-####  [0-9]{2,3}-[0-9]{3,4}-[0-9]{4}
		4.  (한글만 가능) [가-힣]*
		5.  첨부-->영문,숫자.이미지 확장자 [a-zA-Z0-9_]*.[a-z]
		이미지(jpg, jpeg, bmp, png, gif) -- 대소문자 구분없음
		6.  검색 - 구단위 (초성검색) 
		ㄱㅈ,광ㅈ,ㄱ진,광진,진,ㅈ,ㄱ,광
		예외처리로 처리할 것 
		*/
		
		String [] rgc = {
				"ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅆㄲㄸㅉㅃ",
				"가나다라마바사아자차카타파하싸까따짜빠",
				"깋닣딯맇밓빟싷잏짛칳킿팋핗힣앃낗띻찧삫"
		};
		
		String [] gu = "종로구_00111,중구_00222,용산구_00223,성동구_00224,광진구_00225,동대문구_00226,중랑구_00227,성북구_00228,강북구_00229,도봉구_00230,노원구_00231,은평구_00232,서대문구_00233,마포구_00234,양천구_00235,강서구_00236,구로구_00237,금천구_00238,영등포구_00239,동작구_00240,관악구_00241,서초구_00242,강남구_00243,송파구_00244,강동구_00245".split(","); 
		
		RegZipCode [] zipArr = new RegZipCode[gu.length];
		
		for (int i = 0; i < zipArr.length; i++) {
			zipArr[i] = new RegZipCode(gu[i]);
		}
		
		
		RRQQ [] arr = {
//			new RRQQ("아이디","id","[a-zA-Z0-9]{3,}"),
//			new RRQQ("비번","pw",".{4,}"),
//			new RRQQ("비번확인","",".{4,}"),
//			new RRQQ("전화번호","tel","([0-9]{3}-[0-9]{4}|[0-9]{2,3}-[0-9]{3})-[0-9]{4}"),
//			new RRQQ("이름","pname","[가-힣]{2,}"),
//			new RRQQ("사진","img",".{1,}[.](jpg|jpeg|bmp|png|gif)"),
			new RRQQ("우편번호","addr","[ㄱ-ㅎ가-힣]*")
		};
		
		RegexMem rm = null;
		
		while(true) {
			rm =new RegexMem();
			try {
				
				for (RRQQ rq : arr) {
					rq.question(rm);
					
					if(rq.qq.equals("비번확인") && !rq.answer.equals(rm.data[1].data)) {
						throw new Exception("비밀번호 불일치");
					}
				}
				
				String pp = ".*";
				
				for (char ch : rm.data[5].data.toCharArray()) {
					
					int pos = rgc[0].indexOf(ch);
					if(pos>=0) {
						pp+="["+rgc[1].charAt(pos)+"-"+rgc[2].charAt(pos)+"]";
					}else {
						pp+=ch;
					}
				}
				
				pp+=".*";
				
				//System.out.println(pp);
				String schGu = "";
				
				for (RegZipCode zipcode: zipArr) {
					if(Pattern.matches(pp, zipcode.gu)) {
						schGu+=zipcode+",";
					}
				}
				
				//System.out.println(schGu);
				if(schGu.length()==0) {
					throw new Exception("일치하는 구가 없습니다.");
				}
				
				rm.data[6].data = schGu;
				
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("회원가입 완료");
		rm.ppp();
	}

}