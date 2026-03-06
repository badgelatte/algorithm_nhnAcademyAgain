package com.again.day0306;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

@Slf4j
public class BoundedBlockingQueueTest {

    BoundedBlockingQueue queue;

    @BeforeEach
    void setUp() {
        queue = new BoundedBlockingQueue(10);
    }


    @Test
    @DisplayName("capacity=0")
    void constructorTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new BoundedBlockingQueue(0);
        });
    }

    @Test
    @DisplayName("enqueue, add 2 elements")
    void enqueue() throws InterruptedException {
        queue.enqueue(1);
        queue.enqueue(2);
        Assertions.assertEquals(2,queue.size());
    }

    @Test
    void dequeue() throws InterruptedException {
        queue.enqueue(1);
        queue.enqueue(2);

        Assertions.assertEquals(1,queue.dequeue());
        Assertions.assertEquals(2,queue.dequeue());
    }

    @Test
    @DisplayName("consumer && producer")
    void consumerTest() throws InterruptedException {
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        Thread producer = new Thread(new Runnable() {

            IntSupplier intSupplier = new IntSupplier() {
                int ctr=0;
                @Override
                public int getAsInt() {
                    return ++ctr;
                }
            };

            @Override
            public void run() {
                int data;
                while( (data=intSupplier.getAsInt())<=20){
                    try {
                        queue.enqueue(data);
                        buffer1.append(data);
                        log.info("enqueue:{}",data);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        int data = queue.dequeue();
                        Thread.sleep(200);
                        log.info("dequeue:{}", data);
                        buffer2.append(data);
                        if(data==20){
                            break;
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        consumer.start();
        producer.start();

        consumer.join();
        producer.join();

        while(true){
            if(isTerminated(consumer) && isTerminated(producer)){
                break;
            }
            Thread.yield();
        }

        Assertions.assertEquals(buffer1.toString(),buffer2.toString());
    }

    private boolean isTerminated(Thread thread){
        return thread.getState().equals(Thread.State.TERMINATED);
    }

}