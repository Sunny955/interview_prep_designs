package org.lld.prep.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleTaskExecution {
    public void execute() {
        // Factory method to create a executor service
        ExecutorService service = Executors.newFixedThreadPool(2);

        CompletableFuture<List<String>> fetchUserData = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList("User1", "User2");
        }, service);

        CompletableFuture<List<String>> fetchProductData = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList("Product1", "Product2");
        }, service);

        // Combine two
        CompletableFuture<List<String>> output = fetchUserData.thenCombine(fetchProductData, (users, products) -> {
            List<String> ans = new ArrayList<>();
            for(int i=0;i<users.size();i++) {
                ans.add(users.get(i) + "bought "+ products.get(i));
            }
            return ans;
        });

        output.thenAccept((list) -> {
            list.forEach(System.out::println);
        });

        System.out.println("Doing other work while fetching data for main thread...");

        service.shutdown();
    }
}
