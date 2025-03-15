package org.lld.prep.design_patterns.state_design_pattern;

public class StateContext {
    private StateInterface stateInterface;

    public void setState(StateInterface st) {
        this.stateInterface = st;
    }

    public void request() {
        stateInterface.handleRequest();
    }
}
