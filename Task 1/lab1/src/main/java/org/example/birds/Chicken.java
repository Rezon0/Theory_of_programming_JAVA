package org.example.birds;

import org.example.birds.Bird;

public class Chicken extends Bird {
    private static int count;

    public static int getCount() {
        return count;
    }

    public Chicken(String name, int age, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist);
        this.valFlightAltitude = 1;
        count++;
    }

}
