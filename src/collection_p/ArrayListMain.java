package collection_p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		
		System.out.println("arr1 > "+arr1);
		System.out.println(arr1.size());
		System.out.println(arr1.get(2));
		System.out.println("=========set() 명령어==========");
		arr1.set(4, "엄마상어");
		System.out.println("arr1 > "+arr1);
		
		System.out.println("=========add() 명령어==========");
		arr1.add(3,"장수풍뎅이");
		System.out.println("arr1 > "+arr1);
		
		System.out.println("<<<<<<<<remove명령어>>>>>>>>");
		arr1.remove(6);
		System.out.println("arr1 > "+arr1);
		
		System.out.println("============================");
		arr1.remove("아기상어");
		System.out.println("arr1 > "+arr1);
		
		System.out.println("============================");
		arr1.remove((Object)20);
		System.out.println("arr1 > "+arr1);
		
		System.out.println("============================");
		System.out.println(arr1.contains(30));
		System.out.println(arr1.contains(100));
		System.out.println(arr1.indexOf(20));
		System.out.println(arr1.indexOf(100));
		System.out.println(arr1.lastIndexOf(20));
		
		System.out.println("============================");
		Object [] arr2 = arr1.toArray();
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("============================");
		List arr3 = arr1.subList(2, 7); //shallow copy
		List arr4 = new ArrayList(arr1.subList(2, 7)); //deep copy
		List arr5 = new ArrayList();
		arr5.addAll(arr3);
		List arr6 = new ArrayList();
		arr6.add(12);
		arr6.add(34);
		arr6.add(56);
		
		List arr7 = new ArrayList();
		arr7.add(30);
		arr7.add(100);
		arr7.add(10);
		
		System.out.println("arr3 > "+arr3);
		System.out.println("arr4 > "+arr4);
		System.out.println("arr5 > "+arr5);
		System.out.println("arr6 > "+arr6);
		System.out.println("arr7 > "+arr7);
		
		System.out.println("============================");
		arr1.set(3, "아빠상어");
		arr3.set(4, 1357);
		System.out.println("arr1 > "+arr1);
		System.out.println("arr3 > "+arr3);
		System.out.println("arr4 > "+arr4);
		System.out.println("arr5 > "+arr5);
		arr5.addAll(2,arr6);
		System.out.println("arr5 > "+arr5);
		
		System.out.println("============================");
		System.out.println("arr5 > "+arr5.containsAll(arr6));
		System.out.println("arr5 > "+arr5.containsAll(arr7));
		
		System.out.println("=======removeAll()=============");
		arr5.removeAll(arr7);
		System.out.println("arr5 > "+arr5);
		List arr8 = new ArrayList(arr1);
		arr1.removeAll(arr7);
		System.out.println("arr1 > "+arr1);
		arr1.add(34);
		arr1.add(78);
		arr1.add(12);
		System.out.println("arr1 > "+arr1);
		
		System.out.println("=========retainAll()==========");
		arr1.retainAll(arr6);
		System.out.println("arr1 > "+arr1);
		System.out.println("arr8 > "+arr8);
		
		System.out.println("=========replaceAll()==========");
		Collections.replaceAll(arr8, 10, "열");
		System.out.println("arr8 > "+arr8);
		
		System.out.println("=========reverse()==========");
		Collections.reverse(arr8);
		System.out.println("arr8 > "+arr8);
		
		System.out.println("=========swap()==========");
		Collections.swap(arr8,4,7);
		System.out.println("arr8 > "+arr8);
		
		System.out.println("=========shuffle()==========");
		Collections.shuffle(arr8);
		System.out.println("arr8 > "+arr8);
		
		System.out.println("=========sort()_숫자==========");
		List arr9 = new ArrayList();
		arr9.add(4);
		arr9.add(10);
		arr9.add(78);
		arr9.add(23);
		arr9.add(56);
		arr9.add(13);
		arr9.add(41);
		System.out.println("arr9 > "+arr9);
		Collections.sort(arr9);
		System.out.println("arr9 > "+arr9);
		System.out.println("=========sort()_문자==========");
		List arr10 = new ArrayList();
		arr10.add("파랑");
		arr10.add("노랑");
		arr10.add("빨강");
		arr10.add("보라");
		arr10.add("녹색");
		arr10.add("검정");
		arr10.add("하양");
		System.out.println("arr10 > "+arr10);
		Collections.sort(arr10);
		System.out.println("arr10 > "+arr10);
		
		
	}

}
