package org.lld.prep.functional_interface;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

@FunctionalInterface
interface CustomFunction<T extends Number> {
    T apply(T a,T b);

    default void print() {
        System.out.println("This is a functional interface!");
    }

    static void info() {
        System.out.println("Functional interfaces can have static methods.");
    }
}

public class MainClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CustomFunction<Double> add = (a,b) -> a+b;
        CustomFunction<Integer> subtract = (a,b)->a-b;
        CustomFunction<Float> mult = (a,b)->a*b;

        double ans = add.apply(29.7,19.0);
        int ans1 = subtract.apply(19,2);
        float ans2 = mult.apply(19.4f, 17.2f);

        System.out.println("Ans: "+ans);
        System.out.println("Ans1: "+ans1);
        System.out.println("Ans2: "+ans2);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,10, TimeUnit.MINUTES,new ArrayBlockingQueue<>(5),new CustomizableThreadFactory());

        // Runnable
        Future<?> obj1 = poolExecutor.submit(() -> System.out.println("Running!"));

        // Callable
        Future<Integer> obj2 = poolExecutor.submit(() -> {
            return 19;
        });

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 29;
        }, poolExecutor);

        future1.thenAccept(val -> System.out.println("Callable task completed with value: " + val));

        obj1.get();
        int val = obj2.get();

        System.out.println("Value: "+val);

        System.out.println("Main thread here: "+Thread.currentThread().getName());
    }
}
