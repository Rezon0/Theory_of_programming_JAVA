package org.example.insects;

import org.example.Animal;

public abstract class Insect extends Animal{
    public int averageLfe = 0;
    public Insect(String name, int age, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        averageLfe = age;
        this.maxSwimDist = maxSwimDist;
    }

    public void lifespan(){
        System.out.println("Средняя продолжительность жизни " + name + ": " +  averageLfe + " месяцев");
    }
}
