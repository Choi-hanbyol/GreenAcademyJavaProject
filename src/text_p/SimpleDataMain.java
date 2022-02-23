package text_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDataMain {

	public static void main(String[] args) throws ParseException {
		Date today = new Date();
		
		System.out.println(today);
		
		System.out.println("===========================================");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) a HH:mm:ss.SSS");
		System.out.println(sdf.format(today));
		
		System.out.println("===========================================");
		Locale loc = new Locale("en");
		sdf = new SimpleDateFormat("yyyy-MM-dd(E) a HH:mm:ss.SSS",loc);
		System.out.println(sdf.format(today));
		
		System.out.println("===========================================");
		loc = new Locale("ko");
		sdf = new SimpleDateFormat("yyyy-MM-dd(E) a HH:mm:ss.SSS",loc);
		System.out.println(sdf.format(today));
		
		String [] ppArr = {
				"y", "yy", "yyyy",
				"M", "MM", "MMM", "MMMM",
				"d", "dd", "D", "DD", "DDD",
				"w", "ww", "W", "WW",
				"F", "E", "EEEE", "z", "Z",
				"a", "H", "HH", "h", "hh",
				"m", "mm",
				"s", "ss", "S", "SSS"
		};
		loc = new Locale("en");
		for(String pp : ppArr) {
			sdf=new SimpleDateFormat(pp,loc);
			System.out.println(pp+" > "+sdf.format(today));
		}
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		today = sdf.parse("1996-03-17 05:03:50");
		System.out.println(today);
		today = sdf.parse("1996-03-99 05:03:50");
		System.out.println(today);
		
		System.out.println("=== 89年 nov 28일 (화) 05:07:30 형태로 출력해주세요===");
		// '89年  nov 28일 (화) 05:07:30  형태로 출력해 주세요
		loc = new Locale("en");
		sdf=new SimpleDateFormat("''yy年 MMM dd일",loc);
		SimpleDateFormat sdf1 = new SimpleDateFormat();
//		System.out.println(sdf.format(today));
		
		loc = new Locale("ko");
		sdf1=new SimpleDateFormat(" (E) HH:mm:ss",loc);
		System.out.println(sdf.format(today) + sdf1.format(today));
//		밑은 강사님 풀이
		sdf = new SimpleDateFormat("''yy年 MMM dd일 (",  loc);
		String ttt = sdf.format(today);
		loc = new Locale("ko");
		sdf = new SimpleDateFormat("E) HH:mm:ss",  loc);
		ttt += sdf.format(today);
		System.out.println("강사님 풀이 : "+ttt);
	}

}
