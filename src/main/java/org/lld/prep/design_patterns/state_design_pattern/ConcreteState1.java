package org.lld.prep.design_patterns.state_design_pattern;

public class ConcreteState1 implements StateInterface{
    @Override
    public void handleRequest() {
        System.out.println("Ready state: Please select a product.");
    }
}
