package text_p;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class DecimalMain {

	public static void main(String[] args) throws ParseException {
		DecimalFormat df = new DecimalFormat();
		double dd = (double)df.parse("123.456");
		
		System.out.println(dd);
		
		String ttt = df.format(44556677123.456789);
		System.out.println(ttt);
		
		df = new DecimalFormat("0");
		ttt=df.format(44556677123.456789);
		System.out.println(ttt);;
		
		double [] ddArr = {
				1234, -1234,
				123456.11223344, -123456.11223344,
				987654.99668877, -987654.99668877,
				.1234567, -.1234567,
				.987654, -.987654, 0
		};
		
		String [] ppArr= {
				"0","00000000", "#", "#########",
				"#####00000", ".000", ".00000000000000",".####################",
				"#.000", "#,###", "#,##" ,"#@###", "안녕0000",
				"#,##0%",
				"#,##0;00000000", "양수#,##0.00;음수00000000000",
				"▲#,##0.00;▼#"
				//"#0#0#0#0#0#0#0#0", "00000#####" -> 안됨
		};
		for(String pp : ppArr) {
			System.out.println("pp >>> "+pp);
			df = new DecimalFormat(pp);
			
			for(double d : ddArr) {
				System.out.println(d+" -> "+df.format(d));
			}
			System.out.println("==============================================");
			
		}
	}

}
