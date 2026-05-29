package com.gjl;
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		System.out.print("Hello World!");
		System.out.print("Hello World!");
		System.out.print("Hello World!");
		
//		int inputNum = scanner.nextInt("숫자를 입력해주세요.");
		
		String name = "John";
		System.out.println(name);
		
		int intName = 15;
		System.out.println(intName);
		
		intName = 100;
		System.out.println(intName);
		
		final int final_name = 9999;
//		final: 값 변경 불가능
//		final_name = 8888; 불가능
		System.out.println(final_name);
		
		System.out.println(false);
		
//		데이터 타입
//		byte, short, int, long, double, float, boolean, char, String
		int intValue = 5;
		float floatValue = 5.99f;
		char charValue = 'D';
		boolean boolValue = true;
		String strValue = "Hello";
		String strValue2 = "안녕하세요.";
		
		System.out.println(intValue);
		System.out.println(floatValue);
		System.out.println(charValue);
		System.out.println(boolValue);
		System.out.println(strValue);
		System.out.println(strValue2);
		
		int myInt = 9;
		double myDouble = myInt;
		
		System.out.println(myInt);
		System.out.println(myDouble);
		
		myInt = (int) myDouble;
		System.out.println(myInt);
		
		int sum1 = 100 + 50;
		int sum2 = sum1 + 250;
		int sum3 = sum2 + sum2;
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		
		// 증감연산자
		// ++num, num++, --num, num--
		int z = 5;
		++z;
		System.out.println(z);
		
	}
}
