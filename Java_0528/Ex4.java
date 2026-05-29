package com.gjl;
import com.gjl.MyClass;
import com.gjl.ImplClass;
import com.gjl.Students;
import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		var originOne = new MyClass(5);
		originOne.printing();
		
		MyClass myClass = new MyClass(5); // 부모 객체 생성
		ImplClass implClass = new ImplClass(7); // 자식 객체 생성
		
		myClass.printing(); // 부모 객체 메서드 실행
		System.out.println(myClass.x); // 부모 객체의 변수 x 호출 및 출력
		implClass.printing(); // 자식 객체 오버라이딩 된 메서드 실행
		implClass.print_x(); // 자식 클래스에는 없지만 부모 클래스로부터 상속받은 변수 x 값 출력
		
		// 오버 로딩: 이름은 같지만 기능은 다른 메서드들을 매개 변수의 타입, 배치 순서, 갯수의 차이를 이용해 선택적으로 호출
		myClass.printObj(77); // int 타입
		myClass.printObj("행운"); // String 타입
		myClass.printObj(true); // boolean 타입
		
		// students 객체 생성
		Students st01 = new Students("홍길동");
		Students st02 = new Students("이순신", 40);
		Students st03 = new Students("성춘향", 25, "서울");
		
		// 값을 입력 받은 후 객체 생성 -> 출력
		System.out.print("이름을 입력해주세요: ");
		String st_name = scanner.nextLine();
		System.out.print("나이를 입력해주세요: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("주소를 입력해주세요: ");
		String address = scanner.nextLine();
		
		Students customStudent = new Students(st_name, age, address);
		
		System.out.println(st01.getSt_name());
		System.out.println(st02.getSt_name());
		System.out.println(st03.getSt_name());
		System.out.println(customStudent.getSt_name());
		st01.displayInfo();
		st02.displayInfo();
		st03.displayInfo();
		customStudent.displayInfo();

	}
}
