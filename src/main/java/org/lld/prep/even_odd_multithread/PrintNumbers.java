package org.lld.prep.even_odd_multithread;

public class PrintNumbers {
    private int num = 1;
    private final int limit;

    public PrintNumbers(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while(num <= limit) {
            while(num%2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(num <= limit) {
                System.out.println("Odd: "+num);
                num++;
            }
            notify();
        }
    }

    public synchronized void printEven() {
        while(num <= limit) {
            while(num%2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(num <= limit) {
                System.out.println("Even: "+num);
                num++;
            }
            notify();
        }
    }
}
