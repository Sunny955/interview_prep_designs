package org.lld.prep.even_odd_multithread;

public class EvenOddThread {
    public static void main(String[] args) {
        int limit = 10;
        PrintNumbers pn = new PrintNumbers(limit);

        Thread t1 = new Thread(pn::printEven);
        Thread t2 = new Thread(pn::printOdd);

        t1.start();
        t2.start();
    }
}
