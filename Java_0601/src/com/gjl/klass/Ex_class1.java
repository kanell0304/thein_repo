package com.gjl.klass;
import com.gjl.klass.Myobj; // 불러올 클래스 경로

public class Ex_class1 {
	public static void main(String[] agrs) {
		
		Myobj myobj_1 = new Myobj(5); // new 키워드로 객체 생성 -> class 작성 = 설계도 그리기 -> new 객체 생성 = 설계도대로 객체 생성
		// [왜 한번에 만들지 않고 따로 만드는 지]
		// 1. 코드 유지보스 상향: 문제(오류)가 발생 시 문제가 발생한 부분만 찾아 들어가서 수정 가능
		// 2. 코드 재사용성 증가: 똑같은 코드를 여러군데에서 사용할때 매번 같은 코드를 작성하지 않고 모듈형식으로 불어와서 사용 가능
		//		- 향 후 코드 수정 필요 시 모든 부분을 수정하지 않고 모듈이 된 코드만 수정 시 전체 적용
		// 3. 코드 가독성 증가: 타인이 내가 작성한 코드를 분석 시 코드의 구조만 파악해도 어느정도 어떤 코드가 어떤 역할을 하는지 짐작 가능
		Myobj myobj_2 = new Myobj(7);
		Myobj myobj_3 = new Myobj(10);
		
		String str = "abcdefghijklmnopqrstuvwsyz";
		int num = 5;
		
		System.out.println(myobj_1.x);
		System.out.println(myobj_2.x);
		System.out.println(myobj_3.x);
		
		myobj_1.myMethod();
		myobj_2.myMethod();
		myobj_3.myMethod();
		
	}
}
