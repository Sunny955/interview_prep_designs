package org.lld.prep.reentrant_locking_threads;

import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock lock = new ReentrantLock();
//        SharedResource s1 = new SharedResource();
//        Thread t1 = new Thread(() -> {
//            s1.produce(lock);
//        });
//
//        SharedResource s2 = new SharedResource();
//        Thread t2 = new Thread(() -> {
//            s2.produce(lock);
//        });
//
//        t1.start();
//        t2.start();

        Thread t1 = new Thread(() -> {
            for(int i=0;i<3;i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        });

        t1.start();
        t1.join();
        System.out.println("Running main thread: "+ Thread.currentThread().getName());
    }
}
