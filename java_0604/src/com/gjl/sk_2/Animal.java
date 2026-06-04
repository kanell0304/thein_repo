package com.gjl.sk_2;

import lombok.Getter;

@Getter
public class Animal {

    String name;

    void sound() {
        System.out.println("소리");
    }

    void eat() {
        System.out.println("먹기");
    }

    void sleep() {
        System.out.println("수면");
    }

    Animal(String name) {
        this.name = name;
    }

}
