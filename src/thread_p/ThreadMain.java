package thread_p;

class FirstTh extends Thread{
	public FirstTh(String nn) {
		super(nn);//쓰레드 이름 대입
	}
	
	@Override
	public void run() {
		// 쓰레드의 실제 동작 메소드
		//System.out.println(getName());//쓰레드 이름 호출
		
		for (int i = 0; i <100; i++) {
			System.out.print(getName());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}

public class ThreadMain {

	public static void main(String[] args)  {

		
		FirstTh th1 = new FirstTh("+");
		FirstTh th2 = new FirstTh("&");
		FirstTh th3 = new FirstTh("!");
//		th1.run();	//단일쓰레드로 작동
//		th2.run();
//		th3.run();
		th1.start();	//멀티쓰레드
		th2.start();
		th3.start();
		
		System.out.println("Thread.activeCount():"+Thread.activeCount());
		System.out.println("Thread.currentThread():"+Thread.currentThread());
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nThread.activeCount():"+Thread.activeCount());
//		th1.start(); 종료된 쓰레드 시작불가
//		th2.start();
//		th3.start();
	}

}
