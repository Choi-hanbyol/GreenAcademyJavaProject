//100번대 이후로 입력받을떄 369게임
//333=짝짝짝, 363=짝짝짝, 666 = 짝짝짝....등
package util_p;

import java.util.Arrays;
import java.util.Scanner;

public class Game_369Ver3 {

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
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 숫자 입력 : ");
		int su = sc.nextInt();
		
		for(int i = 1; i <= su; i++) {
			
			char [] arr=(i+"").toCharArray();
			//System.out.println(Arrays.toString(arr));
			
			String ttt = "";
			for(char ch : arr) {
				//System.out.println(ch);
				ttt+=zzag(ch -'0');
			}
			 
			
			try {
				int a = 1234/ttt.length();
			} catch (Exception e) {
				ttt+=i;
			}
			System.out.println("<"+i+">\t"+ttt);
		}
	}

}
