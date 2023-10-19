package org.example;
import java.util.SortedSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static String winner = "";
    private static int winnerFound = 2;

    static {
        CARS_COUNT = 0;
    }
    private CyclicBarrier cb;
    private CountDownLatch cdl;
    private Race race;
    private int speed;
    private String name;
    public String getName () {
        return name;
    }
    public int getSpeed () {
        return speed;
    }
    public Car (Race race, int speed, CyclicBarrier cb, CountDownLatch cdl) {
        this .race = race;
        this .speed = speed;
        CARS_COUNT++;
        this .name = "Участник #" + CARS_COUNT;
        this.cb = cb;
        this.cdl = cdl;
    }
    @Override
    public void run () {
        try {
            System.out.println( this .name + " готовится" );
            Thread.sleep( 500 + ( int )(Math.random() * 800)) ;
            System.out.println( this .name + " готов" );
            cb.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go( this );
            }
            cdl.countDown();
            CheckWin(this);
        } catch (Exception e) {
            e.printStackTrace(); }
    }
    private  static void CheckWin(Car car) {
        if (winnerFound >= 0) {
            Main.atomic[winnerFound].set(Integer.parseInt(car.name.substring(car.name.length() - Main.numbersCount, car.name.length())));
            winnerFound--;
        }
    }

    public static void printWinner(){
        int count = 1;
        for(int i = 2; i >= 0; i--) {
            System.out.println("Пластмассовый мир победил, участник " + Main.atomic[i] + " оказался на месте " + count);
            count++;
        }
    }
}
