package subject;

public class JavaIfElse {
    public static void main(String[] agrs) {

        int count = 10;

        // if문: 만약~라면 같이 조건문이다, 흐름의 분기점이라고 생각하면 된다.
        // 정해진 조건을 만족할떄만 할당된 작업이 수행되도록 하는 문법이다.

        System.out.println("시작");
        if (count > 5) { // count의 값이 5보다 크다면 코드 실행
            System.out.println("조건문 만족(count > 5)");
        }
        System.out.println("끝\n");

        // else, else if문
        // else문: if문의 조건이 만족하지 못한다면 실행
        System.out.println("시작");
        if (count < 5) { // count의 값이 5보다 작으면 코드 실행
            System.out.println("조건문 만족(count < 5)");
        } else {
            System.out.println("조건문 불만족");
        }
        System.out.println("끝\n");

        // else if 문: else if의 경우 여러번 사용 시 병렬적으로 조건을 체크하는게 아니라 첫 조건에 만족하지 않는 부분들(여집합) 중에 다시 조건을 체크하는 과정이다.
        // 즉, else if가 여려번 사용된다면 여집합의 연속이라고 보면된다.
        System.out.println("시작");
        if (count < 5) { // 첫번째 조건 체크
            System.out.println("count는 5보다 작음");
        } else if (count < 7) { // 나머지 중에 2번째 조건 체크
            System.out.println("count는 7보다 작음");
        } else if (count < 10) { // 나머지 중에 3번째 조건 체크
            System.out.println("count는 10보다 작음");
        } else if (count < 15) { // 나머지 중에 4번째 조건 체크
            System.out.println("count는 15보다 작음");
        } else { // 나머지
            System.out.println("위의 조건에 모두 불만족");
        }
        System.out.println("끝\n");

        // 병렬적으로 조건을 체크하지 않는다는 개념이 중요한 이유: 앞의 조건이 만족한다면 이후 조건들은 체크하지 않기 때문이다.
        System.out.println("시작");
        if (count > 5) {
            System.out.println("첫번째 조건 만족");
        } else if (count > 7) {
            System.out.println("두번째 조건 만족");
        } else {
            System.out.println("나머지");
        }
        System.out.println("끝\n");


    }
}
