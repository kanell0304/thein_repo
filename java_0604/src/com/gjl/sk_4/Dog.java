package com.gjl.sk_4;

public class Dog extends Animal{

    @Override
    public void animalSound() {
        System.out.println("멍멍");
    }

    @Override
    public void run() {
        System.out.println("강아지가 달립니다.");
    }

    @Override
    public void sleep() {
        System.out.println("강아지가 잡니다.");
    }

}
