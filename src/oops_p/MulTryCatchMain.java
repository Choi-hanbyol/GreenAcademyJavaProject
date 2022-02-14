package oops_p;

public class MulTryCatchMain {

	public static void main(String[] args) {
		try {
			System.out.println("try 1");
			int a = 10/0;
			
			System.out.println("try 2");
			try {
				System.out.println("try ~try 1");
				//int a = 10/0;
				int b = 10/0;
				System.out.println("try ~try 2");	
			} 
			catch (Exception e) {
				System.out.println("try ~try 예외발생 1");
			}
			
			System.out.println("try 3");
			int c = 10/0;
			
		}
		catch (Exception e) {
			System.out.println("예외발생 1");
			
			try {
				System.out.println("catch ~try 1");
				int a = 10/0;
				
				System.out.println("catch ~try 2");
			} catch (Exception e2) {
				System.out.println("catch catch 예외발생");
			}
		}
		System.out.println("프로그램종료!");
	}

}
