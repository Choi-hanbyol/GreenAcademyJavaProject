package collection_p;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListMain {

	public static void main(String[] args) {
		
		List arr1 = new ArrayList();
		
		arr1.add(10);
		arr1.add(20);
		arr1.add("아기상어");
		arr1.add(123.456);
		arr1.add(true);
		arr1.add(new int [] {11,22,33});
		arr1.add(null);
		arr1.add(10);
		arr1.add(30);
		arr1.add(40);
		arr1.add(20);
		arr1.add(10);
		arr1.add(20);
		arr1.add(70);
		
		System.out.println(arr1);
		System.out.println(arr1.size());
		System.out.println(arr1.get(2));
		System.out.println("set() 명령어");
		System.out.println("arr1.set(4, \"엄마상어\")");
		arr1.set(4, "엄마상어");
		System.out.println(arr1);
		
		System.out.println("============================");
		System.out.println("add() 명령어");
		System.out.println("arr1.add(3, \"장수풍뎅이\")");
		arr1.add(3,"장수풍뎅이");
		System.out.println(arr1);
		
		System.out.println("<<<<<<<<remove명령어>>>>>>>>");
		arr1.remove(6);
		System.out.println(arr1);
		
		System.out.println("============================");
		arr1.remove("아기상어");
		System.out.println(arr1);
		
		System.out.println("============================");
		arr1.remove((Object)20);
		System.out.println(arr1);
		
		System.out.println("============================");
		System.out.println(arr1.contains(30));
		System.out.println(arr1.contains(100));
		System.out.println(arr1.indexOf(20));
		System.out.println(arr1.indexOf(100));
		System.out.println(arr1.lastIndexOf(20));
	}

}
