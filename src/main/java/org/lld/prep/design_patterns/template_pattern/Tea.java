package org.lld.prep.design_patterns.template_pattern;

public class Tea extends Beverage{
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
