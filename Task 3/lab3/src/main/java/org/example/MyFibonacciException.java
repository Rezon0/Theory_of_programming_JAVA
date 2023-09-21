package org.example;

public class MyFibonacciException  extends RuntimeException {
    public MyFibonacciException(int i, int j, int fibbo) {
        super("Число Фибоначчи " + fibbo + " находится на " + i + " строке и " + j + " столбце");
    }
}