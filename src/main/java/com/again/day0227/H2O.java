package com.again.day0227;

public class H2O {
    int HCount = 0;
    int OCount = 0;

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (HCount > 2) {
            wait();
        }

        releaseHydrogen.run();
        HCount++;
        notifyAll();

    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (OCount > 1) {
            wait();
        }

        releaseOxygen.run();
        OCount++;
        notifyAll();
    }
}
