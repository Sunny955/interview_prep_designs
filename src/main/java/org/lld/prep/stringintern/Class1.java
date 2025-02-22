package org.lld.prep.stringintern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Class1 {
    @Autowired
    private Paat paat;
    public Class1() {
        System.out.println("Daali!");
    }
}
