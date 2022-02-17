package collection_p;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
	
	static void add_1(String name, List arr) {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 2000000; i++) {
			arr.add("아기상어");
		}
		System.out.println(name+" 순차추가:"+(System.currentTimeMillis()-start));
	}
	
	static void add_2(String name, List arr) {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 1000; i++) {
			arr.add(100,"아기상어");
		}
		System.out.println(name+" 비순차추가:"+(System.currentTimeMillis()-start));
	}
	
	static void remove_2(String name, List arr) {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 1000; i++) {
			arr.remove(100);
		}
		System.out.println(name+" 비순차삭제:"+(System.currentTimeMillis()-start));
	}
	
	static void remove_1(String name, List arr) {
		long start = System.currentTimeMillis();
		
		for(int i = arr.size()-1; i>=0; i--) {
			arr.remove(i);
		}
		
		System.out.println(name+" 순차삭제:"+(System.currentTimeMillis()-start));
	}
	

	public static void main(String[] args) {
		List arr1 = new ArrayList();
		List arr2 = new LinkedList();
		
		add_1("array",arr1);
		add_1("linked",arr2);
		
		add_2("array",arr1);
		add_2("linked",arr2);
		
		remove_2("array",arr1);
		remove_2("linked",arr2);
		
		remove_1("array",arr1);
		remove_1("linked",arr2);
		
		System.out.println(arr1.isEmpty());
		System.out.println(arr2.isEmpty());
	}

}