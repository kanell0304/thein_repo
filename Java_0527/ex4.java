package com.gjl;

public class ex4 {
	public static void main(String[] args) {
		
		System.out.println(Math.max(1, 2));
		System.out.println(Math.min(1, 2));
		System.out.println((int) Math.sqrt(64));
		System.out.println(Math.abs(-4.7));
		System.out.println(Math.abs(-100));
		System.out.println(Math.pow(2, 8));
		System.out.println((int) ((Math.random() * 10) + 1));
		
		// 변수 선언문
		int x;
		int y;
		boolean isGreater;
		
		// 값 정의(코드 로직 실행되는 중에~)
		x = 10;
		y = 9;
		isGreater = x > y;
		
		// 출력
		System.out.println(isGreater);
		
	}
}
