package org.lld.prep.design_patterns.chain_of_responsibility;

public class L1Support implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.BASIC) {
            System.out.println("Level 1 Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(SupportHandler supportHandler) {
        this.nextHandler = supportHandler;
    }
    
}
