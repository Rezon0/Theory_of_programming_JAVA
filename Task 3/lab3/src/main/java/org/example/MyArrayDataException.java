package org.example;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j, String val) {
        super("Неккоректный символ на " + i + " строке и " + j + " столбце");
    }

}
