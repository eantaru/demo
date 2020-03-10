package com.learn.forecast.util;

import java.util.concurrent.atomic.AtomicInteger;

public class RandomInteger {

    private static final AtomicInteger atomicInteger = new AtomicInteger(1000);

    public static int next() {
        return atomicInteger.incrementAndGet();
    }
}
