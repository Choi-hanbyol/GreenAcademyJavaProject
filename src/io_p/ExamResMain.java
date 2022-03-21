/*
이름, 국/영/수 점수를 결과 파일에 저장
이름, 국/영/수는 Scanner로 입력
처리내용 충점, 평균, 등급
결과 파일에서 내용을 가져와 출력
*/
package io_p;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ExamResMain {

	public static void main(String[] args) throws Exception{
		
		String name;
		int kor=0, eng=0, math=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====시험결과 입력=====");
		
		System.out.print("학생 이름 입력 : ");
		name = sc.next();
		
		System.out.print("국어 점수 입력 : ");
		kor = sc.nextInt();
		
		System.out.print("영어 점수 입력 : ");
		eng = sc.nextInt();
		
		System.out.print("수학 점수 입력 : ");
		math = sc.nextInt();
		
		FileOutputStream fos = new FileOutputStream("fff/examRes.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeUTF(name);
		oos.writeInt(kor);
		oos.writeInt(eng);
		oos.writeInt(math);
		
		oos.close();
		fos.close();
		
		//int kor=0, eng=0, math=0;
		
		
		FileInputStream fis = new FileInputStream("fff/examRes.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		String studentname = ois.readUTF();
		kor = ois.readInt();
		eng = ois.readInt();
		math = ois.readInt();
		int tot = kor+eng+math;
		int avg = tot/3;
		String grade;
		if(avg>=90) {
			grade="A";
			}
		else if(avg<90&&avg>=80) {
			grade="B";
		}
		else if(avg<80&&avg>=70) {
			grade="C";
		}
		else {
			grade="F";
		}
		System.out.println(studentname+"의 국어점수 : "+kor+ "점, 영어점수 : "+eng+"점, 수학점수 : "+math+"점 입니다.");
		
		System.out.println("총점 : "+tot+" / 평균 : "+avg);
		
		System.out.println("등급은 : "+grade+"입니다.");
		ois.close();
		fis.close();
		
		
		
	}

}