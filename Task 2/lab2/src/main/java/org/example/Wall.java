package org.example;

public class Wall implements Obstacle{
    int maxHeight;

    Wall(int maxHeight){
        this.maxHeight = maxHeight;
    }

    @Override
   public boolean isCan(Member member){
        if (member.jump(maxHeight)){
            System.out.println(member.getName() + " перепрыгнул");
            return true;
        }else{
            System.out.println(member.getName() + " не перепрыгнул");
            return false;
        }
    }
}
