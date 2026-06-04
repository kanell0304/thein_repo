package subject;

public class JavaSwitch {
    public static void main(String[] agrs) {

        int count = 3;

        // switch~case문: 조건 검사에 사용될 값을 기준으로 각 조건에 맞는 case를 '코드의 시작점'으로 정한다.
        // 즉, 따로 'break;'를 추가하지 않는다면 시작점이 되는 곳에서 그 다음에 해당하는 모든 코드를 실행한다.
        switch (count) {
            case 1: // 조건 불충족
                System.out.println("1");
            case 2: // 조건 불충족
                System.out.println("2");
            case 3: // 조건 만족, 코드 시작, break; 없음 다음 case로 이동
                System.out.println("3");
            case 4: // 코드 실행, break; 없음 다음 case로 이동
                System.out.println("4");
            case 5: // 코드 실행, break; 없음 다음 case로 이동
                System.out.println("5");
            default: // 코드 실행 - default: 조건 값이 모든 case에 만족하지 못할 때 실행
                System.out.println("default");
        }

        // break
        // 코드 실행 중 break; 를 만나면 그 즉시 해당 코드블록을 탈출한다.(if문, switch~case문, for, while반복문 모두 포함)
        switch (count) {
            case 1: // 조건 불충족
                System.out.println("1");
            case 2: // 조건 불충족
                System.out.println("2");
            case 3: // 조건 만족, 코드 시작, break; 없음 다음 case로 이동
                System.out.println("3");
            case 4: // 코드 실행, break; 없음 다음 case로 이동
                System.out.println("4"); break; // "4"출력 이후 break; -> switch문 탈출, 다음 case로 이동x
            case 5:
                System.out.println("5");
            default:
                System.out.println("default");
        }

    }
}
