package io_p;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileCopy2Main {

	public static void main(String[] args) throws Exception {
		
		for(int i = 1; i<=5; i++) {
			FileInputStream fis = new FileInputStream("pic1/D"+i+".png");
			FileOutputStream fos = new FileOutputStream("dst/DDD"+i+".jpg");
			
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

}