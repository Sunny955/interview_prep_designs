package org.lld.prep.design_patterns.decorator_pattern;

public class ConsoleLogger extends LoggerDecorator {
    public ConsoleLogger(Logger logger) {
        super(logger);
    }

    public void log(String message) {
        decoratedLogger.log("Console logger: "+message);
    }
}
