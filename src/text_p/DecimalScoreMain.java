//	점수가 70점 이상이면 ▲, 미만이면 ▼ 로 표시해 주세요
//	decimalFormat을 활용할 것
//	단, if, switch, 3항연산자 등 조건문을 사용하지 말것
package text_p;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class DecimalScoreMain {

	public static void main(String[] args) {
		HashMap jj = new HashMap();
		DecimalFormat df = new DecimalFormat();

		int [] jum = {67,78,89,98,76,54,78,77,90,56};
		df = new DecimalFormat("▲#;▼#");
		for(int i : jum) {
			System.out.println(i+" -> "+df.format(i-70).charAt(0));
		}
		

	}

}