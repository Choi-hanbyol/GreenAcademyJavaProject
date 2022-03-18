package io_p;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileCopyMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("pic1/MBTI2.png");
		FileOutputStream fos = new FileOutputStream("dst/MBTI.jpg");

		byte [] buf = new byte[1024];
		int no  = 0;
		while(fis.available()>0) {
			int cnt = fis.read(buf);
			fos.write(buf,0,cnt);
			
			no++;
			System.out.println(no+":"+cnt+Arrays.toString(buf));
		}
		
		fos.close();
		fis.close();
	}

}