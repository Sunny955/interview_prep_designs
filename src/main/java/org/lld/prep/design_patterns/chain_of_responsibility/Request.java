package org.lld.prep.design_patterns.chain_of_responsibility;

public class Request {
    private Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}
