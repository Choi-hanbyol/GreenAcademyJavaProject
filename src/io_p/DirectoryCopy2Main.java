package io_p;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

public class DirectoryCopy2Main {

	public static void main(String[] args) throws Exception {
			////fff 폴더에 있는 파일 중  이미지 파일만   picture 폴더에 저장해 주세요
			// 이미지 파일 jpg,png,gif,bmp,jpeg  --> 대소문자 구분하지 않음
			/// picture 자동 생성
		
		new File("picture").mkdir();
		for (File ff : new File("fff").listFiles()) {
			
			if(ff.isFile() && 
					Pattern.matches(".*[.](jpg|png|gif|bmp|jpeg)", 
							ff.getName().toLowerCase())) {
				
				FileInputStream fis = new FileInputStream(ff);
				byte [] arr = new byte[(int)ff.length()];
				FileOutputStream fos = new FileOutputStream("picture/"+ff.getName());
				
				fis.read(arr);
				fos.write(arr);
				
				fos.close();
				fis.close();
			}
		}

	}

}
