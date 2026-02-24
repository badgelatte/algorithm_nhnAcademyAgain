package com.again.day0224;

import java.util.concurrent.Semaphore;

public class OneTwo {
    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore s2 = new Semaphore(1);
    private final int count;

    public OneTwo(int count) {
        this.count = count;
    }

    public void printOne(Runnable runnable) throws InterruptedException {
    }

    public void printTwo(Runnable runnable) throws InterruptedException {
    }
}