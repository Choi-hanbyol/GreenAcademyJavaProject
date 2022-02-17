package collection_p;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayNumMain {

	public static void main(String[] args) {
		int [] arr = {45,3,17,56,9,87,453,265,27,91,21,34,66,98,87};
		
		ArrayList two = new ArrayList();
		ArrayList three = new ArrayList();
		
		for(int i : arr) {
			System.out.println(i);
			if(i%2==0) {
				two.add(i);
			}
			if(i%3==0) {
				three.add(i);
			}
		}
		Collections.sort(two);
		Collections.sort(three);
		System.out.println("two > "+two);
		System.out.println("three > "+three);
	}

}
