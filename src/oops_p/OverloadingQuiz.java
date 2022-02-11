package oops_p;

class OverArea{
	String name;
	double area1, area2;
	
	OverArea(int a1, int a2){
		name = "직사각형";
		area1 = a1*a2;
		area2 = (a1+a2)*2;
	}
	
	OverArea(int a1, int a2, int a3){
		name = "직각삼각형";
		area1 = (a1*a2)/2;
		area2 = a1+a2+a3;
	}
	
	OverArea(int a1){
		name = "원";
		area1 = a1*a1*3.14;
		area2 = a1*2*3.14;
	}

	@Override
	public String toString() {
		return name +"\t넓이 : "+ area1 +"\t둘레 : "+ area2;
	}
	
}

public class OverloadingQuiz {

	public static void main(String[] args) {
		OverArea [] res = {
				new OverArea(4,5),
				new OverArea(4,4,12),
				new OverArea(4)
				
		};
		
		/*for(OverArea oe : res) {
			System.out.println(oe);
		}------> 향상된 for문 밑에 문구를 위처럼 줄일수있음*/ 
		
		for(int i = 0; i<res.length; i++) {
			OverArea oe = res[i];
			System.out.println(oe);
		}

	}

}
