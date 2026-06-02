package subject;

// 연산자
public class JavaOperators {
    public static void main(String[] agrs) {

        // 대입 연산자: =
        int num1 = 10;
        int num2 = 3;

        // 산술 연산자: +, -, *, /, %, ++, --
        System.out.println(num1 + num2); // 더하기 - 13
        System.out.println(num1 - num2); // 빼기 - 7
        System.out.println(num1 * num2); // 곱하기 - 30
        System.out.println(num1 / num2); // 나누기 - 3
        System.out.println(num1 - num2); // 나머지 - 1

        // 증감 연산자: +1 or -1 -> 기호가 앞에 붙으면 +-1을 한 뒤 코드 실행, 기호가 뒤에 붙으면 코드를 실행한 후 +-1 진행
        System.out.println(num1++); // 현재 num1값을 출력 한 뒤 +1
        System.out.println(++num1); // 현재 num1값에 +1 한 뒤 출력
        System.out.println(num1--); // 현재 num1값을 출력 한 뒤 -1
        System.out.println(--num1); // 현재 num1값에 -1 한 뒤 출력

        // 비교 연산자: 2개의 값을 비교하여 조건에 맞다면 true, 맞지 않다면 false를 반환한다.
        System.out.println(num1 == num2); // 두 값이 같은가?
        System.out.println(num1 != num2); // 두 값이 같지 않은가?
        System.out.println(num1 > num2); // 두 값 중 첫번째 값이 더 큰가?
        System.out.println(num1 < num2); // 두 값 중 두번째 값이 더 큰가?
        System.out.println(num1 >= num2); // 두 값 중 첫번째 값이 크거나 같은가?
        System.out.println(num1 <= num2); // 두 값 중 두번째 값이 크거나 같은가?

        // 논리 연산자: &&(and), ||(or), !(not) - 특정 조건에 따라 true/false를 반환
        System.out.println(num1 == num2 && num1 > num2); // 첫번째 조건과 두번째 조건이 모두 true일때만 true 반환
        System.out.println(num1 == num2 || num1 > num2); // 첫번째 조건과 두번째 조건이 하나라도 true라면 true반환
        System.out.println(!(num1 == num2)); // 특정 조건의 결과 값을 반전: true -> false, false -> true

    }
}
