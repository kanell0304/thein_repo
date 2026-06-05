package src.com.gjl.finalClass;

public class MyMain2 {
    public static void main(String[] args) {

        Level myVar = Level.HIGH;
        System.out.println(myVar);

        switch (myVar) {
            case LOW: System.out.println("LOW 커피 로스팅 주문"); break;
            case MEDIUM: System.out.println("MEDIUM 커피 로스팅 주문"); break;
            case HIGH: System.out.println("HIGH 커피 로스팅 주문"); break;
            default: System.out.println("알맞지 않은 값입니다.");
        }

        for (Level v : Level.values()) {
            System.out.println(v);
        }

    }
}
