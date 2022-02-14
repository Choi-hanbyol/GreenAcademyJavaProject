package util_p;

import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
		
		Random rr = new Random();
		
		System.out.println(rr.nextBoolean());
		System.out.println(rr.nextDouble());
		//System.out.println(rr.nextBytes(new byte[] {11,22,33}));
		//System.out.println(rr.nextChar());
		//System.out.println(rr.nextShort());
		System.out.println(rr.nextFloat());
		System.out.println(rr.nextInt());
		System.out.println(rr.nextLong());
		
		System.out.println(rr.nextInt(3)); //0~2까지 랜덤
		
		System.out.println("seed===================");
		
		Random r1 = new Random();
		Random r2 = new Random(234);
		Random r3 = new Random(234);
		
		System.out.println("r1================");
		for(int i = 0; i < 5; i++) {
			System.out.println(r1.nextInt());
		}
		System.out.println("r2================");
		for(int i = 0; i < 5; i++) {
			System.out.println(r2.nextInt());
		}
		System.out.println("r3================");
		for(int i = 0; i < 5; i++) {
			System.out.println(r3.nextInt());
		}
	}

}
