package oops_p;


class LC{
	
	public LC() { //생성자
		System.out.println("기본 생성자 실행"+this);
		a=1111;
	}
	int a = goA();
	int b = goB();
	
	int goA() {
		System.out.println("goA()실행");
		return 10;
	}
	
	int goB() {
		System.out.println("goB()실행");
		return 20;
	}

	@Override
	public String toString() {
		return "LC [a=" + a + ", b=" + b + "]";
	}
	
	static int goC() {
		System.out.println("static goC()실행");
		return 20;
	}
	
	static int c = goC();
}

public class LifeCycleMain {

	public static void main(String[] args) {
		System.out.println(LC.c);
		System.out.println("c1------------");
		LC c1 = new LC();
		System.out.println("c2------------");
		LC c2 = new LC();
		System.out.println("--------------");
		System.out.println(c1);
		System.out.println(c2);

	}

}
