package org.lld.prep.design_patterns.observer_pattern;

public class MainTest {
    public static void main(String[] args) {
        Product iphone = new Product("iPhone 15 Pro");

        // Users subscribe to notifications
        Observer user1 = new User("Alice");
        Observer user2 = new User("Bob");

        iphone.addObserver(user1);
        iphone.addObserver(user2);

        System.out.println("Product is currently out of stock.");

        iphone.stockIn(10);
        iphone.stockIn(100);
    }
}
