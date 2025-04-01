package org.lld.prep.design_patterns.decorator_pattern;

public class FileLogger extends LoggerDecorator {
    public FileLogger(Logger logger) {
        super(logger);
    }

    public void log(String message) {
        decoratedLogger.log("File Logger: "+message);
    }
}
