package collection_p;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class MapCom implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		int me = (int)o1;
		int you = (int)o2;
		return you-me;
		//return 1; -> get() 호출시 null을 유발
	}
}
public class TreeMapMain {

	public static void main(String[] args) {
		HashMap  mm1 = new HashMap(); //자기멋대로 정렬해서 입력
		LinkedHashMap mm2 = new LinkedHashMap(); //선언한 그대로 입력
		TreeMap mm3 = new TreeMap(new MapCom()); // 내림차순으로 정렬해서 입력
		
		int [] arr = {11,33,44,55,22,33,44,88,66,77,22,33,55};
		
		for(int i : arr) {
			mm1.put(i, "아기상어");
			mm2.put(i, "아기상어");
			mm3.put(i, "아기상어");
			
		}
		System.out.println(mm1);
		System.out.println(mm2);
		System.out.println(mm3);
		
		System.out.println(mm1.get(44));
		System.out.println(mm2.get(44));
		System.out.println(mm3.get(44));
		
/*		반, 성별, 이름, 총점, 점수, 등급(수우미양가->점수기준)
		반 > 성별 > 등수
		인덱스 확인
		
		TreeMap
	     k						v	     				
	     반					  TreeMap
	     					k		v
	     					성별		TreeSet
	     							학생인스턴스
		
		맵1(반)
		 key                   value
		 1          		  TreeMap
		 					key     value
		 					 남	    TreeSet->학생들
		 					 여
*/		
	}

}
