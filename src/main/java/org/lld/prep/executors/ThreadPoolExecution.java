package org.lld.prep.executors;

import java.util.concurrent.*;

public class ThreadPoolExecution {
    public void execute() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Using Completable Future
        CompletableFuture<Integer> output = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        },executor);

        output.thenAccept((val) -> {
            System.out.println("Finished executing task!, value I got: " + val);
        });

        // Using Future
        Future<Integer> output1 = executor.submit(() -> {
            try {
                Thread.sleep(6000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 200;
        });

        System.out.println("Waiting here to finish the future thread working!!");

        System.out.println(output1.get());

        System.out.println("Main thread finished!"+ Thread.currentThread().getName());
        executor.shutdown();
    }
}
