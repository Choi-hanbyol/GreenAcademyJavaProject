package lang_p;


class CC_A{
	int a = 10;
	String b = "CC_A.b";
	
	void meth_1() {
		System.out.println("CC_A meth_1() 입니다.");
	}
	
	void meth_2() {
		System.out.println("CC_A meth_2() 입니다.");
	}
}

class CC_B{
	int a = 10;
	String b = "CC_B.b";
	
	void meth_1() {
		System.out.println("CC_B meth_1() 입니다.");
	}
	
	void meth_2() {
		System.out.println("CC_B meth_2() 입니다.");
	}
}
public class ClassMain {

	public static void main(String[] args) throws Exception {
		CC_A a1 = new CC_A();
		
		System.out.println("a1 : "+a1.a+", "+a1.b);
		a1.meth_1();
		a1.meth_2();
		System.out.println("========================");
		Class c1 = a1.getClass();
		System.out.println("c1 : "+c1);
		System.out.println("c1 : "+c1.getName());
		
		System.out.println("========================");
		Class c2 = Class.forName("lang_p.CC_A");
		
		System.out.println("========================");
		Object a2 = c1.newInstance();
		Object a3 = c1.newInstance();
		CC_A a4 = (CC_A)c1.newInstance();
		CC_A a5 = (CC_A)c1.newInstance();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
		
		System.out.println("========================");
		a4.meth_1();
		a5.meth_2();
		
		System.out.println("========================");
		String ttt = "lang_p.CC_A";
		CC_A a6 = (CC_A)Class.forName(ttt).newInstance();
		System.out.println(a6);
		a6.meth_1();
		//CC_B b7 = (CC_B)Class.forName(ttt).newInstance(); -> 겉으론 오류가 없지만 돌려보면 오류가 뜸
		
		System.out.println("========================");
		String ttt1 = "lang_p.CC_B";
		CC_B b7 = (CC_B)Class.forName(ttt1).newInstance();
		System.out.println(b7);
		b7.meth_1();
		
		
	}
}