package org.lld.prep.design_patterns.decorator_pattern;

public class EncryptedLogger extends LoggerDecorator {
    public EncryptedLogger(Logger logger) {
        super(logger);
    }
    public void log(String message) {
        decoratedLogger.log("Encrypted logger: "+message);
    }
}
