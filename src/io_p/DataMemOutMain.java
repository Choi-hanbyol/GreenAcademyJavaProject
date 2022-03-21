package io_p;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataMemOutMain {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("fff/vfr.tgb");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("n_123.456");
		dos.writeUTF("b_true");
		dos.writeUTF("msg_아기상어");
		dos.writeUTF("arr_10,20,30,40");
		

		dos.close();
		fos.close();
	}

}
