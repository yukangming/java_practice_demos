package com.ykm.test;


import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class TestClass {


    private static long startTime = System.currentTimeMillis();

    public static final int TIME_WINDOWS = 1000;

    public static final int MAX_REQUEST = 2;

    private static AtomicInteger REQUEST_COUNT = new AtomicInteger(0);


    @Test
    public void testCounter() throws InterruptedException {


        for (int i = 0; i < 30; i++) {
            Thread.sleep(250);
            LocalTime now = LocalTime.now();
            if (tryAcquire()) {
                System.out.println(now + "可以请求");
            }
            else {
                System.out.println(now + "被限流了");
            }
        }

    }


    public static synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        if (now - startTime  > TIME_WINDOWS) {
            REQUEST_COUNT.set(0);
            startTime = System.currentTimeMillis();
        }
        return REQUEST_COUNT.incrementAndGet() <= MAX_REQUEST;
    }


}
