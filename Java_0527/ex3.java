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
		
		System.out.println("일반사용자: " + (isLoggedIn && !isAdmin)); // 로그인 상태이고 관리자 권한이 없을 때
		System.out.println("사이트접근: " + (isLoggedIn || isAdmin)); // 로그인 상태이거나 관리자 권한이 있을 때
		System.out.println("사이트접근: " + !isLoggedIn); // 로그인 상태가 아닐때
		
		String txt = "abcdefghijklmnopqrxtuvwxyz";
		System.out.println(txt.length()); // 문자열 길이
		System.out.println(txt.toUpperCase()); // 문자열의 내용을 모두 대문자로 변경
		System.out.println(txt.toLowerCase()); // 문자열의 내용을 모두 소문자로 변경
		
		// 문자열 찾기
		String txt2 = "Please locate where 'locate' occurs!";
		System.out.println("locate");
		System.out.println(txt2.indexOf("'locate'")); // 'locate' ('포함) 문자열의 위치(공백 포함 처음부터 몇번쨰에 위치하는지)

		// 문자열의 특정 문자를 char타입으로 변환
		// .charAt(문자열 처음부터 몇번째 문자를 char타입으로 변환할 지)
		String txt3 = "Hello";
		System.out.println(txt3.charAt(0));
		System.out.println(txt3.charAt(4));
		
		// 공백 제거
		String txt4 = "   Hello World!   ";
		System.out.println("Before: [" + txt4 + "]");
		System.out.println("After: [" + txt4.trim() + "]");
		
		String txt5 = "We are the so0called \"Vikings\" from the north";
		// 문자열(String)사용 시 "" 을 사용해야하는데 문자열 안에 직접 ""을 표현하고 싶다면 "기호 앞에 \를 붙임
		// 문자열을 처리할때 " 앞에 \를 붙이면 "를 문자열 처리 트리거로 인식하지 않음
		System.out.println(txt5);
		
	}
}
