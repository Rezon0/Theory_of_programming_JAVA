package org.example.insects;

public class Dragonfly extends Insect{
    private static int count;
    public static int getCount() {
        return count;
    }
    private static final int averageLfe = 3;

    public Dragonfly(String name, int age, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist);
        count++;
    }
}
