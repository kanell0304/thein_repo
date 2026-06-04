package com.gjl.sk_2;

public class MyMain2 {
    public static void main(String[] args) {

        Pig pig1 = new Pig("돼지");
        Cat cat1 = new Cat("고양이");
        Dog dog1 = new Dog("강아지");
        Bird bird1 = new Bird("새");

        Animal pig2 = new Pig("돼지2");
        Animal cat2 = new Cat("고양이2");
        Animal dog2 = new Dog("강아지2");
        Animal bird2 = new Bird("새2");

        // Pig
        System.out.println(pig1.getName());
        pig1.sound();
        pig1.eat();
        pig1.sleep();
        System.out.println(pig2.getName());
        System.out.println();

        // Cat
        System.out.println(cat1.getName());
        cat1.sound();
        cat1.eat();
        cat1.sleep();
        System.out.println(cat2.getName());
        System.out.println();

        // Dog
        System.out.println(dog1.getName());
        dog1.sound();
        dog1.eat();
        dog1.sleep();
        System.out.println(dog2.getName());
        System.out.println();

        // Bird
        System.out.println(bird1.getName());
        bird1.sound();
        bird1.eat();
        bird1.sleep();
        bird1.baby();
        System.out.println(bird1.baby);
        System.out.println(bird2.getName());
        System.out.println();

    }
}
