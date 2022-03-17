package io_p;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputMain {
	
	public static void main(String[] args) {
		
		try {
			//1. 매체확인
			byte [] arr = {10,20,126,127,-128,-127,-2,-1,0,45,67};
			
			//2. stream 생성및 매체 연결
			//매체에서 읽기 stream
			ByteArrayInputStream bis = new ByteArrayInputStream(arr);
			
//			for(int i =0;)
			//3. 연산-읽기
			//read() : Int					출력값	arr
//			System.out.println(bis.read());//10		10
//			System.out.println(bis.read());//20		20
//			System.out.println(bis.read());//126	126
//			System.out.println(bis.read());//127	127
//			System.out.println(bis.read());//128	-128 -> 음수값을 절대값 int로 변환
//			System.out.println(bis.read());//129	-127 -> 음수값을 절대값 int로 변환
//			System.out.println(bis.read());//254	-2 -> 음수값을 절대값 int로 변환
//			System.out.println(bis.read());//255	-1 -> 음수값을 절대값 int로 변환
//			System.out.println(bis.read());//0		0
//			System.out.println(bis.read());//45		45
//			System.out.println(bis.read());//67		67
//			
//			
//			System.out.println(bis.read());//-1 -> 데이터가 없다.
//			System.out.println(bis.read());//-1
//			System.out.println(bis.read());//-1
//			System.out.println(bis.read());//-1
			
			int data = -100;
			
			while((data=bis.read())!=-1) { // 대입받은 값이 -1이 아니라면 계속 실행
				System.out.println(data+"=>"+(byte)data);
			}
			
			
			//4. stream 닫기
			bis.close();
			
			System.out.println("-----------------------------------");
			
			short a = 127;
			byte b = (byte)a;
			System.out.println(a+","+b);
			
			a = 128;
			b = (byte)a;
			System.out.println(a+","+b);
			
			a = 129;
			b = (byte)a;
			System.out.println(a+","+b);
			
			a = 131;
			b = (byte)a;
			System.out.println(a+","+b);
			
			a = 254;
			b = (byte)a;
			System.out.println(a+","+b);
			
			a = 255;
			b = (byte)a;
			System.out.println(a+","+b);
			
			a = 256;
			b = (byte)a;
			System.out.println(a+","+b);
			
			a = 257;
			b = (byte)a;
			System.out.println(a+","+b);
			
			/*				short						byte
			127,127			0 000 0000 0111 1111		0 111 1111
			128,-128		0 000 0000 1000 0000		1 000 0000
			129,-127		0 000 0000 1000 0001		1 000 0001
			130,-126		0 000 0000 1000 0010		1 000 0001
			131,-125		0 000 0000 1000 0011		1 000 0011
			254,-2			0 000 0000 1111 1110		1 111 1110
			255,-1			0 000 0000 1111 1111		1 111 1111
			256,0			0 000 0001 0000 0000		0 000 0000
			257,1			0 000 0001 0000 0001		0 000 0001
			*/
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}