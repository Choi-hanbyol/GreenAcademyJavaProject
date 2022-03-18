package io_p;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class BufOutputMain {

	public static void main(String[] args) throws Exception {
		byte [] arr1 = {11,44,22,33,77,66,55,13,24,36,69};
		byte [] arr2 = {5,8,7,2,3,5,9};
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
//		bos.write(arr1);
		bos.write(arr1, 2, 4);
		bos.write(arr2, 3, 3);
		bos.write(arr1, 4, 5);
		
		byte [] outArr = bos.toByteArray();
		
		
		bos.close();
		
		System.out.println(Arrays.toString(outArr));
	}

}
