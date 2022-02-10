package homework;

import java.util.Calendar;

public class Diary {

	public static void main(String[] args) {
		
		for(int i = 1; i<=12; i++) {//월을 출력
			System.out.println("\t\t<"+i+"월>");
			System.out.println();
			
			Calendar today = Calendar.getInstance();
			today.set(Calendar.MONTH, i-1); //특정 달로 고정하는 과정 ex)1월
			
			int last = today.getActualMaximum(Calendar.DATE);
			today.set(Calendar.DATE, 1); //위에서 얻은달의 일(date)을 1로 고정하는 과정
			
			int first = today.get(Calendar.DAY_OF_WEEK); //위에서 얻은달의 1일의 요일의 번호
														//ex)22년1월1일은 토요일이다=>7
			for (int j = 1; j < first; j++) { //위에서 받은 first수 만큼 해당 달의 첫째요일까지 띄어주는것 
				System.out.print("\t");		//ex)1월->토요일(7)이니 6칸 띄어준다
			}
			
			for(int j=1; j<=last; j++) {//22년 1월은 31일까지
				today.set(Calendar.DATE, j); //1일로 다시 고정
				System.out.print(j+ "\t");
				
				if(today.get(Calendar.DAY_OF_WEEK)==7) {//토요일이 되면 줄바꿈
					System.out.println();
				}
			}System.out.println("\n");
		}
	}
}