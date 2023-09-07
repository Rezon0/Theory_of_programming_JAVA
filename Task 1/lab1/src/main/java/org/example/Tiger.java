package org.example;

public class Tiger extends Animal{
    static int count;

    public static int getCount() {
        return count;
    }

    public Tiger(String name, int age, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.age = age;
        this.maxSwimDist = maxSwimDist;
        count++;
    }
}
