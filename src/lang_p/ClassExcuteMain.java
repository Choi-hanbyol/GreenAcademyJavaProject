package lang_p;

import java.util.Scanner;

interface CCBoard{
	void execute(String data);
}

class CCList implements CCBoard{
	@Override
	public void execute(String data) {
		System.out.println("게시판 리스트입니다. : "+data);
	}
}

class CCWrite implements CCBoard{
	@Override
	public void execute(String data) {
		System.out.println("게시판 글쓰기입니다. : "+data);
	}
}

class CCModify implements CCBoard{
	@Override
	public void execute(String data) {
		System.out.println("게시판 수정입니다. : "+data);
	}
}

class CCDelete implements CCBoard{
	@Override
	public void execute(String data) {
		System.out.println("게시판 삭제입니다. : "+data);
	}
}
public class ClassExcuteMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("명령어 입력 : ");
			String tt = sc.next();
			
			if(tt.equals("x")) {
				break;
			}
			
			try {
				CCBoard cb = (CCBoard)Class.forName("lang_p.CC"+tt).newInstance();
				
				cb.execute("최한별만세");
			} catch (Exception e) {
				System.out.println("잘못된 명령어 입니다.");
			}
		}
		System.out.println("프로그램 종료");
	}

}
