package org.lld.prep.design_patterns.state_design_pattern;

public class ConcreteState3 implements StateInterface{

    @Override
    public void handleRequest() {
        System.out.println("Payment pending state: Dispensing product.");
    }
    
}
