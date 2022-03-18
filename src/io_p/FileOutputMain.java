package io_p;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputMain {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("fff/ccc.txt");
			
			fos.write('a');
			
			String ttt = "\nqwertyu\n1234567890\n!@#$%^&*()_+";
			
			for(char ch : ttt.toCharArray()) {
				fos.write(ch);
			}
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//23,4,56,7,88,21,32,54,65,90,12,33,46
		//짝수들과 홀수들의 합, 평균을 ccc2.txt에 저장하시오
	}

}
