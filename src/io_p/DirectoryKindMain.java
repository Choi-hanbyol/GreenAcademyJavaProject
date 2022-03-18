/*
지정한 폴더의 파일을 각각 종류별로 지정 폴더에 저장하시오
하위 폴더까지 검색하세요
같은 파일명인 경우 중복 처리 하세요
이미지 : bmp, jpg, gif, png , jpeg
음악 : mp3, wma, wav
문서 :doc, hwp, ppt, xls, pptx, xlsx. docx
기타 : 위의 분류 이외
확장자의 대소문자 구분하지 않음
*/
package io_p;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DirectoryKindMain {

	void dirList(File dd) {
		//System.out.println("dirList() 시작:"+dd.getName());

		File [] arr = dd.listFiles();
		
		for (File f : arr) {  //디렉토리 안의 모든 요소를 돌린다.
			if(f.isDirectory()) {//요소가 디렉토리라면
				dirList(f);//디렉토리 또 열어
				
			}else {	//파일이라면
				fileGo(f);
			}
		}

	}
	String pre;
	HashMap<String, String> map = new HashMap<String, String>();
	byte [] buf = new byte[1024];
	
	void fileGo(File ff) {
		
		String dir = "etc";
		//이미지 : bmp, jpg, gif, png , jpeg
		//음악 : mp3, wma, wav
		//문서 :doc, hwp, ppt, xls, pptx, xlsx. docx
		//기타 : 위의 분류 이외
		
		for (Map.Entry<String, String> me: map.entrySet()) {
			//System.out.println(me.getValue());
			if(Pattern.matches(".*[.]"+me.getValue(), ff.getName().toLowerCase())) {
				dir = me.getKey();
				break;
			}
		}
		
		dir = pre+dir;
		File ppp = new File(dir);
		if(!ppp.exists()) {
			ppp.mkdirs();
		}
		//System.out.println("\tfileGo() 시작:"+ff.getName()+"=>"+dir);
		
		File dst = fileReName(dir, ff.getName());
		
		fileSave(ff, dst);
	}
	
	File fileReName(String dir, String fName) {
		File res = new File(dir+"/"+fName);
		
		int pos = fName.lastIndexOf(".");
		String domain = fName.substring(0,pos);
		String ext = fName.substring(pos);
		
		int cnt = 1;
		while(res.exists()) {
			
			res = new File(dir+"/"+domain+"_"+ cnt++ +ext);
			
			//System.out.println("존재한다 이눔아:"+res.getName());
			
		}
		
		return res;
	}
	
	void fileSave(File ori, File dst) {
		
		try {
			FileInputStream fis = new FileInputStream(ori);
			FileOutputStream fos = new FileOutputStream(dst);
			
			
			while(fis.available()>0) {
				int cnt = fis.read(buf);
				fos.write(buf,0,cnt);
			}
			
			fos.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public DirectoryKindMain(String ori, String pre) {
		
		this.pre = pre+"/";
		
		map.put("img","(bmp|jpg|gif|png|jpeg)");
		map.put("music","(mp3|wma|wav)");
		map.put("doc","(doc|hwp|ppt|xls|pptx|xlsx|docx|txt)");
		
		dirList(new File(ori));

	}
	
	public static void main(String[] args) {

		new DirectoryKindMain("ujm", "sje");

	}

}