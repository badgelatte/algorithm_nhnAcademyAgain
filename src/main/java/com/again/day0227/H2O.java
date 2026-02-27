package com.again.day0227;

public class H2O {
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // 수소 방출
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // 산소 방출
        releaseOxygen.run();
    }
}
