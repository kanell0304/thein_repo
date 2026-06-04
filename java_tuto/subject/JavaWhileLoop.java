package subject;

public class JavaWhileLoop {
    public static void main(String[] agrs) {

        int count = 5;

        // 반복문: 말 그대로다, 코드 블록에 있는 코드를 조건에 따라 반복으로 실행한다.
        // while문: 조건이 만족하면 코드 블록을 실행 -> 조건이 만족하고 조건에 변화가 없다면 이론상 영원히 실행하게된다.
        while (count < 10) { // 조건이 만족한다면 코드 블록의 코드를 실행한다.
            System.out.println(count);
            count++; // count + 1; -> 조건 값에 변화를 주지 않으면 영원히 코드 블록을 실행하게 된다.
        }

        System.out.println();
        count = 5; // count 값 초기화

        // do~while문: do의 코드 블록을 일단 실행 한 뒤 다시 반복해서 실행할 지 이후 while문의 조건으로 판단
        // while문과의 차이: while문은 조건에 따라 코드 블록을 아예 실행하지 않을 수 도 있지만 do~while문의 경우 일단 코드 블록을 최소 '1번'은 실행한다.
        do { // 코드 블록을 실행
            System.out.println(count);
            count++;
        } while(count < 10); // 조건이 만족한다면 다시 코드 블록을 실행

    }
}
