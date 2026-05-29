package com.gjl;

public class ex2 {
	public static void main(String[] args) {
		// 논리연산자 &&, ||
		// And 연산자 &&
		int x = 5;
		System.out.println(x > 3 && x < 10);
		
		// Or 연산자 ||
		System.out.println(x > 3 || x < 4);
		
		// Not 연산자 !
		System.out.println(!true);
		System.out.println(!false);
		System.out.println(!(x > 3 && x < 10));
		
		// 로그인 여부 판단
		boolean isLoggedIn = true;
		boolean isAdmin = false;
		
		System.out.println("일반사용자: " + (isLoggedIn && !isAdmin));
		System.out.println("사이트접근: " + (isLoggedIn || isAdmin));
		System.out.println("사이트접근: " + !isLoggedIn);
		
		String txt = "abcdefghijklmnopqrxtuvwxyz";
		System.out.println(txt.length());
		System.out.println(txt.toUpperCase());
		System.out.println(txt.toLowerCase());
		
		// 문자열 찾기
		String txt2 = "Please locate where 'locate' occurs!";
		System.out.println("locate");
		System.out.println(txt2.indexOf("'locate'"));
		
		String txt3 = "Hello";
		System.out.println(txt3.charAt(0));
		System.out.println(txt3.charAt(4));
		
		// 공백 제거
		String txt4 = "   Hello World!   ";
		System.out.println("Before: [" + txt4 + "]");
		System.out.println("After: [" + txt4.trim() + "]");
		
		String txt5 = "We are the so0called \"Vikings\" from the north";
		System.out.println(txt5);
		
	}
}
