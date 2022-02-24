package thread_p;

class Mom{
	int total = 100;
	
	synchronized boolean showMeTheMoney(String name, int money) {
		boolean res = false;
		
		if(name.equals("아빠")) {
			System.out.println("이사람이!!!");
			return false;
		}
		
		if(res =  total>=money ) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	synchronized boolean missionComplete(String name) {
		if(!name.equals("아빠")) {
			System.out.println("건강하게만 자라다오");
			return false;
		}
		return true;
	}
}

class SyChild extends Thread{
	int myMoney = 0;
	Mom mom;
	public SyChild(String name, Mom mom) {
		super(name);
		this.mom = mom;
	}
	
	@Override
	public void run() {
		
		while(mom.total>0) {
			
			int no = (int)(Math.random()*10);
			
			switch(no) {
			
			case 0:
				int money = (int)(Math.random()*50)+30;
				
				if(mom.missionComplete(getName())) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					myMoney += money;
					mom.total += money;
					System.out.println(getName()+":"+money+"("+myMoney+")");
					System.out.println("\t잔액:"+mom.total);
				}
			
			break;
			default:
				money = (int)(Math.random()*40)+1;
				
				if(mom.showMeTheMoney(getName(),money)) {
					myMoney += money;
					mom.total -= money;
					System.out.println(getName()+":"+money+"("+myMoney+")");
					System.out.println("\t잔액:"+mom.total);
				}
			
			}
		}
	}
}

class SCV extends Thread{
	int myMoney = 0;
	Mom mom;
	public SCV(Mom mom) {
		super("아빠");
		this.mom = mom;
	}
	
	@Override
	public void run() {
		
		while(mom.total>0) {
			
			
			int no = (int)(Math.random()*10);
			
			switch(no) {
			
			case 0:
				int money = (int)(Math.random()*40)+1;
				
				if(mom.showMeTheMoney(getName(),money)) {
					myMoney += money;
					mom.total -= money;
					System.out.println(getName()+":"+money+"("+myMoney+")");
					System.out.println("\t잔액:"+mom.total);
				}
				
				break;
			default:
			
				money = (int)(Math.random()*100)+30;
				
				if(mom.missionComplete(getName())) {
					
					
					myMoney += money;
					mom.total += money;
					System.out.println(getName()+":"+money+"("+myMoney+")");
					System.out.println("\t잔액:"+mom.total);
				}
			}
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}


public class DragonMoneyMain {

	public static void main(String[] args) {
		Mom mom = new Mom();
		SyChild son = new SyChild("아들", mom);
		SyChild daughter = new SyChild("딸", mom);
		SCV scv = new SCV(mom);
		
		son.start();
		daughter.start();
		scv.start();
	}

}
