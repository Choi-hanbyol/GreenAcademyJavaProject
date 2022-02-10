package oops_p;

class StAAA{
	
	/* 클래스 정의부에서 직접 연산 및 제어문 사용 불가
	if(true) {
		
	}*/
	
	int aa = 100;
	
	void meth_1() {
		
		int a = 10;
		new StAAA();
		
		if(true) {
			
		}
		
		//void meth_2() {}
	}
	
}


class ClaOuter{
	static int sa = 0;
	int a = 11;
	int aa = 0;
	void meth_1() {
		//System.out.println("외부클래스 meth_1() 실행:"+a+","+b);
		aa++;
		System.out.println("외부클래스 meth_1() 실행:"+a+","+aa);
	}
	
	//내부클래스 정의 - 기본(인스턴스) 내부클래스
	class ClaInner{
		int b = 2000;
		
		void meth_i_1() {
			aa++;
			b++;
			System.out.println("기본 내부클래스 meth_i_1() 실행"+a+","+b+","+aa);
		}
		
	}
	
	//멤버변수로 선언
	ClaInner cin = new ClaInner();
	
	
	static class SSSInner{
		int sb = 3000;
		static int ssb = 3333;
		void meth_s() {
			//System.out.println("static 내부클래스 meth_s() 실행"+a+","+aa);
			sa++;
			sb++;
			ssb++;
			System.out.println("static 내부클래스 meth_s() 실행"+sa+","+sb+","+ssb);
		}
	}
	
	void meth_2() {
		
		System.out.println("외부 meth_2() 시작");
		
		class LocInner{
			int d = 44;
			
			void meth_3() {
				System.out.println("지역 내부 meth_3():"+a+","+d);
			}
		}
		
		LocInner li = new LocInner();
		li.meth_3();
		
		System.out.println("외부 meth_2() 끝:"+li.d);
		
	}
	
	//LocInner li = new LocInner();
}


public class StructMain {

	public static void main(String[] args) {
		
		new StAAA();
		
		ClaOuter co = new ClaOuter();
		ClaOuter co2 = new ClaOuter();
		System.out.println(co.a);
		co.meth_1();
		co.meth_1();
		co.meth_1();
		//System.out.println(co.b);  외부클래스로 생성된 객체에서 내부클래스의 멤버 직접호출 불가
		//co.meth_i_1();
		
		System.out.println(co.cin); 
		System.out.println(co.cin.b);
		co.cin.meth_i_1();
		co.cin.meth_i_1();
		co.cin.meth_i_1();
		
		
		
		//ClaInner ci;
		//ClaOuter.ClaInner ci = new ClaOuter.ClaInner();
		
		ClaOuter.ClaInner ci_1;
		ClaOuter.ClaInner ci_2 = co.new ClaInner();
		ClaOuter.ClaInner ci_3 = co.new ClaInner();
		//ci = ClaOuter.new ClaInner();
		ci_1 =  co.new ClaInner();
		//ci =  new ClaOuter().new ClaInner();
		ci_1.meth_i_1();
		ci_2.meth_i_1();
		ci_3.meth_i_1();
		ci_3.meth_i_1();
		ci_2.meth_i_1();
		ci_1.meth_i_1();
		ci_2.meth_i_1();
		ci_3.meth_i_1();
		ci_1.meth_i_1();
		
		System.out.println(co.aa);
		System.out.println(co2.aa);
		
		
		//////////////////////////////////////////////////
		
		ClaOuter.SSSInner cs_1 = new ClaOuter.SSSInner();
		ClaOuter.SSSInner cs_2 = new ClaOuter.SSSInner();
		
		//System.out.println(co.sb);
		//System.out.println(ClaOuter.sb);
		//System.out.println(ClaOuter.SSSInner.sb);
		System.out.println(ClaOuter.SSSInner.ssb);
		//System.out.println(SSSInner.ssb);
		//System.out.println(cs_1.sa);
		System.out.println(cs_1.sb);
		System.out.println(cs_1.ssb);
		cs_1.meth_s();
		cs_1.meth_s();
		cs_2.meth_s();
		cs_2.meth_s();
		
		
		co.meth_2();
		//ClaOuter.LocInner cl;
		//Object cl = co.new LocInner();
		//Object cl = co.meth_2().new LocInner();
		//Object cl = co.meth_2.new LocInner();
		
		ClaOuter co3 = new ClaOuter();
		ClaOuter co4 = new ClaOuter() {
			int aaaa = 12345;
			void meth_3() {
				System.out.println("생성시 정의 meth_3()");
			}
			
			//정의부여서 실행구문 처리 불가
			//System.out.println("이거 왜 안돼지?");
			void meth_1() {
				
				System.out.println("생성시 재정의 meth_1() 실행:"+a+","+aa+","+aaaa);
				meth_3();
			}
			
		};
		
		System.out.println("co3:"+co3.a+","+co3.aa);
		co3.meth_1();
		
		System.out.println("co4:"+co4.a+","+co4.aa);
		co4.meth_1();
		//System.out.println("co4:"+co4.aaaa);
		//co4.meth_3();
	}

}