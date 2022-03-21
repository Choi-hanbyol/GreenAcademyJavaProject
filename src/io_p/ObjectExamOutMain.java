package io_p;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

///이름, 국, 영, 수 시험 결과를 파일에 저장하시오
	/// 이름, 국, 영, 수는 scanner 로 입력 받아 처리
	/// 처리 내용 총점, 평균, 등급
	/// 결과 파일에서 내용을 가져와 출력하시오

class ObjExam implements Serializable{
	private static final long serialVersionUID = 1267L;
	
	String name, grade;
	int [] jum = new int[3];
	int tot, avg;
	
	void calc() {
		tot = 0;
		for (int i : jum) {
			tot += i;
		}
		avg = tot/jum.length;
		grade = "가가가가가가양미우수수".charAt(avg/10)+"";
	}

	@Override
	public String toString() {
		calc();
		return "ObjExam [이름 = " + name + ", 국,영,수 =" + Arrays.toString(jum) + ", 총점 = " + tot
				+ ", 평균 = " + avg + ", 등급 = "+ grade + "]";
	}
	
	
}
public class ObjectExamOutMain {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		ObjExam oe = new ObjExam();
		
		System.out.print("이름 : ");
		oe.name = sc.next();
		System.out.print("국어 : ");
		oe.jum[0] = sc.nextInt();
		System.out.print("영어 : ");
		oe.jum[1] = sc.nextInt();
		System.out.print("수학 : ");
		oe.jum[2] = sc.nextInt();
		
		//System.out.println(oe);
		FileOutputStream fos = new FileOutputStream("fff/objExam.qwe");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(oe);
		oos.close();
		fos.close();
	}

}
