package io_p;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterMain {

	public static void main(String[] args) throws Exception{
		FileWriter fw = new FileWriter("fff/ooo3.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("타노스\n");
		bw.write("울트론\n");
		bw.write("베놈\n");
		bw.write("도로마무\n");
		
		
		
		bw.close();
		fw.close();
	}

}
/*
 * 회원가입 과 로그인을 구현하세요
 *회원정보 -> ID, 암호, 이름
 *ID중복확인검사->할 수 있으면 해보기
*/
 