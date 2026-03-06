package com.again.day0223;

// 1006에 완성한 풀이
public class OldJob {
    int count = 1;

    public synchronized void firstJob(Runnable job) throws InterruptedException {
        while (count!=1) {
            wait();
            break;
        }

        if(count ==1) {
            job.run();
            count++;
            notifyAll();
        }
    }

    public synchronized void secondJob(Runnable job) throws InterruptedException{
        while (count!=2) {
            wait();
            break;
        }

        if(count == 2) {
            job.run();
            count++;
            this.notifyAll();
        }
    }

    public synchronized void thirdJob(Runnable job) throws InterruptedException{
        while (count!=3) {
            wait();
            break;
        }

        if(count == 3) {
            job.run();
            count = 1;
            notifyAll();
        }
    }
}

class OldJob_flag {
    int count = 1;

    public void firstJob(Runnable job) throws InterruptedException {
        while (true) {
            if(count == 1) {
                job.run();
                count++;
                break;
            }
        }
    }

    public void secondJob(Runnable job) throws InterruptedException{
        while (true) {
            if(count == 2) {
                job.run();
                count++;
                break;

            }
        }
    }

    public void thirdJob(Runnable job) throws InterruptedException{
        while (true) {
            if(count == 3) {
                job.run();
                count++;
                break;

            }
        }
    }
}
