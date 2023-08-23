package org.example;

import com.google.common.util.concurrent.RateLimiter;

import java.time.Duration;

/**
 * @author yukangming
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        RateLimiter rateLimiter = RateLimiter.create(5);
        System.out.println(rateLimiter.acquire(5));
        System.out.println(rateLimiter.acquire(3));
        System.out.println(rateLimiter.acquire(2));
        System.out.println(rateLimiter.acquire(1));
        System.out.println(rateLimiter.tryAcquire(5));
        System.out.println(rateLimiter.tryAcquire(Duration.ofSeconds(5)));



    }
}