package oops_p;

class Coffee{
	int tot, cash;
	
	Coffee(int A1, int L1, int C1, int M1){
		tot=A1+L1+C1+M1;
		cash=3000*A1 + 3300*L1 + 3500*C1 + 3500*M1;
	}
	
	@Override
	public String toString() {
		return "총 수량 : " +tot+ "\t총 금액 : "+cash;
	}
}

public class CoffeQuiz {

	public static void main(String[] args) {
		Coffee [] res = {
				new Coffee(1,2,1,1)
		};
		for(Coffee oe : res) {
			System.out.println(oe);
		}
	}

}