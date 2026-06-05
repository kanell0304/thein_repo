package com.gjl.sk_4;

class Animal implements InterAnimal{

    @Override
    public void animalSound() {
        System.out.println("동물의 울음소리");
    }

    @Override
    public void run() {
        System.out.println("동물이 달립니다.");
    }

    @Override
    public void sleep() {
        System.out.println("동물이 잡니다.");
    }

}
