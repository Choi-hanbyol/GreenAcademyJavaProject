package io_p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputMain {

	public static void main(String[] args) {
		
		
		try {
			//1. stream 생성
			FileInputStream fis = new FileInputStream("fff/asdf.txt");
			
			int data;
			
			while((data=fis.read())!= -1){
				char ch = (char)data;
				System.out.print(ch);
			}
			
			//3. stream 닫기
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}