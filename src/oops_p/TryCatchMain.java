package oops_p;

public class TryCatchMain {

	public static void main(String[] args) {
		
		try {
			
			int a = 10/5;
			
			System.out.println("a : "+a);
			
			int [] arr = {11,22,33,44};
			
			System.out.println("arr : "+arr[5]);
			
		}//try
		
		catch (ArithmeticException e) {
			//System.out.println("수학적 예외 발생"+e.getMessage());
			System.err.println("수학적 예외 발생 : "+e.getMessage()); //빨간글씨로 에러이유 설명
			//e.printStackTrace(); //에러메세지 출력 
				/*ex) java.lang.ArithmeticException: / by zero
				at oops_p.TryCatchMain.main(TryCatchMain.java:9)*/
			
		}
		
		//catch(ArrayIndexOutOfBoundsException e) {
			//System.err.println("배열 에러 발생 : "+e.getMessage());
		catch(Exception e) {
			System.err.println("일반 에러발생 : "+e.getMessage());
			return;
		}
		finally {
			System.out.println("프로그램 종료");
		}
		
	}//main

}//class