package com.gjl.sk_4;

class Cat extends Animal{

    @Override
    public void animalSound() {
        System.out.println("야옹");
    }

    @Override
    public void run() {
        System.out.println("고양이가 달립니다.");
    }

    @Override
    public void sleep() {
        System.out.println("고양이가 잡니다.");
    }

}
