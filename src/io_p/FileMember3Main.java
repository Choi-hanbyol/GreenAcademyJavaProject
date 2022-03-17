package io_p;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

class FileMember3{
	String id;
	int age;
	boolean marriage;
	
	public FileMember3(String str) {
		String [] arr = str.split(",");
		id = arr[0];
		age = Integer.parseInt(arr[1]);
		marriage = Boolean.parseBoolean(arr[2]);
	}
	
	@Override
	public String toString() {
		return "FileMember2 [id=" + id + ", age=" + age + ", marriage=" + marriage + "]";
	}
}

public class FileMember3Main {

	public static void main(String[] args) {
		ArrayList<FileMember3> mems = new ArrayList<FileMember3>();
		
		
		for (String fName : "qqq2.txt,qqq4.txt,qqq8.txt,qqq9.txt".split(",")) {
			String ttt = "";
			try {
				FileInputStream fis = new FileInputStream("pic/"+fName);
				
				int data;
				while((data=fis.read())!=-1) {
					ttt += (char)data;
				}
				
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String [] arr = ttt.split("\r\n");
			
			for (String t : arr) {
				//System.out.println(t);
				mems.add(new FileMember3(t));
			}

		}
		
				
		for (FileMember3 mm : mems) {
			System.out.println(mm);
		}

	}

}
