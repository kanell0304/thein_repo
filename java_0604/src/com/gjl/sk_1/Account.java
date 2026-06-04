package com.gjl.sk_1;

public class Account {
	
	String accountNumber;
	String owner;
	int balance;
	
	public Account() {}
	
	Account(String accountNumber, String owner, int balance) {
		// 초기화
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
	}

	String deposit(int amount) {
		this.balance += amount;
		return ("입금완료! 잔액: " + balance);
	}

	String withdraw(int amount) {
		this.balance -= amount;
		return ("출금완료! 잔액: " + balance);
	}

}
