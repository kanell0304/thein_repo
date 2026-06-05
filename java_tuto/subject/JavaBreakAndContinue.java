package subject;

public class JavaBreakAndContinue {
    public static void main(String[] agrs) {

        int count = 0;

        // break; : for, while, do~while, switch~case 문에 사용되며 해당 흐름을 탈출하는 역할을 한다.
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("탈출!");
                break;
            }
            System.out.println(i);
        }

        while (count < 10) {
            if (count == 5) {
                System.out.println("탈출!");
                break;
            }
            System.out.println(count);
            count++;
        }

        count = 0;

        do {
            if (count == 5) {
                System.out.println("탈출!");
                break;
            }
            System.out.println(count);
            count++;
        } while(count < 10);

        count = 1;

        switch (count) {
            case 1: System.out.println(1);
            case 2: System.out.println(2);
            case 3: System.out.println(3);
            case 4: System.out.println(4 + " 탈출!"); break;
            case 5: System.out.println(5);
            case 6: System.out.println(6);
            case 7: System.out.println(7);
            default: break;
        }

        // continue: '계속' 혹은 '넘어가기'이다, break;와 같은 곳에 쓰이며 역할은 continue;를 사용 시 continue; 뒤에 코드들은 건너뛰고 다음 코드 흐름으로 넘어간다.
        for (int i = 0; i < 10; i++) {
            if (i == 3) { // i == 3일때
                continue; // 다음 반복으로 넘어감
            }
            System.out.println(i);
        }

    }
}
