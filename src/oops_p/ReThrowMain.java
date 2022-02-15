package oops_p;

class ReThrow{
	
	void meth_1() throws Exception {
		
		System.out.println("meth_1() 시작");
		meth_2();
		System.out.println("meth_1() 끝");
	}
	
	void meth_2() throws Exception {
		
		System.out.println("\tmeth_2() 시작");
		
		try {
			meth_3();
		} catch (Exception e) {
			System.out.println("m2 catch :"+e.getMessage());
			throw e;
		}
		
		System.out.println("\tmeth_2() 끝");
	}

	void meth_3() throws Exception{
	
		System.out.println("\t\tmeth_3() 시작");
		
		try {
			throw new Exception("m3 에러");
		} catch (Exception e) {
			System.out.println("m3 catch :"+e.getMessage());
			
			throw e;
		}
		
		
		//System.out.println("\t\tmeth_3() 끝");
	}	
	
	
}

public class ReThrowMain {

	public static void main(String[] args) throws Exception {
		ReThrow rt = new ReThrow();
		try {
			rt.meth_1();
		} catch (Exception e) {
			System.out.println("main catch :"+e.getMessage());
			throw e;
		}
	}

}
