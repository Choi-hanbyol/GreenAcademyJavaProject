package io_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BufferedLoginMain {
	
	ArrayList<BufMem> members(){
		
		ArrayList<BufMem> res = new ArrayList<BufferedLoginMain.BufMem>();
		try {
			FileReader fr = new FileReader("fff/bufMem.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line=br.readLine())!=null) {
				res.add(new BufMem(line));
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
		
	}
	
	boolean idDup(String id) {
		ArrayList<BufMem> mems = members();
		boolean res = false;
		
		for (BufMem mm : mems) {
			if(res=mm.id.equals(id)) {
				break;
			}
		}
		
		return res;
		
	}
	
	
	
	class BufMem{
		String id, pw, name;
		public BufMem(String str) {
			super();
			String [] arr = str.split(",");
			this.id = arr[0];
			this.pw = arr[1];
			this.name = arr[2];
		}
		
		public BufMem() {
			// TODO Auto-generated constructor stub
		}
		
		boolean idInput(String id) {
			boolean res = idDup(id);
			
			if(!res) {
				this.id = id;
			}
			
			return res;
		}

		@Override
		public String toString() {
			return id + "," + pw + "," + name + "\n";
		}
		
		
		
	}
	boolean fileRecord(BufMem mem) {
		boolean res = idDup(mem.id);
		if(!res) {
			try {
				FileWriter fw = new FileWriter("fff/bufMem.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(mem.toString());
				
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return res;
	}
	
	//회원가입
	void memJoin() {
		
		
		while(true) {
			BufMem mem = new BufMem();
			try {
				System.out.println("[[[회원가입]]]");
				System.out.print("id:");
				String id = sc.next();
				if(mem.idInput(id)) {
					throw new Exception("id 중복");
				}
				
				System.out.print("pw:");
				String pw = sc.next();
				if(pw.trim().equals("")) {
					throw new Exception("pw 유효성 실패");
				}
				mem.pw = pw;
				
				System.out.print("이름:");
				String name = sc.next();
				if(name.trim().equals("")) {
					throw new Exception("이름 유효성 실패");
				}
				mem.name = name;
				
				if(fileRecord(mem)) {
					throw new Exception("회원가입 기록 실패");
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("회원가입 종료");
	}
	
	//로그인
	void memLogin() {
		while(true) {
			try {
				ArrayList<BufMem> mems =  members();
				
				System.out.println("[[[로그인]]]");
				System.out.print("id:");
				String ttt = sc.next();
				
				BufMem mem = null;
				for (BufMem mm : mems) {
					if(mm.id.equals(ttt)) {
						mem = mm;
						break;
					}
				}
				
				if(mem==null) {
					throw new Exception("id 에러");
				}
				System.out.print("pw:");
				ttt = sc.next();
				
				if(!mem.pw.equals(ttt)) {
					throw new Exception("pw 에러");
				}
				System.out.println(mem.name+" 로그인 성공");
				break;
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
		}
		System.out.println("로그인 종료");
		
	}
	
	Scanner sc = new Scanner(System.in);
	public BufferedLoginMain() {

		BIG:while(true) {
			System.out.println("1.회원가입, 2.로그인, 0.종료");
			System.out.print("선택:");
			
			switch(sc.nextInt())
			{
				case 0:
					break BIG;
				case 1:
					memJoin();
					break;
				case 2:
					memLogin();
					break;
			}
			
		}
		
		System.out.println("프로그램 종료");
		
	}
	

	public static void main(String[] args) {
		new BufferedLoginMain();

	}

}
