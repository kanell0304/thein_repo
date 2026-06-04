package subject;

public class JavaMath {
    public static void main(String[] agrs) {

        // 테스트 변수 선언
        int x = 10;
        int y = 5;
        int z = -3;

        double double_x = 10.5;
        double double_y = 5.2;
        double double_z = 5.8;

        // Java에서 제공하는 수학(Math관련 내장 메서드)
        // max(x, y): 전달된 두 값 중 더 큰 값을 반환
        System.out.println("더 큰 값: " + Math.max(x, y));

        // min(x, y): 전달된 두 값 중 더 작은 값을 반환
        System.out.println("더 작은 값: " + Math.min(x, y));

        // sqrt(x): 전달된 값의 제곱근(√)을 반환
        System.out.println(x + "의 제곱근(√): " + Math.sqrt(x));

        // abs(z): 전달된 값의 절댓값(양수)를 반환
        System.out.println(z + "의 절댓값: " + Math.abs(z));

        // pow(x, y): 전달된 값 중 x를 y번 제곱한 값을 반환(double타입)
        System.out.println(x + "의 " + y + "제곱: " + Math.pow(x, y));

        // 반올림
        // 1. round(x): x를 반올림 처리
        System.out.println(double_x + "의 반올림: " + Math.round(double_x));

        // 2. ceil(x): x를 올림 처리
        System.out.println(double_y + "의 올림: " + Math.ceil(double_y));

        // 3. floor(): x를 내림 처리
        System.out.println(double_z + "의 내림: " + Math.floor(double_z));

        // 난수(랜덤): 0~1사이의 난수를 반환
        // random(): 0~1사이의 난수
        System.out.println("0~1: " + String.format("%.3f", Math.random()));

        // 0~7사이의 난수: random() 함수의 값은 0~1의 값을 반환하기 때문에 7을 곱해주면 0~7의 값을 반환한다.
        System.out.println("0~7: " + String.format("%.3f", Math.random() * 7));

        // 1~7사이의 난수(정수 반환): random() 결과 값에 +1을 더하고 타입 캐스팅(int)을 사용하여 소수점 아래를 버림으로서 1~7까지의 값을 만들기
        System.out.println("1~7: " + ((int)(Math.random() * 7) + 1));
        // System.out.println()에서 직접 Math.random() 사용 시 많이 하는 실수
        // 다음 주석 처리된 코드를 실행 시 1~7 사이의 무작위 값이 아닌 (0~7)1 -> 01, 11, 21, ..., 61 중 하나의 값이 출력 될 것이다.
        // 원인: print()의 기능 중 문자열 연결(+)기호의 기능때문에 Math.random()값에 정수로 + 1이 되는게 아니라 문자열 연결 처럼 "3" + "1" 처럼 되기 때문에 반드시 ()로 묶어줘야 한다.
        // System.out.println("1~7: " + (int) (Math.random() * 7) + 1);

    }
}
