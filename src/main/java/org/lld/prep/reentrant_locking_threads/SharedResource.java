package org.lld.prep.reentrant_locking_threads;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    public void produce(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("Lock acquired by: "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        } catch (Exception e) {

        } finally {
            lock.unlock();
            System.out.println("Lock released by: "+Thread.currentThread().getName());
        }
    }
}
