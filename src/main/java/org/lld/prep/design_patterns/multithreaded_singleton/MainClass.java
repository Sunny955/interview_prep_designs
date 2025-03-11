package org.lld.prep.design_patterns.multithreaded_singleton;

// Bill Pugh method for singleton (Lazy Initialization)

/*
The JVM ensures that a class is loaded only once.
When the SingletonHelper class is loaded, the INSTANCE field is initialized
, and no other threads can interfere with this process.
 */
class MultithreadedSingleton {
    static int count = 0;
    public void showDalli() {
        count++;
        System.out.println("Dalli Gym jaun hu!:"+ count);
    }
    private MultithreadedSingleton() {
        super();
    }

    private static class MultithreadedSingletonHelper {
        private MultithreadedSingletonHelper() {
            super();
        }
        private static final MultithreadedSingleton instance = new MultithreadedSingleton();
    }

    public static MultithreadedSingleton getInstance() {
        return MultithreadedSingletonHelper.instance;
    }
}

public class MainClass {
    public MainClass() {
        super();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            MultithreadedSingleton multithreadedSingleton = MultithreadedSingleton.getInstance();
//            try {
//                Thread.sleep(2000);
//            }catch (Exception e) {
//
//            }
            multithreadedSingleton.showDalli();
        });

        Thread t2 = new Thread(() -> {
            MultithreadedSingleton multithreadedSingleton = MultithreadedSingleton.getInstance();
//            try {
//                Thread.sleep(2000);
//            }catch (Exception e) {
//
//            }
            multithreadedSingleton.showDalli();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
