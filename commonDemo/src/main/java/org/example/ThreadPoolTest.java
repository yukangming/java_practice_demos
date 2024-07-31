package org.example;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {


    private int coreThreads;

    private List<Thread> threads;

    private int maxThreads;

    private ArrayBlockingQueue workQueue;

//    private long keepAliveTime;

//    private ThreadPoolExecutor.AbortPolicy abortPolicy;

    public ThreadPoolTest(int coreThreads, int maxThreads, ArrayBlockingQueue workQueue) {
        this.coreThreads = coreThreads;
        for (int i = 0; i < coreThreads; i++) {
            threads.add(new Thread());
        }
        this.maxThreads = maxThreads;
        this.workQueue = workQueue;
//        this.keepAliveTime = keepAliveTime;
//        this.abortPolicy = abortPolicy;
    }


    public void submit(Runnable task) {
        if ()
    }


}
