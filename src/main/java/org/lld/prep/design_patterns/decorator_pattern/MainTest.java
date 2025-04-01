package org.lld.prep.design_patterns.decorator_pattern;

public class MainTest {
    public static void main(String[] args) {
        Logger basicLogger = new BasicLogger();

        Logger consoleLogger = new ConsoleLogger(basicLogger);

        Logger fileLogger = new FileLogger(consoleLogger);

        Logger fullLogger = new EncryptedLogger(fileLogger);

        System.out.println("Basic Logging:");
        basicLogger.log("Hello World");

        System.out.println("\nBasic Console Logging:");
        consoleLogger.log("Hello, You!");

        System.out.println("\nFile and Console Logging:");
        fileLogger.log("Saving to file and console");

        System.out.println("\nEncrypted, File, and Console Logging:");
        fullLogger.log("Secret message");
    }
}
