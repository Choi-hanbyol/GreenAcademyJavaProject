//지정한 폴더의 파일을 각각 종류별로 지정 폴더에 저장하시오
//하위 폴더까지 검색하세요
//같은 파일명인 경우 중복 처리 하세요
//이미지 : bmp, jpg, gif, png , jpeg
//음악 : mp3, wma, wav
//문서 :doc, hwp, ppt, xls, pptx, xlsx, docx
//기타 : 위의 분류 이외
//확장자의 대소문자 구분하지 않음
package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

public class FileSortMain {

	public static void main(String[] args) throws Exception {

		new File("zzz2/image").mkdirs();
		new File("zzz2/image2").mkdirs();
		new File("zzz2/music").mkdirs();
		new File("zzz2/document").mkdirs();
		new File("zzz2/etc").mkdirs();
		
		for (File ff : new File("zzz").listFiles()) {
			//이미지파일
			if(ff.isFile() && Pattern.matches(".*[.](jpg|png|gif|bmp|jpeg)", ff.getName().toLowerCase())) {
				FileInputStream fis = new FileInputStream(ff);
				byte [] arr = new byte[(int)ff.length()];
				FileOutputStream fos = new FileOutputStream("zzz2/image/"+ff.getName());
				
				fis.read(arr);
				fos.write(arr);
				
				fos.close();
				fis.close();
			}
			//음악파일
			else if(ff.isFile() && Pattern.matches(".*[.](mp3|wma|wav)", ff.getName().toLowerCase())) {
				FileInputStream fis = new FileInputStream(ff);
				byte [] arr = new byte[(int)ff.length()];
				FileOutputStream fos = new FileOutputStream("zzz2/music/"+ff.getName());
				
				fis.read(arr);
				fos.write(arr);
				
				fos.close();
				fis.close();
				
			}
			//문서파일
			else if(ff.isFile() && Pattern.matches(".*[.](doc|hwp|ppt|xls|pptx|xlsx|docx)", ff.getName().toLowerCase())) {
				FileInputStream fis = new FileInputStream(ff);
				byte [] arr = new byte[(int)ff.length()];
				FileOutputStream fos = new FileOutputStream("zzz2/document/"+ff.getName());
				
				fis.read(arr);
				fos.write(arr);
				
				fos.close();
				fis.close();
				
			}
			//그외 파일
			else {
				FileInputStream fis = new FileInputStream(ff);
				byte [] arr = new byte[(int)ff.length()];
				FileOutputStream fos = new FileOutputStream("zzz2/etc/"+ff.getName());
				
				fis.read(arr);
				fos.write(arr);
				
				fos.close();
				fis.close();
			}
			
		}

	}

}
