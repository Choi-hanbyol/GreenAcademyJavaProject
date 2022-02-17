package collection_p;

import java.util.Stack;

class StackBrowser{
	String now = null;
	Stack back = new Stack();
	Stack next = new Stack();
	
	void goUrl(String url) {
		System.out.println("goUrl("+url+")---------------------");
		
		if(now != null) {
			back.push(now);
		}
		now = url;
		next.clear();
		
		ppp();
	}
	
	void goBack() {
		System.out.println("goBack()---------------------");
		
		if(back.empty()) {
			System.out.println("뒤로 갈 페이지가 없습니다.");
			return;
		}
		
		next.push(now);
		now=(String)back.pop();
		
		ppp();
	}
	
	void goNext() {
		System.out.println("goNext()---------------------");
		
		if(next.empty()) {
			System.out.println("앞으로 갈 페이지가 없습니다.");
			return;
		}
		
		back.push(now);
		now=(String)next.pop();
		
		ppp();
	}
	
	void ppp() {
		System.out.println("현재 : "+now);
		System.out.println("이전 : "+back);
		System.out.println("다음 : "+next);
	}
}

public class StackBrowserMain {

	public static void main(String[] args) {
		StackBrowser sb = new StackBrowser();
		
		sb.goUrl("나베르");
		sb.goUrl("구그래");
		sb.goUrl("나테");
		sb.goBack();
		sb.goBack();
		sb.goBack();
		sb.goNext();
//		sb.goNext();
//		sb.goNext();
		sb.goUrl("줌");
		
	}
}