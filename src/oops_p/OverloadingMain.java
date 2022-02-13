package oops_p;

class ClaOver{
	
	int meth(int a, String b) {
		System.out.printf("기본메소드 : ",a+","+b);
		return 1234;
	}
	
	int meth(int a, String b, int c) {
		System.out.printf("매개변수 갯수가 다른경우 : ",a+","+b+","+c);
		return 5678;
	}
}

public class OverloadingMain {

	public static void main(String[] args) {
		ClaOver co = new ClaOver();
		
		int ret = co.meth(10,"장동건");
		System.out.println(ret);
		
		ret = co.meth(10, "장남건", 20);
		System.out.println(ret);

	}

}
