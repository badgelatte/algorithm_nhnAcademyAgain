package com.again.day0324;

import com.again.day0318.MyLinkedList;

import java.util.Objects;

public class MyQueue<E> extends MyLinkedList<E> implements IQueue<E> {
    MyLinkedList<E> list = new MyLinkedList();

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public E element() {
        return list.getFirst();
    }

    @Override
    public boolean offer(E e) {
        return list.add(e);
    }

    @Override
    public E poll() {
        return list.removeLast();
    }

    @Override
    public E peek() {
        return list.getLast();
    }
}