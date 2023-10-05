package org.example;

public class GenBox <T, S> {

    T obj;
    S obj2;

    public GenBox(T obj, S obj2){
        this.obj = obj;
        this.obj2 = obj2;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void inf0(){
        System.out.println("Тип T: " + obj.getClass().getName());
    }
}
