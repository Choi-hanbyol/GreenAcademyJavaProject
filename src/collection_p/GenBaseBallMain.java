package collection_p;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class GenBaseBall implements Comparable<GenBaseBall>{
	String team;
	
	int no, cnt=1;
	
	public GenBaseBall(String ttt) {

		HashMap<Character , String>map = new HashMap();
		map.put('h', "HOME");
		map.put('a', "AWAY");
		this.team = map.get(ttt.charAt(0));
		this.no = Integer.parseInt(ttt.substring(1));
	}

	@Override
	public int compareTo(GenBaseBall o) {
		int res = no-o.no;
		if(res==0) {
			o.cnt++;
			//res = 1;
		}
		return res;
	}

	@Override
	public String toString() {
		return team + "\t" + no + " : " + cnt;
	}
	
	
}

public class GenBaseBallMain {

	public static void main(String[] args) {

		String [] arr = { "h22","h23","h11","a3","a7","a22","h23","a11","h5",
				           "a3","h8","a11","h22","h23"};
		
		TreeMap<String, TreeSet<GenBaseBall>> map = new TreeMap<String, TreeSet<GenBaseBall>>();
		
		for (String str : arr) {
			GenBaseBall gbb = new GenBaseBall(str);
			if(!map.containsKey(gbb.team)) {
				map.put(gbb.team, new TreeSet<GenBaseBall>());
				gbb.cnt=0;
			}
			map.get(gbb.team).add(gbb);
		}
		
		for (Map.Entry<String, TreeSet<GenBaseBall>> me : map.entrySet()) {
			System.out.println(me.getKey()+">>>>>>>>>>");
			for (GenBaseBall gbb : me.getValue()) {
				System.out.println(gbb);
			}
		}

		/// 출력내용

		//  h : 홈팀,  a:상대팀

		//  각 팀별로 선수가 안타를 친 갯수를 출력하세요

		//  단 선수번호는 오름차순으로 정렬

	}

}
