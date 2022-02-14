package oops_p;

/*
	자동차 성능 테스트 하세요
	
	자동차 클래스로 성능확인 가능할 것
	
	차종 에 따른 연산 식 다르게 할 것
	차종
	스포츠카  : 속도 50 , 연비 20, 디자인 30
	트럭 : 연비 60, 적재량 40
	승합차 : 속도 15, 연비 35, 탑승인원 50
	
	으로 각 성능점수를 계산토록 할 것
*/


abstract class DyCar{
	String kind;
	double jum;
	
	abstract void calc();
	
	public DyCar() {
		//calc();
	}
	
	@Override
	public String toString() {
		calc();
		return kind + " , " + jum;
	}
}

class DySports extends DyCar{

	int speed = 123, fuel= 456, design = 789;
	
	
	
	public DySports(int speed, int fuel, int design) {
		kind = "스포츠";
		this.speed = speed;
		this.fuel = fuel;
		this.design = design;
	}

	@Override
	void calc() {
		
		jum = speed *0.5 + fuel* 0.2+ design* 0.3;
	}
	
}

class DyTruck extends DyCar{

	int  fuel, loadage;
	
	
	
	public DyTruck(int fuel, int loadage) {
		kind = "트럭";
		
		this.fuel = fuel;
		this.loadage = loadage;
	}

	@Override
	void calc() {
		
		jum = fuel* 0.6+ loadage* 0.4;
	}
	
}

class DyVan extends DyCar{

	int speed, fuel, cnt;
	
	
	
	public DyVan(int speed, int fuel, int cnt) {
		kind = "승합차";
		this.speed = speed;
		this.fuel = fuel;
		this.cnt = cnt;
	}

	@Override
	void calc() {
		
		jum = speed *0.15 + fuel* 0.35+ cnt* 0.5;
	}
	
}



public class CarMain {

	public static void main(String[] args) {
		DyCar [] cars = {
			new DySports(60, 70, 80),
			new DyTruck( 50, 90),
			new DyVan(70, 70, 80),
			new DySports(30, 70, 50),
			new DySports(70, 80, 20),
			new DyVan(40, 40, 60),
			new DyTruck( 30, 30)
		};

		for (DyCar car : cars) {
			System.out.println(car);
		}
	}

}
