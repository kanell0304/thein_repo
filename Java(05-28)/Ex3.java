package com.gjl;
import com.gjl.Ex2;

public class Ex3 {
	
//	private static void printing_text(String text) {
//		System.out.println(text);
//	}
	
	public static void main(String[] args) {
		
		// while, do~while
		// while: 조건이 만족하지 않을때까지 지정된 코드를 반복 실행
		// do~while: 지정된 코드를 실행 후 여전히 조건이 만족된다면 지정된 코드를 재실행
		int count = 0;
		
		while (count < 10) {
			System.out.println(count++);
		}
		
		count = 0;
		
		do {
			System.out.println(count++);
		} while (count < 10);
		
		for (int i = 0; i < 10; i += 2) {
			System.out.println(i);
		}
		
		String[] cars = {"aa", "bb", "cc", "dd", "ee"};
		
		for (String c : cars) {
			System.out.println(c);
		}
		
		Ex2 ex2 = new Ex2();
		
		ex2.printing("안녕하세요.");
		
	}
}
