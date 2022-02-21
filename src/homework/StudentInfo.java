package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Student {
	String name, gender, gradeSu, check; // 이름, 성별, 수우미양가, 합격여부
	int classOfScholl; // 반
	boolean isSpecial; // 특기생 여부
	int kor, eng, math, art; // 국, 영, 수 ,예체능 점수
	int tot, avg; // 총점, 평균
	int grade; //등수

	
	public Student(String name, String gender,  int classOfSchool, int kor, int eng, int math) {
		isSpecial = false; //일반 학생
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.classOfScholl = classOfSchool;
		this.name = name;
		this.gender = gender;
		cal();
		this.gradecheck();
		this.checkGrade1();
	}
	
	public Student(String name, String gender,  int classOfSchool, int kor, int eng, int math, int art) {
		isSpecial = true; //예체능학생
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.art = art;
		this.classOfScholl = classOfSchool;
		this.name = name;
		this.gender = gender;
		cal();
		this.gradecheck();
		this.checkGrade2();
	}
	
	void cal() {
		tot = kor + eng + math + art;
		
		if(art == 0) { 
			avg = tot / 3;
		} else {
			avg = tot / 4;
		}
	}
	
	void gradecheck() { //수우미양가 결정
		if(avg>=90)this.gradeSu="수";
		else if(avg>=80)this.gradeSu = "우";
		else if(avg>=70)this.gradeSu = "미";
		else if(avg>=60)this.gradeSu = "양";
		else this.gradeSu = "가";
	}
	
	void checkGrade1() {//일반학생 합(불)여부
		if(avg>=70)this.check = "합격";
		else this.check = "불합격";
	}
	
	void checkGrade2() {//특기생 합(불)여부
		if(avg>=65)this.check = "합격";
		else this.check = "불합격";
	}
	
	@Override
	public String toString() {
		return (isSpecial ? "특기생" : "일반") + " " + classOfScholl + "반 " + name + " " + gender
				+ " 국어:" + kor + " 영어:" + eng + " 수학:" + math 
				+ (isSpecial ? (" 예체능:" + art) : "") + " 총점:" + tot + " 평균:" + avg;
	}
	
}

class Sort implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		if(s1.tot>s2.tot)return -1;
		if(s1.tot == s2.tot)return -1;
		else return 1;
	}
}

public class StudentInfo {
	
	static void type5(Student [] inputArr) {
		Set student1_P =new TreeSet(new Sort()); //일반 합격생
		Set student2_P =new TreeSet(new Sort()); //일반 불합격생
		Set student1_F =new TreeSet(new Sort()); //예체능 합격생
		Set student2_F =new TreeSet(new Sort()); //예체능 불합격생
		
		for(Student s : inputArr) {
			if(s.classOfScholl == 1) {
				if(s.check=="합격") {
					student1_P.add(s);
				}
				else {
					student1_F.add(s);
				}
			}
			else {
				if(s.check=="합격") {
					student2_P.add(s);
				}
				else {
					student2_F.add(s);
				}
			}
		}
		
		//<<<합격 / 불합격 출력하는 곳>>>
		System.out.println("합격자\n");
		System.out.println("1반 학생");		
		
		for(int i = 1; i<=student1_P.size();i++) {
			System.out.println(i+"등 "+ student1_P.toString().split(",")[i-1]);
		}
		
		System.out.println("\n2반 학생");		
		for(int i = 1; i<=student2_P.size();i++) {
			System.out.println(i+"등 "+ student2_P.toString().split(",")[i-1]);
		}
		
		System.out.println("\n불합격자\n");
		System.out.println("1반 학생");		
		
		for(int i = 1; i<=student1_F.size();i++) {
			System.out.println(student1_P.size() + 1 +"등 "+ student1_F.toString().split(",")[i-1]);
		}
		
		System.out.println("\n2반 학생");		
		for(int i = 1; i<=student2_F.size();i++) {
			System.out.println(student2_P.size()+i +"등 "+ student2_F.toString().split(",")[i-1]);
		}
	}

	public static void main(String[] args) {
		Student s1 = new Student("김덕배", "남", 1, 50, 50, 73);
		Student s2 = new Student("김성실", "남", 1, 70, 67, 82);
		Student s3 = new Student("김국장", "남", 2, 90, 85, 72);
		Student s4 = new Student("최철수", "남", 2, 65, 62, 73);
		Student s5 = new Student("박다정", "여", 2, 50, 67, 85);
		
		Student y1 = new Student("짱구", "남", 1, 60, 43, 35, 87);
		Student y2 = new Student("철수" ,"남", 1, 95, 97, 86, 80);
		Student y3 = new Student("유리" ,"여", 2, 70, 65, 76, 73);
		Student y4 = new Student("맹구" ,"남", 2, 30, 43, 61, 63);
		Student y5 = new Student("짱아" ,"여", 2, 15, 5, 13, 2);
				

		Student[] arr = new Student[] {s1,s2,s3,s4,s5,y1,y2,y3,y4,y5};

		
		type5(arr);
		
	}

}
