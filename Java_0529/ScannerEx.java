package com.gjl.scan;
import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 두 숫자의 합을 구하기 ===");
		System.out.print("첫번째 숫자: ");
		int n1 = scanner.nextInt();
		System.out.print("두번째 숫자: ");
		int n2 = scanner.nextInt();
		
		System.out.println("두 수의 합: " + (n1 + n2));

	}
}
