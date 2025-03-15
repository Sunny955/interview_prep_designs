package org.lld.prep.design_patterns.state_design_pattern;

public class ConcreteState2 implements StateInterface {

    @Override
    public void handleRequest() {
        System.out.println("Product selected state: Processing payment.");
    }
    
}
