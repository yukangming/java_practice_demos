package org.example;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LeakBucketLimiter {

    private long lastOutTime = System.currentTimeMillis();

    private static final int leakRate = 2;

    private static final int capacity = 10;

    private static final AtomicInteger water = new AtomicInteger(0);

    private boolean tryAquire() {
        System.out.println("一进来就查看当前水量为" + water.get());
        if (water.getAndIncrement() == 0) {
            System.out.println("不需要减去漏水量当前水量为" + (water.get() - 1));
            lastOutTime = System.currentTimeMillis();
            return true;

        }

        //执行漏水
        int waterLeaked = ((int) ((System.currentTimeMillis() - lastOutTime) / 500)) * leakRate;
        System.out.println("本次请求当前时刻和上次漏水时间段漏水量为" + waterLeaked);

        int waterRemaining = Math.max(0, water.get() - waterLeaked);
        water.set(waterRemaining);
        System.out.println("经过减去漏水量后当前水量为" + waterRemaining);
        lastOutTime = System.currentTimeMillis();

        if (water.get() < capacity) {
            water.getAndIncrement();
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.CallerRunsPolicy());

        CountDownLatch countDownLatch = new CountDownLatch(2);
        LeakBucketLimiter limiter = new LeakBucketLimiter();
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 2; i++) {
            threadPoolExecutor.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    boolean result = limiter.tryAquire();
                    count.getAndIncrement();
                    System.out.println("第" + count + "次获取请求结果为" + result);
                    try {
                        Thread.sleep(995);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                countDownLatch.countDown();

            });


        }
        countDownLatch.await();

        System.exit(0);
    }

}
