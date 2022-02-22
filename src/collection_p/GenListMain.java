package collection_p;

import java.util.ArrayList;
import java.util.Iterator;

class Product{}
class Phone extends Product{}
class HandPhone extends Phone{}
class TV{}



public class GenListMain {

	public static void main(String[] args) {
		
		ArrayList ar1 = new ArrayList();
		ArrayList<Phone> ar2 = new ArrayList();
		ArrayList<? super Phone> ar22 = new ArrayList();  //Phone의 자식까지 허용
		ArrayList<? extends Phone> ar222 = new ArrayList();//의미 없음
		ArrayList<HandPhone> ar3 = new ArrayList();
		ArrayList<TV> ar4 = new ArrayList();
		ArrayList<Product> ar5 = new ArrayList();

		ar1.add(new Phone());
		ar1.add(new HandPhone());
		ar1.add(new TV());
		
		ar2.add(new Phone());
		ar2.add(new HandPhone());
//		ar2.add(new TV());
		
		ar22.add(new Phone());
		ar22.add(new HandPhone());
//		ar22.add(new TV());
		
//		ar222.add(new Phone());
//		ar222.add(new HandPhone());
//		ar222.add(new TV());
		
//		ar3.add(new Phone());
		ar3.add(new HandPhone());
//		ar3.add(new TV());
		
//		ar4.add(new Phone());
//		ar4.add(new HandPhone());
		ar4.add(new TV());
		
		ar5.add(new Phone());
		ar5.add(new HandPhone());
//		ar5.add(new TV());
		ar5.add(new Product());
		
		
		meth_1(ar1);
		meth_1(ar2);
		meth_1(ar3);
		meth_1(ar4);
		
//		meth_2(ar1);
		meth_2(ar2);
//		meth_2(ar3);
//		meth_2(ar4);
//		meth_2(ar5);
		
//		meth_3(ar2);
		meth_3(ar3);
//		meth_3(ar4);
//		meth_3(ar5);
		
		meth_4(ar2);
		meth_4(ar3);
//		meth_4(ar4);
//		meth_4(ar5);
		
		meth_5(ar2);
//		meth_5(ar3);
//		meth_5(ar4);
		meth_5(ar5);
		
		Iterator<Phone> it = ar2.iterator();
		while(it.hasNext()) {
			Phone pp = it.next();
		}
		
		for(Phone pp : ar2) {
			
		}
		
	}
	
	static void meth_1(ArrayList arr) {	}
	
	static void meth_2(ArrayList<Phone> arr) {	
		for (Phone phone : arr) {
			
		}
	}
	
	static void meth_3(ArrayList<HandPhone> arr) {	
			
	}
	
	//phone -> 자식까지 허용
	static void meth_4(ArrayList<? extends Phone> arr) {	
		
	}
	
	//<-phone 부모 허용
	static void meth_5(ArrayList<? super Phone> arr) {	
		
	}

}
