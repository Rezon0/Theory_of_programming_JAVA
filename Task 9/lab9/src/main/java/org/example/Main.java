package org.example;


public class Main {
    public static void main(String[] args) throws Exception {
        Eagle eagle = new Eagle("Орел1", 2, Eagle.Types.КРАСИВЫЙ);
        Eagle eagle1 = new Eagle("Орел2", 3, Eagle.Types.БОЛЬШОЙ);
        Eagle eagle2 = new Eagle("Орел3", 1, Eagle.Types.КРУТОЙ);
        Annotation.createTable(eagle);
        Annotation.insertIntoTable(eagle);
        Annotation.insertIntoTable(eagle1);
        Annotation.insertIntoTable(eagle2);
    }
}