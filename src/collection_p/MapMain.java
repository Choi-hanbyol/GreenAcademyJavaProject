package collection_p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {
		Map mm1 = new HashMap();
		
		mm1.put("조류", "독수리");
		mm1.put("포유류", "호랑이");
		mm1.put("파충류", "악어");
		mm1.put("양서류", "개구리");
		mm1.put("어류", "상어");
		System.out.println(mm1);
		System.out.println("===========================================================");
		mm1.put("포유류", "곰");
		mm1.put("양서류", "곰");
		mm1.put("조류", 1234);
		mm1.put(true,new ArrayList());
		System.out.println(mm1);
		System.out.println("size() : "+mm1.size());
		System.out.println("get(\"어류\") : "+mm1.get("어류"));
		mm1.remove("파충류");
		System.out.println("remove(\"파충류\") : "+mm1);
		mm1.remove("주류");
		System.out.println("remove(\"주류\") : "+mm1);
		System.out.println(mm1.containsKey("포유류"));
		System.out.println(mm1.containsKey("유류"));
		System.out.println(mm1.containsValue(1234));
		System.out.println(mm1.containsValue(5678));
		
		System.out.println("===========================================================");
		Set ss1 = mm1.keySet();
		System.out.println(ss1);
		Collection vv = mm1.values();
		System.out.println(vv);
		
		System.out.println("===========================================================");
		Set ss2 = mm1.entrySet();
		System.out.println(ss2);
		
		System.out.println("===========================================================");
		for(Object obj : ss1) {
			System.out.println(obj);
		}
		
		System.out.println("===========================================================");
		for(Object obj : vv) {
			System.out.println(obj);
		}
		
		System.out.println("===========================================================");
		for(Object obj : ss2) {
			Map.Entry me = (Map.Entry)obj;
			System.out.println(me.getKey()+"=>"+me.getValue());
			//System.out.println(obj);
		}
		
		System.out.println("===========================================================");
		System.out.println("isEmpty : "+mm1.isEmpty());
		mm1.clear();
		System.out.println("clear : "+mm1);
		System.out.println("isEmpty : "+mm1.isEmpty());
	}
}