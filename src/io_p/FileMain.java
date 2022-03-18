package io_p;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileMain {

	public static void main(String[] args) throws Exception {
		
		
		File ff = new File("fff/asdf.txt");
		
		System.out.println(ff.exists()); 
		System.out.println(ff.isFile());
		System.out.println(ff.isDirectory()); //디렉토리인가?
		System.out.println(ff.isAbsolute()); //절대경로인가?
		System.out.println(ff.isHidden()); //숨긴파일인가?
		System.out.println(ff.canWrite()); //쓰기 가능한 파일인가?
		System.out.println(ff.canRead()); //읽기 가능한 파일인가?
		System.out.println(ff.canExecute()); //실행가능한 파일인가?
		System.out.println(ff.length()); //파일크기
		System.out.println("->"+ff.getName());//파일이름
		System.out.println(ff.getParent());//파일이 있는 폴더이름
		System.out.println(ff.getPath());//파일경로
		System.out.println(ff.getAbsolutePath()); //파일이있는 상세경로
		System.out.println(new Date(ff.lastModified()));//파일을 마지막으로 수정한 날짜
		
		File bb = new File("fff/qwas.txt");
//		bb.createNewFile();
//		System.out.println(bb.delete());
//		bb.renameTo(new File("dst/bnm.txt")); //옮기는역할(복사X)
		
		File dd = new File("fff/ggg/sss");
//		dd.mkdir(); //단일계층 디렉토리 생성
		dd.mkdirs(); //다중계층 디렉토리 생성
		System.out.println("=============================");
		File [] arr = new File("fff").listFiles();
		for(File f : arr) {
			System.out.println(f.getName());
		}
		
		
	}	
}