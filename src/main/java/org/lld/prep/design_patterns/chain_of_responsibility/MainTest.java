package org.lld.prep.design_patterns.chain_of_responsibility;

public class MainTest {
    public static void main(String[] args) {
        SupportHandler level1 = new L1Support();
        SupportHandler level2 = new L2Support();
        SupportHandler level3 = new L3Support();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        Request r1 = new Request(Priority.BASIC);
        Request r2 = new Request(Priority.CRITICAL);
        Request r3 = new Request(Priority.INTERMEDIATE);

        level1.handleRequest(r1);
        level1.handleRequest(r2);
        level1.handleRequest(r3);
    }
}
