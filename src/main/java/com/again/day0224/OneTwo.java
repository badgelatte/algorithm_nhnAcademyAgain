package com.again.day0224;

import java.util.concurrent.Semaphore;

public class OneTwo {
    private final Semaphore s1 = new Semaphore(1);
    private final Semaphore s2 = new Semaphore(0);
    private final int count;
    int current = 0;

    public OneTwo(int count) {
        this.count = count;
    }

    public synchronized void printOne(Runnable runnable) throws InterruptedException {
        while (current < count) {
            while (!s1.tryAcquire()) {
                wait();
            }

            if (current >= count) {
                break;
            }

            runnable.run();
            s2.release();
            notifyAll();
        }
    }

    public synchronized void printTwo(Runnable runnable) throws InterruptedException {
        while (current < count) {
            while (!s2.tryAcquire()) {
                wait();
            }

            runnable.run();
            s1.release();
            current++;
            notifyAll();
        }
    }
}