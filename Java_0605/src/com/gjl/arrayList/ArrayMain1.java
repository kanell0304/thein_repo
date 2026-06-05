package src.com.gjl.arrayList;

import java.util.ArrayList;

public class ArrayMain1 {
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        // 데이터 삽입
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("포도");

        // ["사과", "바나나", "포도"]

        for (String fruit : fruits) { // 리스트의 첫번째 요소부터 하나씩 뺴서 fruit 변수에 할당
            System.out.println(fruit); // 할당된 변수의 값을 출력
        }

    }
}
