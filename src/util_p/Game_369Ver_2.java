//함수를 사용하여 조금 간단하게 풀이
package util_p;

public class Game_369Ver_2 {

	static String zzag(int no) {
		int three=no%3;
		String res = "";
		
		try {
			int a = 1234/three;
		} catch (Exception e) {
			try {
				int b = 1234/no;
				//System.out.println("십의 자리 짝");
				res="짝";
			} catch (Exception e2) {
				
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		for(int i = 1; i<=100; i++) {
			String ttt = zzag(i/10)+zzag(i%10);
			
			try {
				int a = 1234/ttt.length();
			} catch (Exception e) {
				ttt+=i;
			}
			System.out.println("<"+i+">\t"+ttt);
		}
	}

}
