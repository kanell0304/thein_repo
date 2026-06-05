package src.com.gjl.javaTest1;

public class FruitImpl implements Fruit{

    int price;
    String color;
    String shape;

    @Override
    public void touch() {
        System.out.println("손으로 눌러보기");
    }

//    @Override
//    public void throwAway() {
//        System.out.println("휴지통에 버리기");
//    }

    public FruitImpl (int price, String color, String shape) {
        this.price = price;
        this.color = color;
        this.shape = shape;
    }
}
