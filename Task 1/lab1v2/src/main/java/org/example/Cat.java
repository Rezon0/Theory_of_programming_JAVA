package org.example;

public class Cat extends Animal{
    static int count;

    public static int getCount() {
        return count;
    }

    public Cat(String name, int age, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.age = age;
        this.maxSwimDist = maxSwimDist;
        count++;
    }
}
