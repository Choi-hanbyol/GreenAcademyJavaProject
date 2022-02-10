//참참참 게임을 만들자
package lang_p;

import java.util.Scanner;

public class CharmCharmCharm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] index = {"왼쪽", "오른쪽"};
		while(true ) {
			System.out.println("참참참 게임, 0:왼쪽, 1:오른쪽, 9:종료");
			System.out.println("입력 : ");
			int user = sc.nextInt();
			
			if(user==9) {
				break;
			}
			
			int com = (int)(Math.random()*2);
			
			String res = "패";
			if(user==com) {
				res="승";
			}
			System.out.println("게이머 : "+index[user]);
			System.out.println("컴퓨터 : "+index[com]);
			System.out.println("결과 : "+res);
		}
		System.out.println("게임종료");

	}
	
}
