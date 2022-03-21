package io_p;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class AAA implements Serializable {
	String name;
	int age;
	boolean marriage;
	
	public AAA(String name, int age, boolean marriage) {
		super();
		this.name = name;
		this.age = age;
		this.marriage = marriage;
	}
	
	@Override
	public String toString() {
		return "AAA [name=" + name + ", age=" + age + ", marriage=" + marriage + "]";
	}
}

public class ObjectOutMain {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("fff/obj.qaz");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeBoolean(true);
		oos.writeByte(123);
		oos.writeShort(321456);
		oos.writeInt(12365478);
		oos.writeLong(741258963789L);
		oos.writeFloat(123.456F);
		oos.writeDouble(789.456);
		oos.writeUTF("아기상어");
		
		String [] arr = {"송지은","오세진","전문기","유승호"};
		oos.writeObject(arr);
		ArrayList<Integer>arr2 = new ArrayList<Integer>();
		arr2.add(123);
		arr2.add(456);
		arr2.add(987456);
		oos.writeObject(arr2);
		
		oos.writeObject(new AAA("백종현", 28, false));
		
		oos.close();
		fos.close();
		
	}

}
