package org.example.Fruits;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList <T> fruits = new ArrayList<>();

    public boolean isBoxFlag() {
        return boxFlag;
    }

    private boolean boxFlag = true;
    public Box(Class fruit){
        if(Banana.class.equals(fruit))
            boxFlag = false;
    }
    public void add(T fruit)
    {
        fruits.add(fruit);
    }

    public double getWeight(){
        double result = 0.0;
        for (T item: fruits) {
            result += item.Weight();
        }
        return result;
    }
    public boolean Compare(Box box){
        if(Math.abs((box.getWeight() - getWeight())) < 0.0001) return true;
        else return false;
    }

    public void Pour (Box<T> box){
       // boolean flag = true;
       // int count = 0;
//
//        for (int i = 0; i < fruits.size(); i++)
//            if (Banana.class.equals(fruits.get(i).getClass())){ // проверяем принадлежит ли элемент классу "банан"
//                flag = false; // если да, то flag опускаем
//            }else if (Apple.class.equals(fruits.get(i).getClass()) || Orange.class.equals(fruits.get(i).getClass()))
//                  count++;


        //if(flag == true){   // если не принадлежит банану

        if(this.equals(box) != true) { // проверяем на пересыпку в самого себя
            if (boxFlag == true) {
                if (box.isBoxFlag() == true && fruits.get(0).getClass().equals(box.fruits.get(0).getClass())) {
                    for (T item : fruits) {  // то тупо добавляем в box.fruits все элементы
                        box.fruits.add(item);
                    }
                    fruits.clear(); // и очищаем их из исходной коробки
                }
            } else {    // если коробка банановая
                if (box.isBoxFlag() == false) {
                    for (int i = fruits.size() - 1; i >= 0; i--)
                        if (Banana.class.equals(fruits.get(i).getClass())) {
                            box.fruits.add(fruits.get(i));  // добавляем бананы в box.fruits
                            fruits.remove(i);   // удаляем их из исходной коробки
                        }
                }
            }
        }else System.out.println("Нельзя пересыпать в самого себя!");
    }

    public void PrintBox (){
        for (T item: fruits) {
            System.out.println(item);
        }
    }
}
