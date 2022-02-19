package collection_p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		Set s1 = new HashSet();
		ArrayList arr1 = new ArrayList();
		
		Object [] arr = {45,67,78,45,76,23,12,23,2,3,12,45,67,"45",65,'A'};
		
		for (Object oo : arr) {
			s1.add(oo);
			arr1.add(oo);
		}
		
		System.out.println("s1:"+s1);
		System.out.println("arr1:"+arr1);
		s1.remove(2);
		System.out.println("s1:"+s1);
		System.out.println(s1.size());
		System.out.println(s1.contains(67));
		System.out.println(s1.contains(100));
		
		ArrayList arr2 = new ArrayList();
		arr2.add(111);
		arr2.add(222);
		arr2.add(111);
		arr2.add(444);
		arr2.add(222);
		System.out.println(arr2);
		
		s1.addAll(arr2);
		System.out.println(s1);
		System.out.println(s1.containsAll(arr2));
		s1.remove(111);
		System.out.println(s1.containsAll(arr2));
		arr2.add(777);
		arr2.add(888);
		s1.removeAll(arr2);
		System.out.println(arr2);
		System.out.println(s1);
		
		
		Set lotto1 = new HashSet();
		ArrayList lotto2 = new ArrayList();
		
		while(true) {
			int no = (int)(Math.random()*45+1);
			lotto1.add(no);
			lotto2.add(no);
			
			if(lotto1.size()==7)
				break;
		}
		
		System.out.println("lotto1:"+lotto1);
		System.out.println("lotto2:"+lotto2);
		
		
		Set bingo = new HashSet();
		
		while(bingo.size()<25) {
			int no = (int)(Math.random()*100+1);
			bingo.add(no);
		}
		
		//System.out.println(bingo);
		int i = 0;
		for (Object oo : bingo) {
			i++;
			System.out.print(oo+"\t");
			
			if(i%5==0) {
				System.out.println();
			}
		}
		
		
		Set t1 = new HashSet();
		Set t2 = new HashSet();
		Set fa = new HashSet();
		
		for (Object object :"박재상,박정권,최정,김광현,엄정욱,박희수,이호준".split(",")) {
			t1.add(object);
		}
		for (Object object :"이호준,엄정욱,박재홍,이신협,장동건".split(",")) {
			t2.add(object);
		} 
		for (Object object :"이병규,이승엽,박정권,장동건,박용택,홍성흔".split(",")) {
			fa.add(object);
		} 
		   
		System.out.println("변경전 >>>>>>>>>>");
		System.out.println("1군:"+t1);
		System.out.println("2군:"+t2);
		System.out.println("FA:"+fa);
		
		
		Set newfA = new HashSet(fa);
		//System.out.println("fa:"+fa);
		//System.out.println("newfA:"+newfA);
		
		fa.removeAll(t1);
		fa.removeAll(t2);
		//System.out.println("fa:"+fa);
		//System.out.println("newfA:"+newfA);
		
		
		t1.removeAll(t2);
		t1.removeAll(newfA);
		t2.removeAll(newfA);
		
		System.out.println("변경후 >>>>>>>>>>");
		System.out.println("1군:"+t1);
		System.out.println("2군:"+t2);
		System.out.println("FA:"+fa);
		
	}

}

