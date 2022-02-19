package homework;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

//mp3 노래듣기를 구현하세요
//1. 노래 정보 :  트랙번호, 노래제목, 가수
//2. 노래 리스트 -->next 에 넣기
//3. 구현내용 다음곡, 이전곡, 트랙번호
//---------------------------------------------------------------------------------------------------------
//검색기능을 구현하세요
//1. 제목으로 검색
//2. 현재 트랙 이후부터 검색
//3. 제목, 가수를 구분하여 검색
//---  동일 검색내용이 있을 경우 
//       1. 현재 트랙 바로 다음 나오는 곡으로 이동
//       2. 검색된 노래 정보를 보여주고 트랙번호를 입력하여 선택하여 이동
class StMusic{
	int no;
	String title, singer;
	public StMusic(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "[" + no + ", " + title + "(" + singer + ") ]";
	}
	
}

class StMP3{
	StMusic now = null;
	Stack back = new Stack();
	Stack next = new Stack();
	
	public StMP3(StMusic ...arr) {
		
		for (int i = arr.length-1; i>=0 ; i--) {
			arr[i].no = i+1;
			//System.out.println(i+":"+arr[i]);
			next.push(arr[i]);
		}
		
	}
	
	void ppp() {
		System.out.println("현재:"+now);
		System.out.println("이전:"+back);
		System.out.println("다음:"+next);
	}
	
	void goNext() {
		System.out.println("goNext()-------------------");
		if(next.empty()) {
			System.out.println("마지막 곡입니다.");
			return;
		}
		nextModule();
		
		ppp();
	}
	
	
	
	
	void goBack() {
		System.out.println("goBack()-------------------");
		if(back.empty()) {
			System.out.println("처음 곡입니다.");
			return;
		}
		backModule();
		
		ppp();
	}
	
	void nextModule() {
		if(now!=null) {
			back.push(now);
		}
		
		now=(StMusic)next.pop();
	}
	
	void backModule() {
		if(now!=null) {
			next.push(now);
		}
		
		now=(StMusic)back.pop();
	}
	void trackModule(int no) {
		while(now.no!=no) {
			if(now.no>no) {
				backModule();
			}
			if(now.no<no) {
				nextModule();
			}
		}
	}
	
	void goTrack(int no) {
		System.out.println("goTrack("+no+")-------------------");
		/*
		if(now.no>no) {
			while(now.no!=no) {
				backModule();
			}	
		}
		if(now.no<no) {
			while(now.no!=no) {
				nextModule();
			}
		}*/
		
		trackModule(no);
		
		ppp();
	}
	
	
	void search(int kind,String ttt) {
		String kindStr = "제목,가수".split(",")[kind];
		System.out.println("search("+kindStr+"->"+ttt+")-------------------");
		
		int nowNo = now.no;
		String pp = ".*"+ttt+".*";
		
		boolean sch = true;
		
		while(!next.empty()) {
			nextModule();
			String val = now.title;
			if(kind==1)
				val =  now.singer;
			if(Pattern.matches(pp, val)) {
				sch = false;
				break;
			}
		}
		if(sch) {
			while(!back.empty()) {
				backModule();
			}
			
			while(nowNo >= now.no) {
				
				String val = now.title;
				if(kind==1)
					val =  now.singer;
				if(Pattern.matches(pp, val)) {
					sch = false;
					break;
				}
				nextModule();
			}
		}
		if(sch) {
			System.out.println(kindStr+":\""+ttt+"\" 검색결과가 없습니다.");
		}
		ppp();
	}
	
	
	
	void search2(int kind,String ttt) {
		String kindStr = "제목,가수".split(",")[kind];
		System.out.println("search2("+kindStr+"->"+ttt+")-------------------");
		
		int nowNo = now.no;
		String pp = ".*"+ttt+".*";
		
		
		
		ArrayList res = new ArrayList();
		
		while(!next.empty()) {
			nextModule();
			String val = now.title;
			if(kind==1)
				val =  now.singer;
			if(Pattern.matches(pp, val)) {
				res.add(now);
				
			}
		}
		
		while(!back.empty()) {
				backModule();
		}
			
		while(nowNo >= now.no) {
				
			String val = now.title;
			if(kind==1)
				val =  now.singer;
			if(Pattern.matches(pp, val)) {
				res.add(now);	
			}
			nextModule();
		}
		
		if(res.size()==0) {
			System.out.println(kindStr+":\""+ttt+"\" 검색결과가 없습니다.");
		}else if(res.size()==1) {
			trackModule( ((StMusic)res.get(0)).no   );
		}else {
			System.out.println(kindStr+":\""+ttt+"\" 검색결과 =>"+res);
			System.out.print("번호 선택:");
			int no2 = sc.nextInt();
			trackModule( no2  );
		}
		ppp();
	}
	
	Scanner sc = new Scanner(System.in);
}


public class Mp3PlayerMain {

	public static void main(String[] args) {
		StMP3 mp3 = new StMP3(
				new StMusic("멸공의 횃불", "국방부"),
				new StMusic("이등병의 편지", "김광석"),
				new StMusic( "Peaches", "Justin Bieber"),
				 new StMusic("Thank U, Next", "Ariana Grande"),
				 new StMusic("에잇", "국이유"),
				 new StMusic("I hate you", "SZA"),
				 new StMusic("낙에하", "악뮤"),
				 new StMusic("문의득", "비광오")
				
			);
		
		mp3.goNext();
		mp3.goNext();
		mp3.goNext();
//		mp3.goNext();
//		mp3.goNext();
//		mp3.goNext();
//		mp3.goNext();
//		mp3.goNext();
//		mp3.goNext();
//		mp3.goBack();
//		mp3.goBack();
//		mp3.goBack();
//		mp3.goBack();
//		mp3.goBack();
//		mp3.goBack();
//		mp3.goBack();
		mp3.goBack();
		mp3.goTrack(5);
		mp3.goTrack(3);
		mp3.search(0,"에");
		mp3.search(1,"에");
		mp3.search(0,"등");
		mp3.search(0,"김지명은총각쟁이야");
		mp3.search(0,"광");
		mp3.search(1,"광");
		mp3.search(0,"의");
		mp3.search(0,"의");
		mp3.search2(0,"횃");
		mp3.search2(0,"의");
	}

}


