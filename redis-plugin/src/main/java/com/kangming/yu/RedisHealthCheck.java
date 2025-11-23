package com.kangming.yu;

/**
 * used to be called by main code
 */
public class RedisHealthCheck implements HealthCheck {
    // Large heavy objects to make the Metaspace/Heap fill up faster
    private final byte[] heavyPayload = new byte[1024 * 10];

    @Override
    public void check() {
        // In a real app, this would ping Redis
         System.out.println("Redis Health Check: OK");
    }

    // Inner classes to consume more Metaspace (Class Metadata)
    class HelperA {}
    class HelperB {}
    class HelperC {}
}
