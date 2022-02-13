/*자동차 성능 테스트 하세요

자동차 클래스로 성능확인 가능할 것
차종 에 따른 연산 식 다르게 할 것

<차종>
스포츠카 : 속도 50, 연비 20, 디자인 30
트럭 : 연비 60, 적재량 40
승합차 : 속도 15, 연비 35, 탑승인원 50

으로 각 성능점수를 계산토록 할 것
*/
package homework;

abstract class common{
	
	String name;
	int speed, fuel;
	
	abstract void score();
}

class SportCar extends common{
	
	int design;
	public SportCar(int speed, int fuel, int design) {
		this.name = "스포츠카"; 
		this.speed=speed;
		this.fuel=fuel;
		this.design = design;
	}
	@Override
	void score() {
		System.out.println(name+"-> 속도 : "+speed+"점, 연비 : " +fuel+"점, 디자인 : "+ design+"점");
	}

}

class Truck extends common{
	int lug;
	public Truck(int fuel, int lug) {
		this.name = "트럭";
		this.fuel=fuel;
		this.lug=lug;
	}
	@Override
	void score() {
		System.out.println(name+"-> 연비 : "+fuel+"점, 적재량 : "+ lug+"점");
	}

}

class Van extends common{
	int passenger;
	public Van(int speed, int fuel, int passenger) {
		this.name = "승합차";
		this.speed=speed;
		this.fuel=fuel;
		this.passenger=passenger;
		
	}
	@Override
	void score() {
		System.out.println(name+"-> 속도 : "+speed+"점, 연비 : " +fuel+"점, 탑승인원 : "+ passenger+"점");
	}

}

public class CarScoreChart{

	public static void main(String[] args) {
		common [] car = {
				new SportCar(50,20,30),
				new Truck(60, 40),
				new Van(15,35,50)
		};
		
		for(common sc : car) {
			sc.score();
		}
	}
}