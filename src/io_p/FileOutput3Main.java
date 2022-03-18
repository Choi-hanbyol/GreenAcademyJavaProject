//23,4,56,7,88,21,32,54,65,90,12,33,46
//짝수들의 합, 평균을 ccc2.txt 에 저장하세요
package io_p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class FileOutput3Main {

	public static void main(String[] args) {
		int jaktot = 0;
		int jakavg = 0;;
		int cnt = 0;
		
		try {
			
			int [] number = {23,4,56,7,88,21,32,54,65,90,12,33,46};
			
			for(int i = 0; i < number.length; i++) {
				if(number[i]%2==0) {
					jaktot+=number[i];
					cnt++;
					
				}
			}
			jakavg=jaktot/cnt;
			System.out.println("짝수 합 : " +jaktot);
			System.out.println("짝수 평균 :" +jakavg);
		
			
			FileOutputStream fos2 = new FileOutputStream("fff/ccc3.txt");
			String ttt = jaktot+","+jakavg;
			//파일에 정보쓰기
			//int->String->char

			String n1 = jaktot+"";
			String n2 = jakavg+"";
			
			for(char ch1 : ttt.toCharArray()) {
				fos2.write(ch1);
			}
//			for(char ch2 : n2.toCharArray()) {
//				fos2.write(ch2);
//			}

			fos2.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
