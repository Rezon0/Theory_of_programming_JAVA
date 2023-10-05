package org.example;

public class SimpleBox {

    Object obj;

    public SimpleBox(Object obj){
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void inf0(){
        System.out.println("Тип T: " + obj.getClass().getName());
    }
}
