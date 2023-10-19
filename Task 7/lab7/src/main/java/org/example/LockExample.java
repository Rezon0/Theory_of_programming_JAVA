package org.example;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
        // множество читателей может зайти в эту секцию,
        // если нет записывающих потоков
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock().lock();
        // только один поток-писатель может зайти в эту секцию,
        // при условии, что ни один из потоков не занимается чтением
        readWriteLock.writeLock().unlock();
    }
}
