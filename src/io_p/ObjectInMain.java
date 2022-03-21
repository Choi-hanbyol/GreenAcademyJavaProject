package io_p;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ObjectInMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fff/obj.qaz");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		System.out.println(ois.readBoolean());
		System.out.println(ois.readByte());
		System.out.println(ois.readShort());
		System.out.println(ois.readInt());
		System.out.println(ois.readLong());
		System.out.println(ois.readFloat());
		System.out.println(ois.readDouble());
		System.out.println(ois.readUTF());
		System.out.println(Arrays.toString((String [])ois.readObject()));
		System.out.println(ois.readObject());
		System.out.println(ois.readObject());
		
		
		ois.close();
		fis.close();
	}

}
