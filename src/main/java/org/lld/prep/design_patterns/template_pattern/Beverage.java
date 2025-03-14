package org.lld.prep.design_patterns.template_pattern;

public abstract class Beverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater() {
        System.out.println("Water boiling!");
    }
    void pourInCup() {
        System.out.println("Pouring in cup!");
    }
}
