package subject;

public class JavaArrays {
    public static void main(String[] agrs) {

        // 배열[]: 여러 값을 한번에 선언하며 이 값들이 모인 장소의 주소를 변수에 저장한다.
        // 배열 선언 방법: 2개 모두 가능
        //  - int[] arr = {1, 2, 3}
        //  - int arr[] = {1, 2, 3}
        // 배열의 값에 접근할때는 '변수[주소 값]'으로 접근하며 배열의 주소는 0부터 시작한다.
        // [1, 2, 3] -> [0] = 1, [1] = 2, [2] = 3

        int[] intArr = {1, 2, 3};
        System.out.println(intArr[1]); // 2

        String strArr[] = {"Apple", "Banana", "Orange"};
        System.out.println(strArr[0]); // Apple


    }
}
