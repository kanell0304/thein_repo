package src.com.gjl.javaTest1;

public class Banana extends FruitImpl{

    @Override
    public void touch() {
        System.out.println("바나나를 손으로 눌러보기");
    }

//    @Override
    public void throwAway() {
        System.out.println("바나나를 휴지통에 버리기");
    }

    public Banana(int price, String color, String shape) {
        super(price, color, shape);
    }

}
