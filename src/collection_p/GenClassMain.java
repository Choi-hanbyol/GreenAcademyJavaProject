package collection_p;

class GenAA<QQ, RR>{
	String name;
	QQ q;
	RR r;
	
	GenAA(String name, QQ q, RR r){
		this.name = name;
		this.q = q;
		this.r = r;
	}
	
	public String toString() {
		
		return name+","+q+","+r;
	}
}

public class GenClassMain {

	public static void main(String[] args) {
		
		//생성시 제너릭 설정 생성자 호출 시에만 제너릭작동
		GenAA a1 = new GenAA<Boolean, Integer>("송지은만세", true, 123);
		a1.name = "전문기";
		a1.q = false;
		a1.r = "장수풍뎅이"; //선언시 제너릭 설정되지 않아 멤버변수에 Object 개념으로 모든 값 입력 가능
		System.out.println("a1:"+a1);
		
		//선언시 제너릭 설정
		GenAA<Boolean, Integer> a2 = new GenAA("송지은만세", true, 123);
		a2.name = "전문기";
		a2.q = false;
		//a2.r = "장수풍뎅이";  멤버변수에 설정된 자료형으로 대입
		System.out.println("a2:"+a2);
		
		
		//선언시 제너릭 설정
		//생성시 제너릭 설정하지 않으면 생성시 Object로 입력 가능
		GenAA<Boolean, String> a3 = new GenAA("김경준만세", true, 123);
		a3.name = "김지원";
		a3.q = false;
		//a3.r = "사슴벌레";
		//a3.r = 789;
		System.out.println("a3:"+a3);
		
		//GenAA<Boolean, String> a4 = new GenAA<Boolean, String>("김경준만세", true, 123);
		//선언과 생성시 모두 제너릭 설정
		//생성자 매개변수, 인스턴스변수에서 멤버 대입/호출시 모두 자료형 지정대로 입출력 해야 함
		GenAA<Boolean, String> a4 = new GenAA<Boolean, String>("김경준만세", true, "프테라노돈");
		a4.name = "김지원";
		a4.q = false;
		a4.r = "사슴벌레";
		//a4.r = 789;
		System.out.println("a4:"+a4);
		
		String nn = a4.name;
		//nn = a4.q;
		boolean bo = a4.q;
		nn = a4.r;

	}

}
