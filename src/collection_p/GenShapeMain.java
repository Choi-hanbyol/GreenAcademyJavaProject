/*
도형별로 나누어 정렬하여 출력하세요
구분 : 도형이름
정렬순서 : 넓이 > 둘레 내림차순 기준
*/
package collection_p;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class GenShape{
	String name;
	double area, border;
	@Override
	public String toString() {
		return name+" : "+area+" : "+border;
	}
}

class GenRectangle extends GenShape{
	public GenRectangle(int w, int h) {
		name = "직사각형";
		area = w*h;
		border = (w+h)*2;
	}
}

class GenCircle extends GenShape{
	public GenCircle(int r) {
		name = "원";
		area = Math.PI*r*r;
		border = Math.PI*r*2;
	}
}

//class GenShapeCom implements Comparator<GenShape>{
//	@Override
//	public int compare(GenShape o1, GenShape o2) {
//
//		int res = o1.name.compareTo(o2.name);
//		System.out.println("!!"+res);
//		if(res==0) {
//			res = (int) (o2.area - o1.area);
//			System.out.println(">"+res);
//		}
//		if(res==0) {
//			res = (int) (o2.border - o1.border);
//			System.out.println(">>"+res);
//		}
//		System.out.println(">>>"+res);
//		return res;
//	}
//	
//}

public class GenShapeMain {

	public static void main(String[] args) {
		ArrayList<GenShape> arr = new ArrayList<GenShape>();
//		TreeSet<GenShape> arr = new TreeSet<GenShape>(new GenShapeCom());
		arr.add(new GenRectangle(5, 6));
		arr.add(new GenCircle(5));
		arr.add(new GenRectangle(10, 6));
		arr.add(new GenCircle(8));
		arr.add(new GenCircle(10));
		arr.add(new GenRectangle(8, 7));
		
		Iterator<GenShape>it = arr.iterator();
		
//		while(it.hasNext()) {
//			GenShape gs = it.next();
//			System.out.println(gs);
//		}
		
		for(GenShape gs : arr) {
			System.out.println(gs.name+" => 넓이 : "+gs.area+" / 둘레 : "+gs.border);
		}
	}

}
