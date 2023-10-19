package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static final int CARS_COUNT = 5;
    public static AtomicInteger[] atomic = new AtomicInteger[3];
    public static int numbersCount = (int) Math.ceil(Math.log10(CARS_COUNT));

    public static final int TONNEL_LIMIT = 3;


    public static void main(String[] args) {
        for(int i = 0; i < 3; i++)
            atomic[i] = new AtomicInteger();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdl);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cdl.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            System.out.println();
            Car.printWinner();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}