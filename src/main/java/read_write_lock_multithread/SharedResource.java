package read_write_lock_multithread;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {
    boolean isAvailable = true;
    public void produce(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by: "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by: "+Thread.currentThread().getName());
        }
    }
    public void consume(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by: "+Thread.currentThread().getName());
            isAvailable = true;
        } catch (Exception e) {

        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by: "+Thread.currentThread().getName());
        }
    }
}
