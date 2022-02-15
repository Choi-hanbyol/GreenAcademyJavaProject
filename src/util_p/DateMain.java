package util_p;

import java.util.Calendar;
import java.util.Date;

public class DateMain {

	public static void main(String[] args) {
		Date today = new Date();
		Date today1 = new Date(2022-1900,3-1,20);
		Date today2 = new Date(2022-1900,3-1,20,11,22,33);
		Date today3 = new Date(2022-1900,25-1,98,100,-4000,33);
		Date today4 = new Date(0);
		Date today5 = new Date("20 Mar 1998 13:23:45");
		
		
		System.out.println(today);
		System.out.println(today1);
		System.out.println(today2);
		System.out.println(today3);
		System.out.println(today4);
		System.out.println(today5);
		System.out.println("============================");
		today.setYear(2002-1900);
		System.out.println(today);
		
		today.setMonth(8-1);
		System.out.println(today);
		
		today.setDate(7);
		System.out.println(today);
		
		today.setHours(19);
		System.out.println(today);
		
		today.setMinutes(31);
		System.out.println(today);
		
		today.setSeconds(24);
		System.out.println(today);
		
		today.setTime(3000);
		System.out.println(today);
		System.out.println("============================");
		System.out.println(today2.getYear()+1900);
		System.out.println(today2.getMonth()+1);
		System.out.println(today2.getDate());
		System.out.println(today2.getDay());
		System.out.println(today2.getHours());
		System.out.println(today2.getMinutes());
		System.out.println(today2.getSeconds());
		System.out.println(today2.getTime());
		System.out.println("============================");
		System.out.println(today2.before(today));
		System.out.println(today2.after(today));
		System.out.println("============================");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(0);
		System.out.println(c1.before(c2));
		System.out.println(c1.after(c2));
		
		long lo = today2.getTime();
		c1.setTimeInMillis(lo);
		
		CalendarMain.calToStr(c1);
		
		lo=c2.getTimeInMillis();
		today.setTime(lo);
		System.out.println(today);
		
		c1.setTime(today3);
		CalendarMain.calToStr(c1);
		today5 = c2.getTime();
		System.out.println(today5);
		
	}
}
