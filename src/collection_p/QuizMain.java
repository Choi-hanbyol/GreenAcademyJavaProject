package collection_p;

public class QuizMain {

	public static void main(String[] args) {
		double dd = 78.333333333333333;
		
		System.out.println("처음 : "+dd);
		double d1 = dd*100;
		System.out.println(d1);
		int d2 = (int)d1;
		System.out.println(d2);
		double d3 = (double)d2;
		System.out.println(d3);
		double d4 = d3/100;
		//d4 = (double)(int)(dd*100)/100; --> 한줄에 해결
		System.out.println("결과 : "+d4);
		System.out.println();
		
		double dd2 = 78.66666666666666;
		System.out.println("처음 : "+dd2);
		double s =  (double)((int)(dd2*100)+1)/100;
		System.out.println("결과 : "+s);
	}

}
