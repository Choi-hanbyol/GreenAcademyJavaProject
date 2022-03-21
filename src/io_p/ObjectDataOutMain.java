package io_p;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectDataOutMain {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("fff/ooData.zzz");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new ObjectData("Chatting","aaa","bbb","너는 이름이 뭐니?"));
		oos.writeObject(new ObjectData("Game","aaa","bbb","aaa 뒤로 3칸 이동"));
		oos.writeObject(new ObjectData("Logout","aaa","all","aaa 로그아웃"));
		
		oos.close();
		fos.close();
	}

}
