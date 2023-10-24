package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String gender;
    private int salary;
    public Employee(String name, int age, String gender, int salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void magicMethod(Employee[] personal){
        int numberEmployes = 3;

//        List<String> topEmployees = Arrays.stream(personal)
//                .filter(e -> e.getGender().equals("Male"))
//                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
//                .limit(numberEmployes)
//                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
//                .map(Employee::getName)
//                .collect(Collectors.toList());

        System.out.println(numberEmployes + " самых старших сотрудников зовут: " + String.join(", ",
                Arrays.stream(personal)
                .filter(e -> e.getGender().equals("Male"))
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(numberEmployes)
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList())) + ";");
    }

    public static void main(String[] args) {

        //=================== Задание 1 ===================

        String[] words = {"молодец", "молодец", "молодец", "савелий", "алексей", "алексей", "алексей", "Alex", "Alex", "Alex"};

//        int maxFrequency = Arrays.stream(words)
//                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .map(Map.Entry::getValue)
//                .max(Long::compare)
//                .orElse(0L)
//                .intValue();
//
//        String[] mostFrequentWords = Arrays.stream(words)
//                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue().intValue() == Arrays.stream(words)
//                        .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
//                        .entrySet()
//                        .stream()
//                        .map(Map.Entry::getValue)
//                        .max(Long::compare)
//                        .orElse(0L)
//                        .intValue())
//                .map(Map.Entry::getKey)
//                .sorted()
//                .toArray(String[]::new);


        System.out.println("Самые повторяющиеся слова:");
        Arrays.stream(Arrays.stream(words)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().intValue() == Arrays.stream(words)
                        .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .map(Map.Entry::getValue)
                        .max(Long::compare)
                        .orElse(0L)
                        .intValue())
                .map(Map.Entry::getKey)
                .sorted()
                .toArray(String[]::new)).forEach(System.out::println);

        System.out.println();


        //=================== Задание 2 ===================
        Employee[] persons = new Employee[]{
                new Employee("Alex", 21, "Male", 20000),
                new Employee("Oleg", 22, "Male",21000),
                new Employee("Dmitry", 22, "Male", 40000),
                new Employee("Dmitry1", 66, "Male", 160000),
                new Employee("Anton", 21, "Male", 13000),
                new Employee("Nastya", 20, "Female", 117000),
                new Employee("Olga", 19, "Female", 18000),
                new Employee("Lera", 20, "Female", 15000),
                new Employee("Alevtina", 19, "Female", 18000),
                new Employee("July", 22, "Female", 25000),
                new Employee("Uno", 19, "Female", 24000)};

        magicMethod(persons);
    }
}
