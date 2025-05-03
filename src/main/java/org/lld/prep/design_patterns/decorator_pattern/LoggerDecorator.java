package org.lld.prep.design_patterns.decorator_pattern;

abstract public class LoggerDecorator implements Logger {
    protected Logger decoratedLogger;

    public LoggerDecorator(Logger logger) {
        this.decoratedLogger = logger;
    }

    @Override
    public void log(String message) {
        
    }
}
