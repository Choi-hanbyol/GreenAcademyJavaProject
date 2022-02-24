package thread_p;

class Mommy{
	
	int total = 100;
	
	synchronized boolean showMeTheMoney(int money) {
		boolean res = false;
		
		if(res = total>=money) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}//class Mom

class Papa extends Thread{
	
	int FatherMoney = 0;
	Mommy mom;
	
	public Papa(String name, Mommy mom) {
		super(name);
		this.mom=mom;
	}
	
	@Override
	public void run() {
			while(mom.total>0) {
				int fmoney = (int)(Math.random()*40)+1;
				
				if(mom.showMeTheMoney(fmoney)) {
					System.out.println(getName()+" : 용돈 줘!!!");
					System.out.println("엄마 : 이 사람이!!!");
					//myMoney += money;
					mom.total+=fmoney;
					System.out.println(getName()+"가 벌어온 : "+fmoney);
					System.out.println("\t잔액 : "+mom.total);
					System.out.println();
				}
	
			}

	}
}//class Father

class SyChildren extends Thread{
	
	int myMoney = 0;
	Mommy mom;
	Papa father;
	public SyChildren(String name, Mommy mom) {
		super(name);
		this.mom=mom;
	}
	
	@Override
	public void run() {
		while(mom.total>0) {
			int money = (int)(Math.random()*40)+1;
			
			if(mom.showMeTheMoney(money)) {
				myMoney += money;
				mom.total-=money;
				System.out.println(getName()+" : "+money+"("+myMoney+")");
				System.out.println("\t잔액 : "+mom.total);
				System.out.println();
			}
		}
		if(mom.total<=30) {
			System.out.println(getName()+" : 돈벌어 올께!!");
			System.out.println("엄마 : 건강하게만 자라다오!!");
//			Father father = new Father("아빠", mom);
//			father.start();
		}
	}
}//class SyChild

public class DragonMoneyMyMain {

	public static void main(String[] args) {
		Mommy mom = new Mommy();
		SyChildren son = new SyChildren("아들", mom);
		SyChildren daugther = new SyChildren("딸", mom);
		Papa father = new Papa("아빠", mom);
		
		son.start();
		daugther.start();
		father.start();

	}

}
