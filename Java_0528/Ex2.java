package com.gjl;

public class Ex2 {
	public static void main(String[] args) {

		boolean isRaining = true;
		
		if (isRaining) {
			// true
			System.out.println("비가 옴");
		} else {
			// false
			System.out.println("비가 안옴");
		}
		System.out.println("------------------------");
		
		int weather;
		
		weather = 2;
		
		if (weather == 1) {
			System.out.println("비가 옴");
		} else if (weather == 2) {
			System.out.println("비가 아닌데?");
		} else {
			System.out.println("비가 안옴");
		}
		System.out.println("-----------------------");
		
		String result;
		result = isRaining ? "참" : "거짓";
		System.out.println(result);
		
		System.out.println("-----------------------");
		
		for (int i = 0; i < 5; i++) {
			switch (i) {
				case 0: System.out.println("1이에용"); break;
				case 1: System.out.println("2이에용"); break;
				case 2: System.out.println("3이에용"); break;
				case 3: System.out.println("4이에용"); break;
				case 4: System.out.println("5이에용"); break;
				default: System.out.println("나영석: 끝!"); break;
			}			
		}

	}
	
	public void printing(String text) {
		System.out.println("안녕하세요.");
	}
}
