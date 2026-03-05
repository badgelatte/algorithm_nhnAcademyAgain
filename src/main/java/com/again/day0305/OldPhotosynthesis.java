package com.again.day0305;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

// 1016 synchronized 사용하여 완성한 풀이법
public class OldPhotosynthesis {
    /**
     * synchronized, Semaphore, CyclicBarrier 사용
     */
    private final int count;
    int num = 0;
    private Semaphore semaphore = new Semaphore(0);
    CyclicBarrier barrier = new CyclicBarrier(3);

    public int getCount() {
        return count;
    }

    public OldPhotosynthesis(int count) {
        this.count = count;
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                releaseOxygen.run();
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void carbon(Runnable releaseCarbon) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                releaseCarbon.run();
                semaphore.release();
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            while (semaphore.availablePermits() < 1) {
                wait();
            }
        }
    }

    public synchronized void consume(Runnable plantRoom) throws InterruptedException {
        while(semaphore.tryAcquire()) {
            try {
                plantRoom.run();
                notifyAll();
            } catch (Exception e) {
            }
        }
    }

}