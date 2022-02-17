package collection_p;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueMain {

	public static void main(String[] args) {
		Stack st = new Stack();
		
		Queue qq = new LinkedList();
		
//		st.add(10);
//		st.add(20);
//		st.add(30);
	
//		qq.add(10);
//		qq.add(20);
//		qq.add(30);
	
		st.push(11);
		st.push(22);
		st.push(33);
		
		qq.offer(100);
		qq.offer(200);
		qq.offer(300);
		
		System.out.println("st > "+st);
		System.out.println("qq > "+qq);
		
		System.out.println("=pop()=========================================");
		/*
		Object oo = st.pop();
		System.out.println("st > "+st);
		System.out.println("oo > "+oo);
		oo = st.pop();
		System.out.println("st > "+st);
		System.out.println("oo > "+oo);
		oo = st.pop();
		System.out.println("st > "+st);
		System.out.println("oo > "+oo);
		System.out.println("st.empty() > "+st.empty());
		*/
		System.out.println("st > "+st);
		while(!st.empty()) {
			Object oo = st.pop();
			System.out.println("st.pop() > "+oo);
			System.out.println("st > "+st);
			
		}
		
		System.out.println("=poll()=========================================");
		
		System.out.println("qq > "+qq);
		while(!qq.isEmpty()) {
			Object oo = qq.poll();
			System.out.println("qq.poll() > "+oo);
			System.out.println("qq > "+qq);
		}
		
		
	}

}
