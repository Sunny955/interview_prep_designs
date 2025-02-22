package org.lld.prep.read_write_lock_multithread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {
    public static void main(String[] args) {
        SharedResource s1 = new SharedResource();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(() -> {
            s1.produce(readWriteLock);
        });

        Thread t2 = new Thread(() -> {
            s1.produce(readWriteLock);
        });

        SharedResource s2 = new SharedResource();
        Thread t3 = new Thread(() -> {
            s2.consume(readWriteLock);
        });

        Thread t4 = new Thread(() -> {
           s2.consume(readWriteLock);
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
