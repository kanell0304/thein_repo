package com.gjl.scan;

import java.util.Scanner;

public class ATMApp {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        int balance = 0;

	        while (true) {

	            System.out.println("\n==== ATM 메뉴 ====");
	            System.out.println("1. 입금");
	            System.out.println("2. 출금");
	            System.out.println("3. 잔액조회");
	            System.out.println("4. 종료");
	            System.out.print("선택> ");

	            int menu = sc.nextInt();

	            switch (menu) {

	                case 1:
	                    System.out.print("입금액: ");
	                    int deposit = sc.nextInt();
	                    balance += deposit;
	                    System.out.println("입금 완료");
	                    break;

	                case 2:
	                    System.out.print("출금액: ");
	                    int withdraw = sc.nextInt();

	                    if (withdraw > balance) {
	                        System.out.println("잔액 부족");
	                    } else {
	                        balance -= withdraw;
	                        System.out.println("출금 완료");
	                    }
	                    break;

	                case 3:
	                    System.out.println("현재 잔액: " + balance);
	                    break;

	                case 4:
	                    System.out.println("프로그램 종료");
	                    return;

	                default:
	                    System.out.println("잘못된 입력");
	            }
	        }

	}

}