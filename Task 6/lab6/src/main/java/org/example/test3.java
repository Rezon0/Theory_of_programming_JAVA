package org.example;

import java.util.Arrays;

public class test3
{
    private static final int SIZE = 40_000_004;
    private static final int HALF = SIZE / 2;
    private static int threadCount = 5;

    public static void main(String[] args)
    {
        float[] thread1 = methodThread1();
        float[] thread2 = methodThread2();
        float[] threads = methodThread3();

        System.out.println("Значение первого элемента 1 методом: " + thread1[0]);
        System.out.println("Значение первого элемента 2 методом: " + thread2[0]);
        System.out.println("Значение первого элемента 3 методом: " + threads[0]);

        System.out.println("Значение последнего элемента 1 методом: " + thread1[SIZE - 1]);
        System.out.println("Значение последнего элемента 2 методом: " + thread2[SIZE - 1]);
        System.out.println("Значение последнего элемента 3 методом: " + threads[SIZE - 1]);
    }

    private static float[] methodThread3()
    {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);

        long a = System.currentTimeMillis();
        int partSize = SIZE / threadCount;
        int remainder = SIZE % threadCount;

        Thread[] threads = new Thread[threadCount];
        float[][] parts = new float[partSize][threadCount];
        int sourcePosition = 0;

        for (int i = 0; i < threadCount; i++)
        {
            float[] arrayPart = new float[partSize + (i == 0 ? remainder : 0)];
            System.out.println("Длина подмассива для потока " + (i + 1) + "равна: " + arrayPart.length);

            System.arraycopy(array, sourcePosition, arrayPart, 0, arrayPart.length);

            int offset = sourcePosition;
            int finalI = i;
            sourcePosition += arrayPart.length;

            threads[i] = new Thread(() -> {
                for (int j = 0; j < arrayPart.length; j++)
                {
                    arrayPart[j] = (float) (arrayPart[j] * Math.sin(0.2f + (j + offset) / 5) * Math.cos(0.2f + (j + offset) / 5) * Math.cos(0.4f + (j + offset) / 2));
                }
                parts[finalI] = arrayPart;
            });

            threads[i].start();
        }

        sourcePosition = 0;

        for (int i = 0; i < threadCount; i++)
        {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.arraycopy(parts[i], 0, array, sourcePosition, parts[i].length);
            sourcePosition += parts[i].length;
        }

        System.out.println("Время 3 методом: " + (System.currentTimeMillis() - a));

        return array;
    }

    private static float[] methodThread2()
    {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);

        long startTime = System.currentTimeMillis();

        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[HALF];

        System.arraycopy(array, 0, firstHalf, 0, HALF);
        System.arraycopy(array, HALF, secondHalf, 0, HALF);

        Thread firstHalfCalculation = new Thread(() -> {
            for (int i = 0; i < HALF; i++)
            {
                firstHalf[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread secondHalfCalculation = new Thread(() -> {
            for (int i = 0; i < HALF; i++)
            {
                secondHalf[i] = (float) (array[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
        });

        firstHalfCalculation.start();
        secondHalfCalculation.start();

        try
        {
            firstHalfCalculation.join();
            secondHalfCalculation.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.arraycopy(firstHalf, 0, array, 0, HALF);
        System.arraycopy(secondHalf, 0, array, HALF, HALF);

        System.out.println("Время 2 методом: " + (System.currentTimeMillis() - startTime));

        return array;
    }

    private static float[] methodThread1()
    {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++)
        {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время 1 методом: " + (System.currentTimeMillis() - startTime));

        return array;
    }
}
