package com.gjl.sk_2;

class Dog extends Animal{

    Dog(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("멍멍");
    }

    @Override
    void eat() {
        System.out.println("강아지가 먹는다.");
    }

    @Override
    void sleep() {
        System.out.println("강아지가 잔다.");
    }

}
