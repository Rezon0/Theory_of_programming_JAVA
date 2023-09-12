package org.example;

public class Robot implements Member{

    int maxDist;
    int maxHeight;
    String name;

    static byte superRun = 3;

    public boolean isSuperRun() {
        if(superRun > 0) {
            superRun--;
            return true;
        }
        else return false;
    }

    public boolean run(int dist) {
        if(dist <= maxDist) return true;
        else if(isSuperRun()) return true;
        else return false;
    }

    @Override
    public boolean jump(int heigth) {
        if(heigth <= maxHeight) return true;
        else return false;
    }

    Robot(String name, int maxDist, int maxHeight){
        this.maxDist = maxDist;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
