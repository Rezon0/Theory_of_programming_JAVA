package org.example;

import org.example.birds.Bird;
import org.example.birds.Chicken;
import org.example.birds.Eagle;
import org.example.birds.Hummingbird;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Animal[] animals = {new Cat("Барсик", 5, 200, 0),
                new Dog("Барс", 10, 300, 6),
                new Tiger("Герда", 7, 400, 10),
                new Eagle("Орел", 5, 10, 1)
        };

        Bird[] birds = {new Eagle("Орел", 5, 10, 1),
                new Chicken("Курица", 2, 44, 2),
                new Hummingbird("Колибри", 2, 32, 3),
                new Hummingbird("Колибри2", 2, 32, 3)};

        System.out.println();

        for (Animal a : animals) {
            a.run(300);
            a.swim(10);
        }

        System.out.println();

        for (Bird a : birds) {
            a.run(300);
            a.swim(10);
        }

        System.out.println();

        birds[0].flightAltitude();
        birds[1].flightAltitude();
        birds[2].flightAltitude();

        System.out.println();

        System.out.println("Количество котов: " + Cat.getCount());
        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество тигров: " + Tiger.getCount());
        System.out.println("Количество орлов: " + Eagle.getCount());
        System.out.println("Количество куриц: " + Chicken.getCount());
        System.out.println("Количество колибри: " + Hummingbird.getCount());

        ((Bird) animals[3]).flightAltitude();
    }
}