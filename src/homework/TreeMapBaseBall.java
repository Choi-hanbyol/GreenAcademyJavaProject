package homework;

import java.util.HashMap;

public class TreeMapBaseBall {
	public static void main(String[] args) {
		HashMap Hmap = new HashMap();
		HashMap Amap = new HashMap();
//		ArrayList ar1 = new ArrayList();
//		ArrayList ar2 = new ArrayList();
		String [] arr = {"h22","h23","h11","a3","a7","a22","h23","a11","h5","a3","h8","a11","h22","h23"};
		
		for(int i =0; i<arr.length; i++) {
//			System.out.println(i+":"+arr[i]);
			String team = arr[i].substring(0,1);
			String num = arr[i].substring(1);
//			System.out.println("team["+i+"] : "+team);
//			System.out.println("num["+i+"] : "+num);
//			ar1.add(team);
//			ar2.add(num);
			if(team.equals("h")) {
				int cnt = 1;
				if(Hmap.containsKey(num)) {
					cnt+=(int)Hmap.get(num);
				}
//				System.out.println("!!!!!"+map1);
				Hmap.put(num, cnt);
//				System.out.println("num : "+num+" / cnt : "+cnt);
			}
			else {
				int cnt = 1;
				if(Amap.containsKey(num)) {
					cnt+=(int)Amap.get(num);
				}
				Amap.put(num, cnt);
//				System.out.println("num : "+num+" / cnt : "+cnt);
			}
		}
		
		System.out.println("======H팀======");
		for (Object o1 : Hmap.entrySet()) {
			System.out.println(o1);
		}
		
		System.out.println("======A팀======");
		for (Object o2 : Amap.entrySet()) {
			System.out.println(o2);
		}
//		System.out.println(ar1);
//		System.out.println(ar2);
	}
}