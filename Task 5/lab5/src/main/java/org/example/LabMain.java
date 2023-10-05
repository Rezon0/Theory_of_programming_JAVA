package org.example;

public class LabMain {
    public static void main(String args[]) {
        Dictionary dictionary = new Dictionary();
        dictionary.add("Sweet", "Сладкий");
        dictionary.add("Sweet", "Конфетка");

        dictionary.add("Honey", "Мёд");
        dictionary.add("Honey", "Дорогой");
        dictionary.add("Honey", "Сладенький");

        dictionary.add("Sweet", "Дорогой");
        dictionary.add("Honey", "Дорогой");


        dictionary.get("Honey");
        dictionary.get("Sweet");

        dictionary.get("Alexey");

        dictionary.get();

        System.out.println();
        System.out.println();

        test test1 = new test();
        test1.add("Sweet", "Сладкий");
        test1.add("Sweet", "Конфетка");

        test1.add("Honey", "Мёд");
        test1.add("Honey", "Дорогой");
        test1.add("Honey", "Сладенький");

        test1.add("Sweet", "Дорогой");
        test1.add("Honey", "Дорогой");

        test1.get();
    }
}
