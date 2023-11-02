package org.example.birds;

import org.example.Animal;

public abstract class Bird extends Animal {

    public int valFlightAltitude = 0;
    public Bird(String name, int age, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.age = age;
        this.maxSwimDist = maxSwimDist;
    }

    public void flightAltitude(){
        System.out.println("Максимальная высота полета " + name + ": " +  valFlightAltitude);
    }
}
