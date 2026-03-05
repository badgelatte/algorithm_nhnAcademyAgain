package com.again.day0305;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Photosynthesis {

    CyclicBarrier barrier = new CyclicBarrier(3);

    private final int count;
    private int consumeCount;


    public int getCount() {
        return count;
    }

    public Photosynthesis(int count) {
        this.count = count;
        consumeCount = 0;
    }


    // 산소 방출
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                releaseOxygen.run();
                barrier.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // 탄소 방출
    public void carbon(Runnable releaseCarbon) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                releaseCarbon.run();
                barrier.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 이산화탕소 소모
    public void consume(Runnable plantRoom) throws InterruptedException {
        while (consumeCount < count) {
            plantRoom.run();
            consumeCount++;
        }

    }

}