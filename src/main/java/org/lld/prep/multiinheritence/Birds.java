package org.lld.prep.multiinheritence;

public interface Birds {
    public default void breathe() {
        System.out.println("Bird breathe!");
    }
}
