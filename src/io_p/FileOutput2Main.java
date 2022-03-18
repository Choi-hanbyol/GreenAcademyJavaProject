package io_p;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileOutput2Main {

	public static void main(String[] args) {
		try {
			
			int [] arr = {23,4,56,7,88,21,32,54,65,90,12,33,46};
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			int tot=0;
			
			for (int i : arr) {
				if(i%2==0) {
					tot+=i;
					list.add(i);
				}
			}
			
			
			FileOutputStream fos = new FileOutputStream("fff/ccc2.txt");
			String ttt = list.toString()+"\n"+tot+","+tot/list.size();
			
			
			for (char ch : ttt.toCharArray()) {
				fos.write(ch);
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
