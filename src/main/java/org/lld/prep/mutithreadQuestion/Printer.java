package org.lld.prep.mutithreadQuestion;

public class Printer {
    private int turn = 0;

    public void printSequence(String threadName, int threadTurn, int totalCycles) {
        for(int i = 0; i < totalCycles; i++) {
            synchronized (this) {
                while(turn != threadTurn) {
                    try {
                        wait();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.print(threadName + " ");
                turn = (turn + 1)%3;
                notifyAll();
            }
        }
    }
}
