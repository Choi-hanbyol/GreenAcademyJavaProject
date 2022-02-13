package oops_p;

class DyTpTT{
	String name;
	void go(String dst, int dist) {
		System.out.println("난 안가.");
	}
}

class KAL extends DyTpTT{
	int kmh;
	public KAL(int kmh) {
		this.kmh = kmh;
		name = "비행기";
	}
	
	@Override
	void go(String dst, int dist) {
		double hh = (double)dist/kmh;
		System.out.println(dst+"까지"+hh+"시간으로 비행기 타고 가요.");
	}
}

class Ship extends DyTpTT{
	String meal;
	public Ship(String meal) {
		this.meal = meal;
		name = "배";
	}
	
	@Override
	void go(String dst, int dist) {
		System.out.println(dst+"까지"+meal+"먹으면서 항해해요.");
	}
}

public class DyTransportationMain {

	public static void main(String[] args) {
		DyTpTT [] tts = {
				new DyTpTT(),
				new KAL(800),
				new Ship("두리안"),
				new KAL(1000),
				new Ship("스테이크")
		};
		
		for (DyTpTT dt : tts) {
			dt.go("샌프란시스코", 9086);
			
		}

	}

}
