package com.gjl.sk_2;

class Cat extends Animal{

    Cat(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("야옹");
    }

    @Override
    void eat() {
        System.out.println("고양이가 먹는다.");
    }

    @Override
    void sleep() {
        System.out.println("고양이가 잔다.");
    }

}
