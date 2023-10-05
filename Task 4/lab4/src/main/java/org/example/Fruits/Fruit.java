package org.example.Fruits;

public abstract class Fruit {
    private double weight = 0;

    public Fruit(double weight){
        this.weight = weight;
    }
    public double Weight() {
        return weight;
    }
}
