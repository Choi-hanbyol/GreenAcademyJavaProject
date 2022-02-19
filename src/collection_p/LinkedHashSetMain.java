package collection_p;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


class MyCom implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		//o1 : add 할때 대입되는 매개변수
		//o2 : set에 이미 있는 원소
		System.out.println("com:"+o1+","+o2);
		//0 - 생략
		//양수(1) - 뒤에 위치
		//음수(-1) - 앞에 위치
		return -10;
	}
	
}

class TreeMem{
	String name;
	int age, height;
	public TreeMem(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	@Override
	public String toString() {
		return name + ":" + age + "(" + height+")";
	}
	
	
}


class TreeMemCom implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		TreeMem me = (TreeMem)o1;
		TreeMem you = (TreeMem)o2;
		
		int res = me.age-you.age;
		
		if(res==0) {
			res = you.height-me.height;
		}
		if(res==0) {
			//res = 1;
			res = me.name.compareTo(you.name);
		}
		System.out.println(res);
		return res;
	}
	
	
}


public class LinkedHashSetMain {

	public static void main(String[] args) {
		Set s1 = new HashSet();
		Set s2 = new LinkedHashSet();
		
		
		for (Object object : new Object[] {11,45,67,22,"아기상어",78,23,11,67,"아기상어",45,33}) {
			s1.add(object);
			s2.add(object);
			//s3.add(object);
		}
		
		System.out.println("s1:"+s1);
		System.out.println("s2:"+s2);
		
		
		Set s3 = new TreeSet();
		Set s4 = new TreeSet( new MyCom() );
		for (int i : new int[] {34,21,56,34,11,9,82,34,56,13,21}) {
			
			s3.add(i);
			s4.add(i);  //compare 호출
			System.out.println("--------------------");
		}
		System.out.println("s3:"+s3);
		System.out.println("s4:"+s4);
		
		
		Set s5 = new TreeSet( new TreeMemCom() );
		s5.add(new TreeMem("한가인", 7, 165));
		s5.add(new TreeMem("두가인", 37, 175));
		s5.add(new TreeMem("삼가인", 27, 135));
		s5.add(new TreeMem("사가인", 47, 165));
		s5.add(new TreeMem("오가인", 47, 155));
		s5.add(new TreeMem("송가인", 47, 155));
		System.out.println("--------------------");
		for (Object obj : s5) {
			System.out.println(obj);
		}
		
		
		
		
	}

}

