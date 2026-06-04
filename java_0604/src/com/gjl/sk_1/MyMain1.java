package com.gjl.sk_1;

public class MyMain1 {
	public static void main(String[] args) {
		
		Account acc = new Account("100--200", "성시경", 10);

		// 잔액 추가
		String depositResult = acc.deposit(800000);
		System.out.println(depositResult);

		// 압금
		System.out.println(acc.deposit(8000));
		// 출금
		System.out.println(acc.withdraw(10000));

	}
}
