package org.lld.prep.design_patterns.chain_of_responsibility;

public interface SupportHandler {
    void handleRequest(Request request);
    void setNextHandler(SupportHandler supportHandler);
}
