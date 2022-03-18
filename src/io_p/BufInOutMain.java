package io_p;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class BufInOutMain {

	public static void main(String[] args) throws Exception {
		byte [] arr  = {10,127,-128,-126,-2,-1,0,40,50,60,11,22,33};
		byte [] buf = new byte[5];
		
		byte [] res;
		
		ByteArrayInputStream bis = new ByteArrayInputStream(arr);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		while(bis.available()>0) {
			
			int cnt = bis.read(buf);
			bos.write(buf,0,cnt);
			System.out.println(cnt+Arrays.toString(buf));
		}
		
		res = bos.toByteArray();
		
		bis.close();
		bos.close();
		
		System.out.println(Arrays.toString(res));
	}

}
