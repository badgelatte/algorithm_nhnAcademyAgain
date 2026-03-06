package com.again.day0306;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

// 1017에 완성한 풀이
@Slf4j
public class OldBoundedBlockingQueue {
    private Queue<Integer> queue;
    private int capacity;
    private int count = 0;
    private int countadd = 0;

    public OldBoundedBlockingQueue(int capacity) {
        // TODO 1.생성자는 capacity 값으로 queue를 초기화 합니다.
        // queue는 LinkedList를 사용합니다.
        if(capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        while(size() > capacity){  // 다 찼는데 add하려고 할때 1초 기다리고 다시 시도해봐
            Thread.sleep(100);
        }
        queue.add(element);   // queue에 element를 넣고 나면 element 수를 한개 삭제
        log.info("real enqueue:{}",++countadd);
    }

    public Integer dequeue() throws InterruptedException {
        while (size() < 1) {    // 아무것도 없는데 빼려고 할때 1초 기다리고 다시 시도해봐
            Thread.sleep(500); // 100으로 설정하면 enqueue랑 값이 같으면 속도가 비슷해서 queue가 쌓이지가 않는다
        }
        int a = queue.poll();
        log.info("real dequeue:{}", ++count);
        return a;
    }

    public int size() {
        return queue.size();
    }
}