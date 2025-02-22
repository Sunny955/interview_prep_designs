package org.lld.prep.multiinheritence;

public interface Animals {
    public default void breathe() {
        System.out.println("Animals breathe!");
    }
}
