package com.again.day0324.legacy;

import com.again.day0318.legacy.OldMyLinkedList;
import com.again.day0324.IQueue;

import java.util.NoSuchElementException;

// 1102에 완성한 풀이
public class OldMyQueue<E> extends OldMyLinkedList<E> implements IQueue<E> {
    int size;
    OldMyLinkedList<E> list;

    public OldMyQueue(E size) {
        this.size = (int) size;
        list = new OldMyLinkedList<E>();
    }

    public E remove() {
        if (list.size() <= 0) {
            throw new NoSuchElementException();
        }
        E data = list.getFirst();
        list.removeFirst();
        return data;
    }

    @Override
    public boolean add(E e) {
        if (list.size() > size) {
            throw new IllegalStateException();
        }
        return list.add(e);
    }

    @Override
    public E element() {
        if (list.size() <= 0) {
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }

    @Override
    public boolean offer(E e) {
        return list.add(e);
    }

    @Override
    public E poll() {
        if (list.size() <= 0) {
            return null;
        }
        E data = list.getFirst();
        list.removeFirst();
        return data;
    }

    @Override
    public E peek() {
        if (list.size() <= 0) {
            return null;
        }
        return list.getFirst();
    }
}