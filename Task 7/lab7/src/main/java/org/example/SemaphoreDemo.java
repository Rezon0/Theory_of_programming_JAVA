package org.example;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main (String[] args) {
        Semaphore smp = new Semaphore( 2) ;
        for (int i = 0; i < 5; i++) {
        final int w = i;
        new Thread(() -> {
            try {
                System.out.println( "Поток " + w + " перед семафором" );
                smp.acquire();
                System.out.println( "Поток " + w + " получил доступ к ресурсу" );
                Thread.sleep( 500) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println( "Поток " + w + " освободил ресурс" );
                smp.release();
            }
        }).start();
        }
    }
}