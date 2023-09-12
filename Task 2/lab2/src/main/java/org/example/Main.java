package org.example;

public class Main {
    public static void main(String[] args) {
        Member[] members = {new Cat("Барсик", 50, 3),
                         new Human("Алексей", 500, 1),
                         new Robot("R2D2", 10, 0),
                        new Robot("R2D3", 10, 0),
                        new Robot("R2D4", 10, 0),
                        new Robot("R2D5", 10, 0)};

        Obstacle[] obstacle = {new Treadmill(Distance.SHORT.getDist()), new Treadmill(Distance.LONG.getDist()), new Treadmill(Distance.LONG.getDist())};

        for (Member memb: members) {
            for (Obstacle obs : obstacle) {
                if (!obs.isCan(memb)) {
                    break;
                }
            }
        }
    }
}