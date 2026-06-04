package com.gjl.klass;

public class Myobj {
	
	int x = 5;
	
	public void myMethod() {
		System.out.println("myMethod.x: " + x);
	}
	
	// 생성자 변수 x의 값을 받아 할당
	public Myobj(int x) { // 이 클래스틑 부른 클래스에서 인수 전달
		this.x = x; // 전달 받은 인수를 이 클래스(Myobj)가 가지고 있는 변수 x에 할당
	}
	
}
