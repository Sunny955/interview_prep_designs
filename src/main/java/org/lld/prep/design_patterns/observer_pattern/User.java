package org.lld.prep.design_patterns.observer_pattern;

public class User implements Observer{
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName) {
        System.out.println("Hello " + name + ", " + productName + " is now back in stock!");
    }
    
}
