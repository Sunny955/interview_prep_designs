package org.lld.prep.design_patterns.decorator_pattern;

public class BasicLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("BasicLogger: "+message);
    }
}
