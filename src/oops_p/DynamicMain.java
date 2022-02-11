package oops_p;

class Dypar{
	String a = "부모a";
	String b = "부모b";
	
	void meth_1() {
		System.out.println("부모 meth_1() : "+ a +","+ b);
	}
	
	void meth_2() {
		System.out.println("부모 meth_2() : "+ a +","+ b);
	}
}

class DyChild extends Dypar{
	String c = "자식c";
	String b = "자식b";
	
	void meth_1() { //overriding
		System.out.println("자식 meth_1() : "+ a +","+ b +","+ c);
	}
	
	void meth_3() {
		System.out.println("자식 meth_3() : "+ a +","+ b +","+ c);
	}
}
public class DynamicMain {

	public static void main(String[] args) {
		Dypar pp = new Dypar();
		Dypar pc = new DyChild();
		//DyChild cp = new Dypar();
		DyChild cc = new DyChild();
		
		System.out.println("pp : "+pp.a +","+ pp.b);
		pp.meth_1();
		pp.meth_2();
		
		System.out.println("pc : "+pc.a +","+ pc.b);
		pc.meth_1();
		pc.meth_2();
		
		cc.c="아들c";
		System.out.println("cc : "+cc.a +","+ cc.b  +","+ cc.c);
		cc.meth_1();
		cc.meth_2();
		cc.meth_3();
		
		Dypar pcc=cc;
		System.out.println("pcc : "+pcc.a +","+ pcc.b);
		cc.meth_1();
		cc.meth_2();
		
		DyChild cpcc = (DyChild)pcc;
		System.out.println("cpcc : "+cpcc.a +","+ cpcc.b +","+ cpcc.c);
		cpcc.meth_1();
		cpcc.meth_2();
		cpcc.meth_3();
		
		System.out.println(pp instanceof Dypar);
		System.out.println(pp instanceof DyChild);
		System.out.println(cc instanceof Dypar);
		System.out.println(cc instanceof DyChild);

	}

}
