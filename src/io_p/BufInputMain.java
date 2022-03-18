package io_p;

import java.io.ByteArrayInputStream;

import java.util.Arrays;

public class BufInputMain {

	public static void main(String[] args) throws Exception{
		byte [] arr  = {10,127,-128,-126,-2,-1,0,40,50,60,11,22,33};
		byte [] buf = new byte[5];
		int cnt;
		System.out.println(Arrays.toString(buf));
		
		ByteArrayInputStream bis = new ByteArrayInputStream(arr);
		
		cnt = bis.read(buf,1,3);
		//			  (대입할 배열 변수, 버프의 시작위치, 가져올갯수)
		System.out.println("available : "+bis.available()); //13
		System.out.println(Arrays.toString(buf));
		System.out.println(cnt);
		/*
		System.out.println("available : "+bis.available());
//		bis.read();
//		bis.read();
//		System.out.println(bis.available());
		
		int cnt = bis.read(buf);
		//cnt : 읽은 갯수
		//buf : 데이터를 받아 대입한 임시 저장 공간
		
		
		//스트림에 남아있는 데이터 갯수
		System.out.println("available : "+bis.available());
		System.out.println(Arrays.toString(buf));
		System.out.println(cnt);
		
		
		cnt = bis.read(buf);
		System.out.println("available : "+bis.available());
		System.out.println(Arrays.toString(buf));
		System.out.println(cnt);
		
		
		cnt = bis.read(buf);
		System.out.println("available : "+bis.available());
		System.out.println(Arrays.toString(buf));
		System.out.println(cnt);
		*/
		
		bis.close();
		
	}

}
