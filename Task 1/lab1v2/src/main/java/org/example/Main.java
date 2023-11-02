package org.example;

import org.example.birds.Bird;
import org.example.birds.Chicken;
import org.example.birds.Eagle;
import org.example.birds.Hummingbird;
import org.example.insects.Ant;
import org.example.insects.Butterfly;
import org.example.insects.Dragonfly;
import org.example.insects.Insect;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Animal[] animals = {new Cat("Барсик", 5, 200, 0),
                new Dog("Барс", 10, 300, 6),
                new Tiger("Герда", 7, 400, 10),
                new Eagle("Орел", 5, 10, 1),
                new Eagle("Орел", 5, 10, 1),
                new Chicken("Курица", 2, 44, 2),
                new Hummingbird("Колибри", 2, 32, 3),
                new Hummingbird("Колибри2", 2, 32, 3),
                new Ant("Великан", 4, 200, 0),
                new Dragonfly("Драко", 5, 300, 6),
                new Butterfly("Жуля", 4, 400, 10),
                new Butterfly("Пуля", 4, 10, 1)
        };

//        Bird[] birds = {new Eagle("Орел", 5, 10, 1),
//                new Chicken("Курица", 2, 44, 2),
//                new Hummingbird("Колибри", 2, 32, 3),
//                new Hummingbird("Колибри2", 2, 32, 3)};
//
//        Insect[] insects = {new Ant("Великан", 4, 200, 0),
//                new Dragonfly("Драко", 5, 300, 6),
//                new Butterfly("Жуля", 4, 400, 10),
//                new Butterfly("Пуля", 4, 10, 1)
//        };

        System.out.println();

        for (Animal a : animals) {
            a.run(30);
            a.swim(10);
        }

        System.out.println();

//        for (Bird a : birds) {
//            a.run(30);
//            a.swim(10);
//        }
//
//        System.out.println();
//
//        for (Insect a : insects) {
//            a.run(300);
//            a.swim(10);
//        }

        System.out.println();

//        animals[0].flightAltitude();
//        animals[1].flightAltitude();
//        animals[2].flightAltitude();


        ((Insect) animals[11]).lifespan();
//        insects[1].lifespan();
//        insects[2].lifespan();

        System.out.println();

        System.out.println("Количество котов: " + Cat.getCount());
        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество тигров: " + Tiger.getCount());
        System.out.println("Количество орлов: " + Eagle.getCount());
        System.out.println("Количество куриц: " + Chicken.getCount());
        System.out.println("Количество колибри: " + Hummingbird.getCount());

        System.out.println("Количество муравьев: " + Ant.getCount());
        System.out.println("Количество стрекоз: " + Dragonfly.getCount());
        System.out.println("Количество мух: " + Butterfly.getCount());
    }
}