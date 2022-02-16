package lang_p;

import java.util.Scanner;

interface ShapeType{
	void execute(int a, int b);

}

class ShapeRectangle implements ShapeType{
	
	@Override
	public void execute(int a, int b) {
		System.out.println("사각형의 넓이 : "+a*b);
	}
}

class ShapeCircle implements ShapeType{
	@Override
	public void execute(int a, int b) {
		System.out.println("원의 넓이 : "+a*b*3.14);
	}
}

class ShapeTriangle implements ShapeType{
	@Override
	public void execute(int a, int b) {
		System.out.println("삼각형의 넓이 : "+(a*b)/2);
	}
}
public class ShapeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("입력하신 도형의 넓이를 구합니다.");
			System.out.println("0:사각형 / 1:원 / 2:삼각형 / 9:프로그램 종료");
			
			System.out.print("명령어 입력 : ");
			int tt = sc.nextInt();
			
			if(tt==0) {
				try {
					ShapeType st = (ShapeType)Class.forName("lang_p.ShapeRectangle").newInstance();
					System.out.println("가로 입력 : ");
					int a = sc.nextInt();
					System.out.println("세로 입력 : ");
					int b = sc.nextInt();
					st.execute(a,b);
					break;
					
				} catch (Exception e) {
					System.out.println("잘못된 명령어 입니다.");
					System.out.println();
				}
			}else if(tt==1) {
				try {
					ShapeType st = (ShapeType)Class.forName("lang_p.ShapeCircle").newInstance();
					System.out.println("반지름 입력 : ");
					int a = sc.nextInt();
					System.out.println("반지름 입력 : ");
					int b = sc.nextInt();
					st.execute(a,b);
					break;
					
				} catch (Exception e) {
					System.out.println("잘못된 명령어 입니다.");
					System.out.println();
				}
			}
			else if(tt==2) {
				try {
					ShapeType st = (ShapeType)Class.forName("lang_p.ShapeTriangle").newInstance();
					System.out.println("가로 입력 : ");
					int a = sc.nextInt();
					System.out.println("세로 입력 : ");
					int b = sc.nextInt();
					st.execute(a,b);
					break;
					
				} catch (Exception e) {
					System.out.println("잘못된 명령어 입니다.");
					System.out.println();
				}
			}
			else if(tt==9) {
				break;
			}
			
		}
		System.out.println("프로그램 종료");
		
	}

}
