package collection_p;

import java.util.ArrayList;
import java.util.Iterator;

class GenShape{
	String name;
	double area, border;
	@Override
	public String toString() {
		return name+":"+area+":"+border;
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


public class GenShapeMain {

	public static void main(String[] args) {
		ArrayList<GenShape> arr = new ArrayList<GenShape>();
		arr.add(new GenRectangle(5, 6));
		arr.add(new GenCircle(5));
		arr.add(new GenRectangle(10, 6));
		arr.add(new GenCircle(8));
		arr.add(new GenCircle(10));
		arr.add(new GenRectangle(8, 7));
		
		Iterator<GenShape>it = arr.iterator();
		
		while(it.hasNext()) {
			GenShape gs = it.next();
			System.out.println(gs.name);
		}
		
		for(GenShape gs : arr) {
			System.out.println(gs.name+"=>"+gs.area);
		}
	}

}
