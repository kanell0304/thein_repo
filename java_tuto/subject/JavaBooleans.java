package subject;

public class JavaBooleans {
    public static void main(String[] agrs) {

        // 테스트 변수 선언
        boolean isTrue = true;
        boolean isFalse = false;

        // boolean: true/false, yes/no, is/isNot 등 상반되는 두가지 상태를 저장하는 타입이다.
        System.out.println(isTrue); // true

        // 논리 연산자: &&, ||, !
        // boolean 데이터 타입에 사용되는 연산자이다.
        System.out.println(isTrue && isFalse); // false
        System.out.println(isTrue || isFalse); // true
        System.out.println(!isTrue); // false

    }
}
