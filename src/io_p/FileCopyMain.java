package io_p;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileCopyMain {

	public static void main(String[] args) throws IOException {
		
		String ff = "fff/D1.png";
		//210,530  bytes  --> 210,944  bytes
		FileInputStream fis = new FileInputStream(ff);
		FileOutputStream fos = new FileOutputStream("dst/child_4.jpg");
		
		byte [] buf = new byte[1024];
		
		int no = 0;
		while(fis.available()>0) {
			
			int cnt = fis.read(buf);
			fos.write(buf,0,cnt);
			
			no++;
			//System.out.println(no+":"+cnt+Arrays.toString(buf));
		}
		
		
		fos.close();
		fis.close();
		
		///파일 복사시에는 2byte스트림을 쓰면 안됨
		////--------------------------------------------------------
		
		FileReader fr = new FileReader(ff);
		FileWriter fw = new FileWriter("dst/child_44.jpg");
		
		int data;
		while((data = fr.read())!=-1) {
			
			fw.write(data);
			
		}
		
		fw.close();
		fr.close();
		
		
		

	}

}
