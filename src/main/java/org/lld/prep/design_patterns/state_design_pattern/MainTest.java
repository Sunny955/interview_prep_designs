package org.lld.prep.design_patterns.state_design_pattern;

public class MainTest {
    public static void main(String[] args) {
        StateContext st = new StateContext();
        
        st.setState(new ConcreteState1());

        st.request();

        st.setState(new ConcreteState2());

        st.request();

        st.setState(new ConcreteState3());

        st.request();
    }
}
