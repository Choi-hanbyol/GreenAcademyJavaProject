package homework;


class StaticDragon {
	static int mom = 100;
	
	String name;
	int myMoney = 0;
	
	public StaticDragon(String name) {
		this.name = name;
	}
	
	void showMeTheMoney(int money) {
		mom -= money;
		myMoney += money;
		
		System.out.println(name+" : "+money+"("+myMoney+")");
		System.out.println("\t잔액 : "+mom);
	}
	
	void getMoney(int money) {
		
		if(name.equals("아빠")) {
			mom += money;
			System.out.println(name+" : "+money+"을 벌어 왔습니다.");
			System.out.println("\t잔액 : "+mom);
		}
		else {
			System.out.println(name+" 나가서 돈"+"("+money+")"+"벌어올께!!");
			System.out.println("부모님 : 건강하게만 자라주렴");
			System.out.println("\t잔액 : "+mom);
		}
		
	}
}

public class StaticDragonMoney {

	public static void main(String[] args) {
		StaticDragon son = new StaticDragon("아들");
		StaticDragon daughter = new StaticDragon("딸");
		StaticDragon father = new StaticDragon("아빠");
		
		son.showMeTheMoney(12);
		daughter.showMeTheMoney(9);
		daughter.showMeTheMoney(15);
		son.showMeTheMoney(11);
		father.getMoney(20);
		son.getMoney(11);
		father.getMoney(15);
		daughter.getMoney(8);
	}

}
