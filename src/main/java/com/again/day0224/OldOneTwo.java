package com.again.day0224;

import java.util.concurrent.Semaphore;

// 1010에 완성한 풀이
public class OldOneTwo {
    private final Semaphore s1 = new Semaphore(1);
    private final Semaphore s2 = new Semaphore(0);  //  -> acquire가 1개도 없다
    private final int count;
    int number = 0;

    public OldOneTwo(int count) {
        this.count = count;
    }

    public synchronized void printOne(Runnable runnable) throws InterruptedException {
        while(number < count){
            // tryAcquire - acquire => true : acquire를 주는데 성공하면 true, 실패하면 false
            while(!s1.tryAcquire()){
                wait();
            }
            if(number >= count) {
                break;
            }
            runnable.run();
            s2.release();
            notifyAll();
        }

    }

    public synchronized void printTwo(Runnable runnable) throws InterruptedException {

        while(number < count){
            while(!s2.tryAcquire()){
                wait();
            }
            runnable.run();
            s1.release();
            notifyAll();
            number++;
        }

    }
}