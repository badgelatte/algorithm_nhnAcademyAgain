package com.again.day0305;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

// 1016 synchronized 없이 완성한 풀이법
public class OldPhotosynthesis2 {

    private final int count;
    int num = 0;
    private Semaphore semaphore = new Semaphore(0);
    CyclicBarrier barrier = new CyclicBarrier(3);

    public int getCount() {
        return count;
    }

    public OldPhotosynthesis2(int count) {
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

    public void carbon(Runnable releaseCarbon) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                releaseCarbon.run();
                semaphore.release();
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume(Runnable plantRoom) throws InterruptedException {
        while (num < count) {
            if(semaphore.tryAcquire()) {
                plantRoom.run();
                num++;
            }
        }
    }

}