package io_p;

import java.io.FileInputStream;
import java.util.Arrays;

class FileMember2{
	String id;
	int age;
	boolean marriage;
	
	public FileMember2(String str) {
		String [] arr = str.split(",");

		System.out.println("\n생성자 : "+Arrays.toString(arr));
//		System.out.println("->"+arr[0]);
		
//		for(int i = 0; i<arr.length; i++) {
//			String [] p1 = arr[i].split(",");
//		}
//		//bbb,29,true
//		String [] p2 = arr[1].split(","); //qwe,65,true
//		String [] p3 = arr[2].split(","); //zxcv,43,false
//		String [] p4 = arr[3].split(","); //tyu,17,false

//		for(int i =0; i < 3; i++) {
//			id = p1[i];
//			age = Integer.parseInt(p1[1]);
//			marriage = Boolean.parseBoolean(p1[2]);
//		}
		id = arr[0];
		age = Integer.parseInt(arr[1]);
		marriage = Boolean.parseBoolean(arr[2]);
		
	}

	@Override
	public String toString() {
		return "FileMember [id = "+id+", age = "+age+", marraige = "+marriage+"]";
		
	}
}
public class FileMember2Main {

	public static void main(String[] args) {

		String tt = "";
		try {
			FileInputStream file = new FileInputStream("fff/qqq2.txt");
			
			int data;
			
			while((data=file.read())!=-1) {
//				System.out.print((char)data);
				tt += (char)data;
				
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("-->"+tt);
		for(int i = 0; i<tt.length(); i++) {
			String [] t1 =tt.split("\r\n");
			FileMember2 fm2 = new FileMember2(t1[i]);
			System.out.println(fm2);
		}

	}

}
