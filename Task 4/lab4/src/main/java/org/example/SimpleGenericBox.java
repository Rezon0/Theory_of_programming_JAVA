package org.example;

public class SimpleGenericBox <T> {

    T obj;

    public SimpleGenericBox(T obj){
        this.obj = obj;
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
