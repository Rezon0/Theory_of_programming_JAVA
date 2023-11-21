package org.example;

import jakarta.persistence.OptimisticLockException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Item.class)
            .buildSessionFactory();


    public static void main(String[] args) throws InterruptedException {
        Session session = sessionFactory.openSession();
        var t = session.beginTransaction();
        for (int i = 0; i < 40; i++) {
            session.persist(new Item());
        }
        t.commit();
        long startTime = System.currentTimeMillis();
        optimisticWrite();
        System.out.println("optimistic time " + (System.currentTimeMillis() - startTime) + " мс");


        sessionFactory.close();
    }

    public static void optimisticWrite() throws InterruptedException {
        int threadAmount = 8;
        Thread[] threads = new Thread[threadAmount];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 20000; j++)
                {
                    Session session = sessionFactory.openSession();
                    var t = session.beginTransaction();
                     try {
                            Long randomRow = (long) ((Math.random() * 40) + 1);

                            Item item = session.get(Item.class, randomRow);
                            item.setValue(item.getValue() + 1);
                            //session.persist(item);
                            t.commit();
                            //System.out.println(Thread.currentThread().getName() + " commited");
                        } catch (OptimisticLockException | HibernateException e) {
                         j--;
                            t.rollback();
                            //System.out.println(Thread.currentThread().getName() + " rollback");
                            //e.printStackTrace();
                            //System.err.println("in " + Thread.currentThread().getName() + " " + e.getMessage());
                        }

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    session.close();

                }
            }, "Thread " + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

}