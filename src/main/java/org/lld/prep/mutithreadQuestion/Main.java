package org.lld.prep.mutithreadQuestion;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        int totalCycles = 5;

        Thread t1 = new Thread(() -> printer.printSequence("A",0, totalCycles));
        Thread t2 = new Thread(() -> printer.printSequence("B",1, totalCycles));
        Thread t3 = new Thread(() -> printer.printSequence("C",2, totalCycles));

        t1.start();
        t2.start();
        t3.start();
    }
}
