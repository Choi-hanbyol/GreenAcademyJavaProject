package collection_p;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreChart {

	public static void main(String[] args) {
		
		int [] score = {56,78,92,45,78,25,77,94,77,56,83,85,56,45,72,61,69}; //60점대 추가해봤음
		
		ArrayList su = new ArrayList(); //90~100
		ArrayList wu = new ArrayList(); //80~89
		ArrayList mi = new ArrayList(); //70~79
		ArrayList yang = new ArrayList(); //60~69
		ArrayList ga = new ArrayList(); //0~59
		
		for(int i : score) {
			if(i>=90&&i<=100) {
				su.add(i);
			}
			else if(i>=80&&i<=89) {
				wu.add(i);
			}
			else if(i>=70&&i<=79) {
				mi.add(i);
			}
			else if(i>=60&&i<=69) {
				yang.add(i);
			}
			else {
				ga.add(i);
			}
		}
		System.out.println("<등급>");
		Collections.sort(su);
		Collections.reverse(su);
		System.out.println("수 > "+su);
		Collections.sort(wu);
		Collections.reverse(wu);
		System.out.println("우 > "+wu);
		Collections.sort(mi);
		Collections.reverse(mi);
		System.out.println("미 > "+mi);
		Collections.sort(yang);
		Collections.reverse(yang);
		System.out.println("양 > "+yang);
		Collections.sort(ga);
		Collections.reverse(ga);
		System.out.println("가 > "+ga);
	}
}