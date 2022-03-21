package io_p;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DataMemInMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fff/vfr.tgb");
		DataInputStream dis = new DataInputStream(fis);
		
		while(dis.available()>0) {
			String str = dis.readUTF();
			
//			System.out.println(str);
			int pos = str.indexOf("_");
			
			String tag = str.substring(0,pos);
			String data = str.substring(pos+1);
			
//			System.out.println(tag+"=>"+data);
			switch(tag) {
			case "n" :
				double dd = Double.parseDouble(data);
				System.out.println(dd);
				break;
			case "b" :
				Boolean bo = Boolean.parseBoolean(data);
				System.out.println(bo);
				break;
			case "msg" :
				System.out.println(data);
				break;
			case "arr" :
				ArrayList<Integer> list = new ArrayList();
				for(String s : data.split(",")) {
					list.add(Integer.parseInt(s));
				}
				System.out.println(list);
				break;
			}
		
		}
		
		
		
		dis.close();
		fis.close();
	}

}
