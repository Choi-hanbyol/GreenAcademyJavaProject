package io_p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SignUpOutputMain {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("===================회원가입정보입력===================");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("학년 입력 : ");
		int grade = sc.nextInt();
		
		System.out.print("전번 입력 : ");
		int phone = sc.nextInt();
		
		System.out.print("군필여부 입력 : ");
		String chk = sc.next();
		
//		System.out.println(id+","+name+","+grade+","+phone+","+chk);
		
		FileOutputStream fos = new FileOutputStream("fff/eee.abc");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF(id);
		dos.writeUTF(name);
		dos.writeInt(grade);
		dos.writeInt(phone);
		dos.writeUTF(chk);
		

		dos.close();
		fos.close();
		
	}

}
