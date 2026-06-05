package src.com.gjl.javaTest1;

public class Apple extends FruitImpl{

    @Override
    public void touch() {
        System.out.println("사과를 손으로 눌러보기");
    }

//    @Override
//    public void throwAway() {
//        System.out.println("사를 휴지통에 버리기");
//    }

    public Apple(int price, String color, String shape) {
        super(price, color, shape);
    }

}
