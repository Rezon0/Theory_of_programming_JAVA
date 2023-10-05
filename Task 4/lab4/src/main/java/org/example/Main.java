package org.example;

import org.example.Fruits.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*SimpleBox intBox1 = new SimpleBox(1);
        SimpleBox intBox2 = new SimpleBox(2);
        SimpleBox stringBox1 = new SimpleBox("qrew");

        SimpleGenericBox<String> stringGenericBox = new SimpleGenericBox<>("dfgdfg");
        stringGenericBox.setObj("jjjj");

        intBox1.setObj("ggg");

        if(intBox1.getObj() instanceof Integer){
            int sum = (Integer) intBox1.getObj() + (Integer) intBox2.getObj();
            System.out.println(sum);
        }

        BoxWithNumber<Integer> intBox = new BoxWithNumber<>(1,2,3,4,5);
        System.out.println(intBox.average());
        System.out.println(intBox.compareAverage(intBox, 0.0001));*/

        // ================ Задача 1 ================

        Integer[] array1 = new Integer[]{1, 2, 3, 4, 5};
        System.out.println("Массив до: ");
        for(int i = 0; i < array1.length; i++)
            System.out.print(array1[i] + " ");

        swapFirstEnd(array1);
        System.out.println("\nМассив после: ");
        for(int i = 0; i < array1.length; i++)
            System.out.print(array1[i] + " ");

        System.out.println();
        // ================ Задача 2 ================

        Integer[] array2 = new Integer[] {9, 8, 7, 6, 5, 4};
        Arrays.asList(array2);
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array2));

        // ================ Задача 3 ================

        Box<Apple> boxApples = new Box<>(Apple.class);
        boxApples.add(new Apple());
        boxApples.add(new Apple());
        boxApples.add(new Apple());

        Box<Orange> boxOrange = new Box<>(Orange.class);
        boxOrange.add(new Orange());
        boxOrange.add(new Orange());

        System.out.println("\nОбщий вес яблок в ящике 1: " + boxApples.getWeight() + "\n");
        System.out.println("Общий вес апельсинов в ящике 2: " + boxOrange.getWeight() + "\n");

        if(boxApples.Compare(boxOrange))
            System.out.println("Массы ящиков равны");
        else System.out.println("Массы ящиков не равны");

        Box<Apple> boxApples2 = new Box<>(Apple.class);
        boxApples2.add(new Apple());
        boxApples2.add(new Apple());
        System.out.println("\nОбщий вес яблок в ящике 3: " + boxApples2.getWeight() + "\n");

        System.out.println("*Перекладываем яблоки из ящика 1 в ящик 3*");
        boxApples.Pour(boxApples2);
        System.out.println("\nОбщий вес яблок в ящике 1: " + boxApples.getWeight() + "\n");
        System.out.println("Общий вес яблок в ящике 3: " + boxApples2.getWeight() + "\n");

        System.out.println("Экземпляры ящика 3: ");
        boxApples2.PrintBox();

        Box<Fruit> boxBananas = new Box<>(Banana.class);
        boxBananas.add(new Banana());
        boxBananas.add(new Banana());
        boxBananas.add(new Banana());
        boxBananas.add(new Orange());

        System.out.println("\nЭкземпляры бананового ящика 1: ");
        boxBananas.PrintBox();

        Box<Fruit> boxBananas2 = new Box<>(Banana.class);
        boxBananas2.add(new Orange());
        boxBananas2.add(new Orange());
        boxBananas2.add(new Apple());

        System.out.println("\nЭкземпляры бананового ящика 2: ");
        boxBananas2.PrintBox();

        System.out.println("\n*Перекладываем бананы из бананового ящика 1 в банановый ящик 2*");

        boxBananas.Pour(boxBananas2);

        System.out.println("\nЭкземпляры бананового ящика 1 после пересыпки: ");
        boxBananas.PrintBox();

        System.out.println("\nЭкземпляры бананового ящика 2 после пересыпки: ");
        boxBananas2.PrintBox();

        boxApples2.Pour(boxApples2);

//        boxBananas2.Pour(boxBananas2);


//        System.out.println("\nЭкземпляры яблочного ящика 2 до пересыпки2: ");
//        boxApples2.PrintBox();
//
//        boxApples2.Pour(boxBananas2);
//        System.out.println("\nЭкземпляры бананового ящика 2 после пересыпки2: ");
//        boxBananas2.PrintBox();
//
//        System.out.println("\nЭкземпляры яблочного ящика 2 после пересыпки2: ");
//        boxApples2.PrintBox();
//
//
//        boxBananas2.Pour(boxApples2);
//        System.out.println("\nЭкземпляры бананового ящика 2 после пересыпки3: ");
//        boxBananas2.PrintBox();
//
//        System.out.println("\nЭкземпляры яблочного ящика 2 после пересыпки3: ");
//        boxApples2.PrintBox();


        Box<Fruit> boxFruit = new Box<>(Banana.class);
        boxFruit.add(new Apple());

    }

    static void swapFirstEnd(Integer[] array1){
        Integer val = array1[0];

        array1[0] = array1[array1.length-1];
        array1[array1.length-1] = val;

    }
}