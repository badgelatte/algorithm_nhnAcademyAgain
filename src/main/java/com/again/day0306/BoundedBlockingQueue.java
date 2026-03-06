package com.again.day0306;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue {
    private Queue<Integer> queue;
    // capacity - 제한 개수
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        // TODO 1.생성자는 capacity 값으로 queue를 초기화 합니다.
        // queue는 LinkedList를 사용합니다.
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    // queue큐가 가득찼을때 항목을 추가하려는 스레드나, 큐가 비었을때 항목을 제거하려는 스레드는 대기 상태로 만든다.
    public synchronized void enqueue(int element) throws InterruptedException {
        // TODO 2.queue에 element를 추가합니다.
        // queue가 가득차면 enqueue 메서드를 호출하는 Thread는 queue가 가득 차지 않을 때까지 대기 합니다.
        while(size() > capacity) {
            wait();
        }
        notifyAll();
        queue.add(element);
    }

    // queue가 비어있으면 요소를 꺼내려는 스레드는 큐에 요소가 추가될 때까지 대기한다.
    public synchronized int dequeue() throws InterruptedException {
        // TODO 3.queue에서 뒤쪽에(가장 먼저 들어온) 있는 요소들을 반환하고 제거 합니다.
        while(size() < 1) {
            wait();
        }
        notifyAll();
        return queue.poll();
    }

    public int size() {
        // TODO 4.현재 queue의 size를 반환합니다.
        return queue.size();
    }
}