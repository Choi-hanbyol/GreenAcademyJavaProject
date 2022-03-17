package io_p;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class FileExamMain {
	
	class Stud implements Comparable<Stud>{
		String name, kind;
		ArrayList<Integer> jum;
		int tot, avg;
		
		public Stud(String ttt) {
			String [] arr = ttt.split(",");
			name = arr[0];
			kind = "일반,예체능".split(",")[arr.length-4];
			
			jum = new ArrayList<Integer>();
			for (int i = 1; i < arr.length; i++) {
				jum.add(Integer.parseInt(arr[i]));
			}
			calc();
		}
		
		void calc() {
			tot = 0;
			for (Integer i : jum) {
				tot += i;
			}
			avg = tot/jum.size();
		}
		
		@Override
		public String toString() {
			return kind  + "\t" + name + "\t" + jum + "\t" + tot + "\t" + avg;
		}

		@Override
		public int compareTo(Stud o) {
			
			int res = kind.compareTo(o.kind);
			
			if(res==0)
				res = o.avg - avg;
			if(res==0)
				res = name.compareTo(o.name);
				
			return res;
		}
		
		
	}
	
	public FileExamMain() throws Exception{
		TreeSet<Stud> ts = new TreeSet<FileExamMain.Stud>();
		
		FileInputStream fis = new FileInputStream("fff/qqq3.txt");
		
		String ttt = "";
		
		int data;
		
		while((data=fis.read())!=-1) {
			ttt += (char)data;
		}
		
		fis.close();
		
		
		for (String t : ttt.split("\r\n")) {
			ts.add(new Stud(t));
				
		}
		
		for (Stud st : ts) {
			System.out.println(st);
		}
	}

	public static void main(String[] args) throws Exception  {
		new FileExamMain();
		
	}

}
