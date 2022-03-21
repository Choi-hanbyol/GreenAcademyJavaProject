package io_p;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fff/ooo2.txt");
		
		while(fis.available()>0) {
			System.out.print((char)fis.read());
		}
		
		fis.close();
		
		System.out.println("\n==================================================\n");
		
		
		FileReader fr = new FileReader("fff/ooo2.txt");
		
		int data;
		while((data=fr.read())!=-1) {
			System.out.print((char)data);
		}
		
		fr.close();
	}

}