package io_p;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputMain {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("fff/wsx.cde");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeBoolean(true);
		dos.writeChar('a');
		dos.writeByte(12);
		dos.writeShort(321456);
		dos.writeInt(789456);
		dos.writeLong(741258963L);
		dos.writeFloat(123.456F);
		dos.writeDouble(789.456);
		dos.writeUTF("송지은이 static 강의한다 홍홍홍");
		
		
		dos.close();
		fos.close();
	}

}
