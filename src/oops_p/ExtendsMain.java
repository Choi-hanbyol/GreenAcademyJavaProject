package oops_p;

class Grand{
	int g = 9999;
	void meth_g() {
		System.out.println("할아버지 meth_g()");
	}
}

class Par1 extends Grand{//클래스의 정의 - 부모
	
	int a = 10;
	String b = "아빠상어";  //hiding
	int g = 8888;
	
	void meth_1() {
		System.out.println("부모1 meth_1()");
	}
	
	void meth_2() {
		System.out.println("부모1 meth_2()");
	}
	
	void meth_g() {
		System.out.println("부모1 meth_g()");
	}
}


class Par2{//클래스의 정의 - 부모
	
	int a = 111;
	String bb = "엄마상어";
	
	void meth_11() {
		System.out.println("부모2 meth_1()");
	}
	
	void meth_22() {
		System.out.println("부모2 meth_2()");
	}
}


class Child1 extends Par1{//, Par2{ //자식  -- 다중상속 불가 
	int c = 3000;
	
	String b = "아기상어";
	String sb = super.b;	//부모객체 접근자:super
	//int sg = super.super.g;
	//int sg = mega.g;
	
	void meth_2() {	//overriding
		System.out.println("자식1 meth_2()");
	}
	
	void meth_s2() {	
		super.meth_2();
	}
	
	void meth_3() {
		System.out.println("자식1 meth_3()");
	}
	
	void meth_sg() {	
		super.meth_g();
		//super.super.meth_g();
	}
}

class Child2 extends Par1 { 
	int d = 4567;
	
	void meth_4() {
		System.out.println("자식2 meth_4()");
	}
}


public class ExtendsMain {

	public static void main(String[] args) {
		Par1 pp1;//인스턴스 변수 선언
		pp1 = new Par1(); //인스턴스 생성 및 인스턴스 주소 인스턴스변수에 대입
		System.out.println(pp1.a+","+pp1.b);
		//System.out.println(pp1.c);
		pp1.meth_1();//인스턴스 멤버요소 호출
		pp1.meth_2();
		//pp1.meth_3(); 자식의 멤버 접근 불가
		System.out.println("-------------------------");
		Child1 cc1 = new Child1();
		//System.out.println(cc1.a+","+cc1.b+","+cc1.sb+","+cc1.g+","+cc1.sg);
		System.out.println(cc1.c);
		//System.out.println(cc1.super.b);
		//System.out.println(cc1.d);
		cc1.meth_1();//부모 멤버 접근 가능
		cc1.meth_2();
		cc1.meth_s2();
		cc1.meth_3();
		cc1.meth_g();
		cc1.meth_sg();
		//cc1.meth_4();
		
		System.out.println("-------------------------");
		
		Child2 cc2 = new Child2();
		System.out.println(cc2.a+","+cc2.b);
		//System.out.println(cc2.c);
		System.out.println(cc2.d);
		cc2.meth_1();//부모 멤버 접근 가능
		cc2.meth_2();
		//cc2.meth_3();
		cc2.meth_4();
	}

}

