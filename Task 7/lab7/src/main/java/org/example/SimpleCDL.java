package org.example;

import java.util.concurrent.CountDownLatch;

public class SimpleCDL {
    public static void main (String[] args) {
        final int THREADS_COUNT = 6; // задаем количество потоков
        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT); // задаем значение счетчика
        System.out.println( "Начинаем");
        for ( int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                Thread.sleep( 500 + ( int )(500 * Math.random())); // считаем, что выполнение задачи занимает ~1 сек
                cdl.countDown(); // как только задача выполнена, уменьшаем счетчик
                System.out.println( "Поток #" + w + " - готов");
                } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }).start();
        }
        try {
            cdl.await();
            // пока счетчик не приравняется нулю, будем стоять на этой строке
        } catch (InterruptedException e) { e.printStackTrace();
        }
        // как только все потоки выполнили свои задачи - пишем сообщение
        System.out.println( "Работа завершена" );
    }
}