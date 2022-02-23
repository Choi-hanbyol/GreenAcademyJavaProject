package thread_p;

public class DaemonMain {
	
	class Save extends Thread{
		@Override
		public void run() {
			
			for (int i = 0; i < 10; i++) {
				System.out.println("저장"+i);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	class DMSave extends Thread{
		@Override
		public void run() {
			
			while(true) {
				System.out.println("<<<자동저장>>>");
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public DaemonMain() {
		DMSave dms = new DMSave();
		dms.setDaemon(true);
		dms.start();
//		dms.setDaemon(true); 스타트전에 선언해야 오류가 안남
		new Save().start();
	}

	public static void main(String[] args) {
		
		new DaemonMain();

	}

}
