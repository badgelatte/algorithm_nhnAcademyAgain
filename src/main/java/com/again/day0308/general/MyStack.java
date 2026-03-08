package com.again.day0308.general;

import java.util.Iterator;

public class MyStack implements Iterable {
    private int top;
    private final int[] arr;

    private final int capacity;

    public MyStack(int capacity) {
        top = -1;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int data) {
        // TODO 1.stack에 data를 넣습니다.
    }

    public int pop() {
        // TODO 2.데이터를 반환하고 반환된 데이터는 stack에서 제거됩니다.
        return 0;
    }

    @Override
    public Iterator iterator() {
        // TODO 3.Iterator를 구현합니다.
        return null;
    }
}