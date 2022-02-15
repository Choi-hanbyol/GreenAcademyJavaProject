/*
아래에 조건에 해당하는 게임을 작성
1~> 100
30,60,90단위에서 30:짝  33:짝짝
*/
package homework;

public class GameOfJaak {

	public static void main(String[] args) {
		
		for(int i=1; i<=100; i++) { //1~100
			int ten = i/10;
			int ten_three = ten%3;
			
			String ttt = "";
			
			try {
				int a = 1234/ten_three;
			} catch (Exception e) {
				try {
					int b = 1234/ten;
					//System.out.println("십의 자리 짝");
					ttt+="짝";
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
			
			
			int one = i%10;
			int one_three=one%3;
			
			try {
				int a = 1234/one_three;
			} catch (Exception e) {
				try {
					int b = 1234/one;
					//System.out.println("십의 자리 짝");
					ttt+="짝";
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
			
			try {
				int a = 1234/ttt.length();
			} catch (Exception e) {
				ttt+=i;
				//System.out.println(i);
			}
			
			System.out.println("<"+i+">\t"+ttt);
			
			
		}
	}
}