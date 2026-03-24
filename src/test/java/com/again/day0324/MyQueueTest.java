package com.again.day0324;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void element() {
        // TODO
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);


        Assertions.assertEquals(1, queue.element());
    }

    @Test
    void offer() {
        // TODO
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);


        Assertions.assertTrue(queue.offer(4));
        Assertions.assertFalse(queue.offer(1));
    }

    @Test
    void poll() {
        // TODO
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assertions.assertEquals(3, queue.poll());
    }

    @Test
    void peek() {
        // TODO
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assertions.assertEquals(3, queue.peek());
    }
}