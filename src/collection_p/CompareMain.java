package collection_p;

import java.util.Comparator;
import java.util.TreeSet;

class CPData1{
	int age;
	String name;
	double height;
	public CPData1(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	@Override
	public String toString() {
		return "CPData1 [" + name + ", " + age + ", " + height + "]";
	}

}

class CPData2 implements Comparable{
	int age;
	String name;
	double height;
	public CPData2(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	@Override
	public String toString() {
		return "CPData2 [" + name + ", " + age + ", " + height + "]";
	}
	@Override
	public int compareTo(Object o) {
		return 1;
	}

}

public class CompareMain {

	public static void main(String[] args) {
		TreeSet ts1 = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				CPData1 me = (CPData1)o1;
				CPData1 you = (CPData1)o2;
				
				int res = me.age - you.age;
				if(res==0) {
					res = me.name.compareTo(you.name);
				}
				return res;
			}
			
		});
		ts1.add(new CPData1("정우성", 57, 185.6));
		ts1.add(new CPData1("정좌성", 47, 175.6));
		ts1.add(new CPData1("정남성", 57, 195.6));
		ts1.add(new CPData1("정중성", 37, 145.6));
		ts1.add(new CPData1("정북성", 47, 155.6));

		for (Object object : ts1) {
			System.out.println(object);
		}
		System.out.println("=========================");
		
		TreeSet ts2 = new TreeSet();
		ts2.add(new CPData2("정우성", 57, 185.6));
		ts2.add(new CPData2("정좌성", 47, 175.6));
		ts2.add(new CPData2("정남성", 57, 195.6));
		ts2.add(new CPData2("정중성", 37, 145.6));
		ts2.add(new CPData2("정북성", 47, 155.6));
		
		for (Object object : ts2) {
			System.out.println(object);
		}

	}

}
