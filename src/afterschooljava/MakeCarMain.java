package afterschooljava;

class MakeCar {
//	int accel;
//	int window;
//	int handle;
	String engine;
	String key;
	
	public void go(int accel) { //가속
		if(accel>0) {
			System.out.println("차가 가속합니다.");
		}
	}
	
	public void breakdown(int accel) { //감속
		if(accel<0) {
			System.out.println("차가 감속합니다.");
		}
	}
	
	public void turnOnOff(String key) { //시동On/Off
		if(key.equals("in")) {
			engine = "on";
			System.out.println("엔진이 "+engine+" 됐습니다.");
		}
		else if(key=="out") {
			engine = "off";
			System.out.println("엔진이 "+engine+" 됐습니다.");
		}
		else {
			System.out.println("키를 꼽아주세요.");
		}
	}
	
	public void handling(int handle) {// -  0   +
									  //좌  직진  우
		if(handle<0) {
			System.out.println("좌회전 합니다");
		}
		else if(handle>0) {
			System.out.println("우회전 합니다.");
		}
		else {
			System.out.println("직진 합니다.");
		}
	}
	
	public void windowOpenClose(int window) { //창문개폐
		if(window==0) {
			System.out.println("창문이 닫힙니다.");
		}
		else if(window==1) {
			System.out.println("창문이 열립니다.");
		}
	}
	
}

public class MakeCarMain {

	public static void main(String[] args) {
		MakeCar mycar = new MakeCar();
		mycar.go(1); //1이면 가속
		mycar.breakdown(-1); //음수면 감속
		mycar.turnOnOff("in"); //<in 입력 = 시동on> <out 입력 = 시동off>
		mycar.handling(0); //음수면 좌회전, 양수면 우회전, 0이면 직진
		mycar.windowOpenClose(0); //0이면 창문닫힘, 1이면 창문열림
		}

}
