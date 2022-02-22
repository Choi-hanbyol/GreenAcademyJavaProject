package collection_p;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class MapNumMain {

	public static void main(String[] args) {
		//다음 숫자들의 각 약수들의 갯수를 구하세요 단 0,1 제외 

		int [] nums = {22,4,56,7,8,90,12,3,45,6,22,31,45,63,86,57};
		
		HashMap map = new HashMap();
		
		for (int i : nums) {
			
			for (int j = 2; j < i; j++) {
				
				if(i%j==0) {
					
					int cnt = 1;
					
					if(map.containsKey(j)) {
						
						cnt+=(int)map.get(j);
						
					}
					map.put(j, cnt);
				}
			}	
		}
		//Set kk = new TreeSet( map.keySet());
		
		//System.out.println(kk);
		System.out.println("==========약수들의 갯수==========");
		for (Object k : new TreeSet(map.keySet())) {
			System.out.println(k+" : "+map.get(k));
		}
	}
}