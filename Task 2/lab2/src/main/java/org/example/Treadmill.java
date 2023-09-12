package org.example;

public class Treadmill implements Obstacle{
    int maxDist;
    Treadmill(int maxDist){
        this.maxDist = maxDist;
    }

  public  boolean isCan(Member member){
        if (member.run(maxDist)){
            System.out.println(member.getName() + " пробежал");
            return true;
        }else{
            System.out.println(member.getName() + " не пробежал");
            return false;
        }
    }
}
