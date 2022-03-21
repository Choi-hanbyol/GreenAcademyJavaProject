package io_p;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SignUpInputMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fff/eee.abc");
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println(dis.readUTF());
		System.out.println(dis.readUTF());		
		System.out.println(dis.readInt());
		System.out.println(dis.readInt());
		System.out.println(dis.readUTF());
		
		dis.close();
		fis.close();
	}

}