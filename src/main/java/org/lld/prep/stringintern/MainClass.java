package org.lld.prep.stringintern;

public class MainClass {
    public static void main(String[] args) {
        String str = new String("Bhasad");

        System.out.println("STR: "+str);
        System.out.println("STR Intern: "+str.intern());

        String str2 = str.intern();


    }
}
