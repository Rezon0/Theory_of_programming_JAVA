package org.example;

public class Cat implements Member{

    int maxDist;
    int maxHeight;
    String name;

    @Override
    public boolean run(int dist) {
        if(dist <= maxDist) return true;
        else return false;
    }

    @Override
    public boolean jump(int heigth) {
        if(heigth <= maxHeight) return true;
        else return false;
    }

    Cat(String name, int maxDist, int maxHeight){
        this.maxDist = maxDist;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
