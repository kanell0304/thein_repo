package subject;

public class JavaTypeCasting {
    public static void main(String[] agrs) {

        // 타입 캐스팅: 데이터 타입을 변환하는 과정
        //  - int -> double
        // int + double = double
        //  - 만약 int 타입과 double 타입을 서로 계산해야 할 때 결과 값은 자동으로 double 타입으로 반환된다. - 오토 캐스팅
        //  - int와 double 중 double 타입이 더 '큰' 데이터 타입이기 때문 - 데이터 손실의 위험이 없기때문에 오토 캐스팅이 된다.
        //  - 방을 확장 공사한다고 보면 된다 - 좁은 방에 가구들이 놓여있을때 방을 확장한다해도 내부의 가구의 구조는 변경되지 않기 때문이다.
        int num1 = 5;
        double num2 = 10.0;
        System.out.println(num1 + num2); // double 타입의 결과 값: 15.0

        // 다만 직접 타입 캐스팅을 진행하여 타입을 강제로 맞출 순 있다.
        // 방법: double num2 = 10.5 -> (int) num2 -> 10 // int 타입으로 변경함에따라 소수점 아래는 모두 '버림'처리
        //  - ex) int num1 = 5, double num2 = 10.5 -> num1 + num2 = 15.5 -> (int) (num1 + num2) = 15
        int num3 = 5;
        double num4 = 10.5;
        System.out.println(num3 + num4); // 15.5
        System.out.println((int) (num3 + num4)); // 15

    }
}
