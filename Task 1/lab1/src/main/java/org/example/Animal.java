package org.example;

public abstract class Animal {

    protected String name;
    protected int maxRunDist;
    protected int maxSwimDist;
    protected int age;

    public void run(double Dist){
        if(Dist <= maxRunDist && Dist > 0){
            System.out.println(name + " пробежал " + Dist + " метров");
        } else System.out.println(name + " не пробежал!");
    }

    public void swim(double Dist){
        if(maxSwimDist != 0) {
            if (Dist <= maxSwimDist && Dist > 0) {
                System.out.println(name + " проплыл " + Dist + " метров");
            } else System.out.println(name + " не проплыл!");
        } else System.out.println(name + " не умеет плавать!");
    }
}
