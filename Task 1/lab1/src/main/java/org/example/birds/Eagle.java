package org.example.birds;

import org.example.birds.Bird;

public class Eagle extends Bird {
    private static int count;

    public static int getCount() {
        return count;
    }
    public Eagle(String name, int age, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist);
        this.valFlightAltitude = 500;
        count++;
    }
}
