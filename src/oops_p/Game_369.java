//1~20까지 369게임 작성(단, 1의 자리가 369일때 짝 출력, switch등 조건항을 사용하지 않고)
package oops_p;

public class Game_369 {

	public static void main(String[] args) {
		for(int i=1; i<=20; i++) { //1~20
			int one = i%10;
			int three = one%3;

			try {
				int a = 1234/three;
				System.out.println(i);
			} catch (Exception e) {
				try {
					int a = 1234/one;
					System.out.println("짝");
				} catch (Exception e2) {
					System.out.println(i);
				}
				
			}
		}
	}//main

}//class