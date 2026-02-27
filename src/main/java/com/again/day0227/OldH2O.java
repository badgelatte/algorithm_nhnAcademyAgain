package com.again.day0227;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class OldH2O {
    private int count = 2;
    boolean useOxygen = false;

    final CyclicBarrier barrier = new CyclicBarrier(3);

    public void countdown() {
        if (barrier.getNumberWaiting() == 0) {
            count--;
            useOxygen = false;
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (0 < count) {
            try {
                releaseHydrogen.run();
                barrier.await();
                countdown();
            } catch (BrokenBarrierException e) {
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (0 < count) {
            if(!useOxygen) {
                try {
                    releaseOxygen.run();
                    useOxygen = false;
                    barrier.await();
                    countdown();
                } catch (BrokenBarrierException e) {
                }
            }
        }
    }
}