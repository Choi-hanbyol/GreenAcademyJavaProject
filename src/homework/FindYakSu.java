//다음 숫자들의 각 약수들의 갯수를 구하세요 단 0,1 제외
package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class FindYakSu {

	public static void main(String[] args) {
		int [] nums = {22,4,56,7,8,90,12,3,45,6,22,31,45,63,86,57};
		ArrayList arr = new ArrayList();
		
		for(int i=0; i<nums.length; i++) {//->nums[]를 돌리는 for문(22,4,56,....)
			for(int j=2; j<nums[i]; j++) {//->나누는 수를 돌리는 for문(2~nums[i])
				if(nums[i]%j==0) {
					arr.add(j);
				}
			}

		}
	
		HashMap map = new HashMap();
		
		for(Object i : arr) { //->약수들의 갯수를 저장하는 for문
			int res = 1;
			
			if(map.containsKey(i)) {
				res+=(int)map.get(i);//->약수들 갯수 저장
			}
			
			map.put(i, res);
			//System.out.println("i : "+i+" / res : "+res); -->i랑 res값 확인해볼려고 한것
		}
		System.out.println("===========약수들의 갯수===========");
		for (Object oo : map.entrySet()) {
			System.out.println(oo);
		}
	}

}
