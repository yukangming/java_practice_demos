package org.example;

import com.google.common.util.concurrent.RateLimiter;

import java.time.Duration;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yukangming
 */
public class ThreadLimiter {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

//        RateLimiter rateLimiter = RateLimiter.create(5);
//        System.out.println(rateLimiter.acquire(5));
//        System.out.println(rateLimiter.acquire(3));
//        System.out.println(rateLimiter.acquire(2));
//        System.out.println(rateLimiter.acquire(1));
//        System.out.println(rateLimiter.tryAcquire(5));
//        System.out.println(rateLimiter.tryAcquire(Duration.ofSeconds(5)));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                10, 1000,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>() {
        });
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    boolean b = simpleLimiter();
                    if (b) {
                        System.out.println("成功获得请求资格");
                    }
                    else {
                        System.out.println("请求资格失败");
                    }

                    countDownLatch.countDown();

                }
            });

        }

        countDownLatch.await();
        System.out.println("成功结素测试咯");

    }


    private static Integer MAX_REQUEST_COUNT = 10;

    private static final AtomicLong CURRENT_COUNT = new AtomicLong(0);

    private static Long startTime;

    /**
     * 单机版本简单限流实现
     * @return
     */
    static boolean simpleLimiter() {
        long l = System.currentTimeMillis();
        synchronized(ThreadLimiter.class) {
            long count = CURRENT_COUNT.getAndIncrement();
            if (count == 1) {
                startTime = System.currentTimeMillis();
            }
            if (count > MAX_REQUEST_COUNT && l - startTime < 1000) {
                CURRENT_COUNT.set(0);
                return false;
            }
            return true;
        }
    }
}