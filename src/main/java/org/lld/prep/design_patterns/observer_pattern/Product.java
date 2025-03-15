package org.lld.prep.design_patterns.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Product implements Observable {
    List<Observer> observers = new ArrayList<>();
    String productName;
    boolean isAval = false;
    private long qty = 0;

    public Product(String productName) {
        this.productName = productName;
    }

    @Override
    public void addObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for(Observer ob: observers) {
            ob.update(productName);
        }
    }

    public void stockIn(long stockInQty) {
        long prev = qty;
        qty += stockInQty;

        if(prev == 0) {
            notifyObservers();
        }
    }
    
}
