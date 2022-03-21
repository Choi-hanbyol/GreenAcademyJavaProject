package io_p;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import io_obj.ObjEx;

public class ObjectInDataMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fff/ooData.zzz");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		while(fis.available()>0) {
			ObjectData od = (ObjectData)ois.readObject();
//			System.out.println(od);
			
			ObjEx oe = (ObjEx)Class.forName("io_obj."+od.tag).newInstance();
			oe.execute(od.data);
		}
		ois.close();
		fis.close();
	}

}
