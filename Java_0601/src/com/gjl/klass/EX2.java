package com.gjl.klass;
import java.util.Scanner;
import com.gjl.klass.MyCar;
import com.gjl.klass.Calc;

public class EX2 {
	public static void main(String[] args) {
		
		int calcType;
		int num1;
		int num2;
		double result = 0;
		
		MyCar myCar1 = new MyCar();
		MyCar myCar2 = new MyCar(1944);
		MyCar myCar3 = new MyCar(1900, "싼타페");
		
		System.out.println(myCar1.year);
		System.out.println(myCar2.year);
		System.out.println(myCar3.year);
		
		// 사칙연산을 하는 계산기 만들기
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("[계산방법을 선택해주세요(1: 더하기, 2: 빼기, 3: 곱하기, 4: 나누기, 5. 나머지)]: ");
		System.out.print("선택: "); // 계산 방법 선택
		calcType = scanner.nextInt();
		System.out.print("첫번째 수 입력: ");
		num1 = scanner.nextInt();
		System.out.print("두번째 수 입력: ");
		num2 = scanner.nextInt();
		
		Calc calc = new Calc(num1, num2); // 객체 생성 및 초기화
		
		switch (calcType) {
			case 1: result = calc.plus(num1, num2); break; // 더하기
			case 2: result = calc.subtraction(num1, num2); break; // 빼기
			case 3: result = calc.multiply(num1, num2); break; // 곱하기
			case 4: result = calc.divide(num1, num2); break; // 나누기
			case 5: result = calc.modulo(num1, num2); break; // 나머지
			default: System.out.println("계산 방법을 다시 선택해주세요."); break; // 정해진 계산 방법을 선택하지 않았을 경우
		}
		
		System.out.println("결과: " + (int) result); // 결과 출력
		

	}
}
