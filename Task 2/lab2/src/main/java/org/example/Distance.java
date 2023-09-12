package org.example;

public enum Distance {
    LONG(300),
    MIDDLE(100),
    SHORT(5),
    HIGH(3),
    LOW(1);
    private int dist;
    public int getDist() {
        return dist;
    }
    Distance(int dist) {
        this.dist = dist;
    }
}