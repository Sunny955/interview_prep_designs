package org.lld.prep.design_patterns.chain_of_responsibility;

public class L3Support implements SupportHandler {

    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.CRITICAL) {
            System.out.println("Level 3 Support handled the request");
        } else {
            System.out.println("Request can't be handled!");
        }
    }

    @Override
    public void setNextHandler(SupportHandler supportHandler) {
        // no implementation
    }
    
}
