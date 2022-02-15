package util_p;
import java.util.Date;

public class DateDiaryMain {

	public static void main(String[] args) {
		Date today = new Date();
		today.setMonth(today.getMonth()+1);
		today.setDate(0);
		int last = today.getDate();
		today.setDate(1);
		System.out.println(today);
		
		for(int i = 0; i<today.getDay(); i++) {
			System.out.print("\t");
		}
		
		for(int i = 1; i<=last; i++) {
			today.setDate(i);
			System.out.print(i+"\t");
			
			if(today.getDay()==6) {
				System.out.println();
			}
		}
	}

}
