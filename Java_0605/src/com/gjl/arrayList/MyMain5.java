package src.com.gjl.arrayList;
import java.util.ArrayList;

public class MyMain5 {
	public static void main(String[] args) {
		
		ArrayList<String> cars = new ArrayList<String>();
		System.out.println(cars);

		// ArrayList에 데이터 삽입
		cars.add("볼보");
		cars.add("BMW");
		cars.add("포드");
		cars.add("마쯔다");
		System.out.println(cars);

		// 특정 위치에 값을 추가
		cars.add(0, "추가된 자동차");
		System.out.println(cars);

		// 0번째 위치의 값을 출력
		System.out.println(cars.get(0));

		// 0번째 위치에 "XM3"수정
		cars.set(0, "XM3");
		System.out.println(cars);

		// 특정 인덱스 요소 삭제
		System.out.println(cars.remove(0));

		// 리스트 요소 모두 삭제
		cars.clear();
		System.out.println(cars);

	}
}
