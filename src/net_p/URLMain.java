//https://comic.naver.com/webtoon/detail?titleId=758037&no=72&amp;weekday=mon
package net_p;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) throws Exception {
		URL uu = new URL("https://comic.naver.com/webtoon/detail?titleId=758037&no=72&amp;weekday=mon");
		
		System.out.println(uu);
		System.out.println(uu.getAuthority());
		System.out.println(uu.getDefaultPort());
		System.out.println(uu.getContent());
		System.out.println(uu.getPort());
		System.out.println(uu.getFile());
		System.out.println(uu.getHost());
		System.out.println(uu.getPath());
		System.out.println(uu.getQuery());
		System.out.println(uu.getProtocol());
		System.out.println(uu.toURI());
		
		
		System.out.println("...............");
		InputStreamReader isr = new InputStreamReader(uu.openStream());
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		

		br.close();
		isr.close();
		
		
		
		
		
	}

}
