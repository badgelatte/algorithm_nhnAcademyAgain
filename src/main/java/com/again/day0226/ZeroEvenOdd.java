package com.again.day0226;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int current;
    private boolean zeroFlag = true;

    public ZeroEvenOdd(int n) {
        if (n < 1 || n > 100) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        current = 1;
    }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while(current <= n) {
            while (!zeroFlag) {
                wait();
            }

            if (current <= n) {
                printNumber.accept(0);
            }

            zeroFlag = false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (zeroFlag || current % 2 != 0) {
                wait();
            }
            if (current <= n) {
                printNumber.accept(current++);
            }
            zeroFlag = true;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(current <= n) {
            while (zeroFlag || current % 2 != 1) {
                wait();
            }
            if (current <= n) {
                printNumber.accept(current++);
            }
            zeroFlag = true;
            notifyAll();
        }
    }
}
