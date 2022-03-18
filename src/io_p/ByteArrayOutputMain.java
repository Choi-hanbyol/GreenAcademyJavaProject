package io_p;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayOutputMain {

	public static void main(String[] args) {
		
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			bos.write(126); //126
			bos.write(127); //127
			bos.write(129); //-127
			bos.write(130); //-126
			bos.write(254); //-2
			bos.write(255); //-1
			bos.write(256); //0
			bos.write(0); //0
			bos.write(-1); //-1
			bos.write(-2); //-2
			bos.write(-10); //-10
			
			byte [] arr = bos.toByteArray();
			
			bos.close();
			
			System.out.println(Arrays.toString(arr));
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
