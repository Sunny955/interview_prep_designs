package org.lld.prep.executors;

public class TestMain {
    public static void main(String[] args) {
//        ThreadPoolExecution threadPoolExecution = new ThreadPoolExecution();
//        try {
//            threadPoolExecution.execute();
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        MultipleTaskExecution multipleTaskExecution = new MultipleTaskExecution();
        multipleTaskExecution.execute();
    }
}
