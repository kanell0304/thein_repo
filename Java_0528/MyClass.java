package com.gjl;

public class MyClass {
	
	int x = 0;
	
	public void printing() {
		System.out.println("객체 생성 완료");
	}
	
	public void printObj(int obj) {
		System.out.println(obj);
	}
	
	public void printObj(String obj) {
		System.out.println(obj);
	}
	
	public void printObj(boolean obj) {
		System.out.println(obj);
	}
	
	public MyClass(int x) {
		this.x = x;
	}
	
}
