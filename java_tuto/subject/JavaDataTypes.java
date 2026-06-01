package subject;

public class JavaDataTypes {
    public static void main(String[] args) {

        // [데이터 타입]
        // 원시 타입 / 참조 타입
        // 원시 타입: 변수 선언 시 스택 메모리에 변수명과 변수 값이 함께 저장된다.
        //  - 정수형: byte, short, int, long
        //      - 제일 많이 사용되는 형태이며 (-)를 포함한 정수만 입력 가능하고 왼쪽부터 오른쪽으로 갈수록 저장할 수 있는 데이터의 크기가 커진다.
        //  - 실수형: float, double
        //      - 0.xxx같은 실수를 저장할 수 있으며 float의 경우 변수 선언 시 변수값 뒤에 f를 붙인다. ex) float pi = 3.14f;
        //  - 문자형: char
        //      - 문자를 저장하는 데이터 타입으롱 따옴표를 사용하여 값을 저장한다. ex) char ch = 'A';
        //  - 논리형: boolean
        //      - Yes or No, 맞냐 틀리냐 즉, true/false를 저장할 수 있는 데이터 타입이다. !(부정 연산자), &&(and), ||(or)는 boolean 데이터 타입에만 사용할 수 있다.
        // 참조타입: 원시 타입과 다르게 변수명이 변수 값이 아닌 힙 메모리에 존재하는 실제 데이터의 주소값을 가지고 스택 메모리에 저장된다.
        //  - 클래스: new 키워드를 이용해 객체를 생성 시 힙 메모리에 생성이 되며 변수에 해당 객체의 주소 값을 저장한다.
        //  - 배열: 힙 메모리에 배열 내부의 주소 값([0], [1]..)과 함께 해당 주소에 저장될 값이 함게 저장되고 스택 메모리에 변수명과 함께 힙 메모리에 저장된 배열의 주소값이 함께 저장됨
        //  - String: 문자열을 저장하는 데이터 타입으로 int, char등 과 다르게 '원시 데이터 타입이 아니다', Eclipse기준 CTRL + 클릭 을 통해 관련 코드를 볼 수 있으며 엄연히 '클래스'이다.

        byte num1 = 1;
        short num2 = 2;
        int num3 = 3;
        long num4 = 4;
        float num5 = 5.55f;
        double num6 = 6.6;
        char ch = 'A';
        boolean bool = true;
        TestClass testClass = new TestClass();
        int[] arr1 = {1, 2, 3, 4, 5};
        String[] arr2 = {"Apple", "Banana", "Orange"};
        String str = "BlueBerry";

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(ch);
        System.out.println(bool);
        System.out.println(testClass.num1);
        System.out.println(arr1[0]);
        System.out.println(arr2[1]);
        System.out.println(str);

    }
}
