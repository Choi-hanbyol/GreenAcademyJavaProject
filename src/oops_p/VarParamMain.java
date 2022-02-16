package oops_p;

import java.util.Arrays;

class VarParam{
	
	//가변매개변수의 갯수가 오버로딩된 메소드의 갯수가 같아 중첩될 경우
	// 매개변수의 갯수가 명시적인 메소드를 호출
	void meth_1(int a, int ...b) {
		System.out.println("meth_1 오버로딩():"+a+","+Arrays.toString(b));
	}
		
	void meth_1(int a, int b) {
		System.out.println("meth_1():"+a+","+b);
	}

	void meth_2(int a,int [] arr) {
		System.out.println("meth_2():"+a+","+Arrays.toString(arr));
	}
	
	void meth_3(int a,int ...arr) {
		// int ...arr : 가변 매개변수 (배열로 처리)
		// int [] arr
		// 가변 매개변수 : 1. 배열을 배열로
		//             2. 선언 위치 이후의 나열된 모든 매개변수를 배열로
		//             3. 가변매개변수는 매개변수 중 가장 맨 뒤에 위치 해야 한다.
		
		System.out.println("meth_3():"+a+","+Arrays.toString(arr));
	}
	
	void meth_4(int a,int [] arr, int b) {
		System.out.println("meth_3():"+a+","+b+","+Arrays.toString(arr));
	}
	
	/*  가변매개변수는 매개변수 중 가장 맨 뒤에 위치 해야 한다.
	void meth_5(int a,int ...arr, int b) {

		System.out.println("meth_5():"+a+","+b+","+Arrays.toString(arr));
	}*/
	void meth_6(int a, int b,int ...arr) {

		System.out.println("meth_6():"+a+","+b+","+Arrays.toString(arr));
	}
}

public class VarParamMain {

	public static void main(String[] args) {
		VarParam vp = new VarParam();
		vp.meth_1(10,20);
		vp.meth_1(10,20,30,40);
		vp.meth_1(10,20,30);
		vp.meth_1(10);
		//vp.meth_2(10,20);
		vp.meth_3(10,20);
		
		int [] nums = {111,222,333,444,555};
		int [] nums2 = {666,777,888};
		vp.meth_2(20,nums);
		vp.meth_3(20,nums);
		
		//vp.meth_2(30,123,234,345,456,678,789);
		vp.meth_3(30,123,234,345,456,678,789);
		// a= 30,   arr = {123,234,345,456,678,789}
		
		//vp.meth_3(30,nums, nums2);
		
		vp.meth_3(30,123,234);
		vp.meth_3(30,123);
		vp.meth_3(30);
		//vp.meth_3();
	}

}