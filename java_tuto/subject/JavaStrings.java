package subject;

public class JavaStrings {
    public static void main(String[] agrs) {

        // 문자열(String): 원시 데이터 타입이 아니라 클래스이다.
        String str = "Hello World!";
        String subStr = " I'm Java!";

        // String 관련 메서드
        System.out.println(str.length()); // 문자열 길이 반환
        System.out.println(str.charAt(1)); // 문자열의 몇번쨰(0부터) 문자를 char타입으로 변환하여 반환 - result: 0
        System.out.println(str.toUpperCase()); // 문자열 전체를 대문자로 변경
        System.out.println(str.toLowerCase()); // 문자열 전체를 소문자로 변경
        System.out.println(str.lastIndexOf("World"));

        // 문자열 합치기
        System.out.println(str + subStr); // String 타입을 합칠때 단순히 문자열 2개를 합치는게 아니라 2개의 문자열이 합쳐진 새로운 객체를 생성하여 출력한다.
        // 즉, 반복문을 통해 문자열을 반복해서 합칠 경우 매번 합친 결과에 따른 새로운 객체가 생성되므로 메모리 낭비가 발생할 수 있다.

    }
}
