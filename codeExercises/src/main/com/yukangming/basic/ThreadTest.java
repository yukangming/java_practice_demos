package com.yukangming.basic;

public class ThreadTest {

    private int count = 0;
    private void add() {
        int idx = 0;
        while(idx++ < 10000000) {
            count += 1;
        }
    }


    public static int calc() throws Exception {
        final ThreadTest test = new ThreadTest();
        Thread th1 = new Thread(()->{
            test.add();
        });
        Thread th2 = new Thread(()->{
            test.add();
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        return test.count;
    }


    public static void main(String[] args) throws Exception {
        long c =calc();
        System.out.println(c);
    }

}
