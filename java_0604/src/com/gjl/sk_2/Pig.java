package com.gjl.sk_2;

class Pig extends Animal{

    Pig(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("꿀꿀");
    }

    @Override
    void eat() {
        System.out.println("돼지가 먹는다.");
    }

    @Override
    void sleep() {
        System.out.println("돼지가 잔다.");
    }

}
