package io_p;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DirectoryCopyMain {

	public static void main(String[] args) throws Exception {

		
		File [] arr = new File("fff").listFiles();
		
		new File("neo").mkdir();
		
		for(File ff : arr) {
			if(ff.isFile()) {
				FileInputStream fis = new FileInputStream(ff);
				byte [] buf = new byte[(int)ff.length()];
			
				FileOutputStream fos = new FileOutputStream("neo/"+ff.getName());
			
				fis.read(buf);
			
				fos.write(buf);
			
				fos.close();
				fis.close();
			}
			
		}
	}

}
/*fff폴더에 있는 파일 중 이미지 파일만 picture폴더에 저장
이미지 파일 jpg,png,gif,bmp,jpeg  ---> 대소문자구분하지 않음
picture 자동생성*/
