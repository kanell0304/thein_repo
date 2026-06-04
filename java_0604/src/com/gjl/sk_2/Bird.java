package com.gjl.sk_2;

class Bird extends Animal{

    String baby;

    Bird(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("짹짹");
    }

    @Override
    void eat() {
        System.out.println("새가 먹는다.");
    }

    @Override
    void sleep() {
        System.out.println("새가 잔다.");
    }

    void baby() {
        this.baby = "알을 낳습니다.";
    }

}
