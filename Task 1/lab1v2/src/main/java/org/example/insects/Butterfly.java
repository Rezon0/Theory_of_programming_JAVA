package org.example.insects;

public class Butterfly extends Insect{
    private static int count;

    public static int getCount() {
        return count;
    }
    private static final int averageLfe = 1;

    public Butterfly(String name, int age, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist);
        count++;
    }
}
