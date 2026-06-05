package src.com.gjl.arrayList;

public class MyMain6 {

    static void checkAge(int age) {
        if (age < 19) {
            throw new ArithmeticException("미성년자(" + age + ")는 접근이 불가합니다.");
        } else {
            System.out.println("접근 가능(나이: " + age + ")");
        }
    }

    public static void main(String[] args) {

//        try { // 일단 코드 블록의 코드를 실행
//            int[] myNumbers = {1, 2, 3};
//            System.out.println(myNumbers[10]); // 오류 발생!
//        } catch (IndexOutOfBoundsException e) { // 발생한 오류가 IndexOutOfBounds인지 확인
//            System.out.println("인덱스 오류 발생"); // 맞다면 정해둔 코드 실행
//        } catch (Exception e) { // 그 외 최상위 Exception클래스로 모든 종류의 Exception을 받음
//            System.out.println(e.getMessage()); // 발생한 오류에 대한 정보 출력
//        } finally { // 오류 발생과 관계 없이 반드시 실행하는 코드 블록
//            System.out.println("코드 끝");
//        }


        // throw
//        checkAge(16);

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]);
            int result1 = 10 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 오류 발생");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 순 없습니다.");
        } catch (Exception e) {
            System.out.println("오류 발생");
        }

    }
}
