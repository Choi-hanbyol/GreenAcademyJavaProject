package io_p;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjExamInMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fff/objExam.qwe");
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println(ois.readObject());
		ois.close();
		fis.close();
	}

}
