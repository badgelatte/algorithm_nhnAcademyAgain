package com.again.day0223;

public class Job {
    int count = 1;

    public void firstJob(Runnable job) throws InterruptedException {
        while (true) {
            if (count == 1) {
                job.run();
                count++;
                break;
            }
        }

    }

    public void secondJob(Runnable job) throws InterruptedException{
        while (true) {
            if (count == 2) {
                job.run();
                count++;
                break;
            }
        }
    }

    public void thirdJob(Runnable job) throws InterruptedException{
        while (true) {
            if (count == 3) {
                job.run();
                count++;
                break;
            }
        }
    }

}