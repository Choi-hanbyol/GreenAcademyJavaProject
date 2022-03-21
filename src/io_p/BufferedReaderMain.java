package io_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BufferedReaderMain {

	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("fff/ooo2.txt");
		BufferedReader br = new BufferedReader(fr);
		
//		System.out.println(br.readLine());
		String str;
		ArrayList info = new ArrayList();
		while((str=br.readLine()) != null) {
			System.out.println("=>"+str);
			info.add(str);
		}
		System.out.println(info);

		br.close();
		fr.close();
	}

}
