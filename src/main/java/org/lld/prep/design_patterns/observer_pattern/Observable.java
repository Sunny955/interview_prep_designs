package org.lld.prep.design_patterns.observer_pattern;

public interface Observable {
    void addObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifyObservers();
}
