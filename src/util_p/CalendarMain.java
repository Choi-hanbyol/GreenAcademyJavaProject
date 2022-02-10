package util_p;

import java.util.Calendar;

public class CalendarMain {

	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.println(today.get(1));
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH)+1);
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.DAY_OF_YEAR));
		System.out.println(today.get(Calendar.DAY_OF_WEEK)); //일월화수목금토 = 1234567
		
		System.out.println("======================");
		
		System.out.println(today.get(Calendar.WEEK_OF_YEAR));
		System.out.println(today.get(Calendar.WEEK_OF_MONTH));
		
		System.out.println("======================");
		
		System.out.println(today.get(Calendar.AM_PM)); //0:오전 1:오후
		System.out.println(today.get(Calendar.HOUR));
		System.out.println(today.get(Calendar.HOUR_OF_DAY)); //24시간
		System.out.println(today.get(Calendar.MINUTE));
		System.out.println(today.get(Calendar.SECOND));
		System.out.println(today.get(Calendar.MILLISECOND)); //천분의일초
		
		System.out.println("=========예제===========");
		//출력방식 : 1984 년 3월 20일 (수요일) 13:34:56.789
		String [] day = {"일","월","화","수","목","금","토"};
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String day2 = day[today.get(Calendar.DAY_OF_WEEK)-1];
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		int msec = today.get(Calendar.MILLISECOND);
		
		System.out.println(year+ "년 " +month+ "월 " +date+ "일 " + "("+day2+ "요일) " +hour+ ":" +min+ ":" +sec+ "." +msec);
		
		System.out.println("======예제강사님풀이========");
		
		calToStr(today); //현재
		
		String[] str =  "일,월,화,수,목,금,토".split(",") ;
		
		System.out.println("======새로운 예시들========");
		today.set(Calendar.MONTH,1-1);
		calToStr(today);
		today.getActualMaximum(Calendar.DATE);
		calToStr(today);
		today.set(Calendar.DATE, 1);
		calToStr(today);
		today.get(Calendar.DAY_OF_WEEK);
		calToStr(today);
		today.set(Calendar.YEAR, 2002);
		calToStr(today);
		today.set(2002,6-1,3); //년,월,일,시,분,초
		calToStr(today);
		today.set(2002,6-1,3,9,35);
		calToStr(today);
		today.set(1985,3-1,20,14,23,45);
		calToStr(today);
		
		System.out.println("===안에 조건을 이상하게 했을때===");
		today.set(Calendar.MONTH, -5-1);
		calToStr(today);
		today.set(2002,-7-1,500,-50,-200);
		calToStr(today);
		
		today.add(Calendar.MONTH,2);
		calToStr(today);
		
		
		System.out.println(today.getActualMaximum(Calendar.YEAR));
		System.out.println(today.getActualMaximum(Calendar.MONTH));
		System.out.println(today.getActualMaximum(Calendar.DATE));
		today.set(Calendar.MONTH, 2-1);
		calToStr(today);
		
		System.out.println("getActualMaximum");
		System.out.println(today.getActualMaximum(Calendar.DATE));
		
		System.out.println(today.getTimeInMillis());
		System.out.println(today.getTimeInMillis()/1000/60/60/24/365 +1970);
		
		today.setTimeInMillis(0);
		calToStr(today);
	}
	static void calToStr(Calendar day) {
		String res = day.get(Calendar.YEAR) +"년";
		res += day.get(Calendar.MONTH)+1 +"월";
		res += day.get(Calendar.DATE) +"일 (";
		res += " 일월화수목금토".charAt(day.get(Calendar.DAY_OF_WEEK)) +"요일)";
		res += day.get(Calendar.HOUR_OF_DAY) +":";
		res += day.get(Calendar.MINUTE) +":";
		res += day.get(Calendar.SECOND) +".";
		res += day.get(Calendar.MILLISECOND);
		
		System.out.println(res);
	}

}
