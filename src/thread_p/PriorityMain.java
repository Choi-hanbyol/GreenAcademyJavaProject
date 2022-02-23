package thread_p;

public class PriorityMain {
	
	static class PriTh extends Thread{
		public PriTh(String nn) {
			super(nn);
		}
		
		@Override
		public void run() {
			
			for (int i = 0; i <300; i++) {
				System.out.print(getName());
				
			}
		}
	}
	
	public static void main(String[] args) {
		PriTh th1 = new PriTh("+");
		PriTh th2 = new PriTh("&");
		PriTh th3 = new PriTh("!");
		
		th1.setPriority(1);
		th2.setPriority(5);
		th3.setPriority(10);
		
		System.out.println(th1.getPriority());
		System.out.println(th2.getPriority());
		System.out.println(th3.getPriority());

		th1.start();
		th2.start();
		th3.start();
		
	}

}