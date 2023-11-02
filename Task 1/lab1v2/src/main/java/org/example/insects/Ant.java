package org.example.insects;

public class Ant extends Insect{
    private static int count;

    public static int getCount() {
        return count;
    }
    private static final int averageLfe = 2;

    public Ant(String name, int age, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist);
        count++;
    }
}
