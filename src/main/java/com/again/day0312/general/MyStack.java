package com.again.day0312.general;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;

public class MyStack<E> implements IStack<E> , Iterable<E> {
    int capacity;
    List<E> list;
    int top = -1;

    public MyStack(int capacity){
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        list = new ArrayList<>();
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new Iterator<>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current <= top;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return list.get(current++);
            }
        };
    }

    @Override
    public void push(E item) {
        // TODO Auto-generated method stub
        if (top < capacity) {
            list.add(item);
            top++;
        }
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        if (empty()) {
            throw new EmptyStackException();
        }

        top--;
        return list.removeLast();
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        if (empty()) {
            throw new EmptyStackException();
        }

        return list.getLast();
    }

    @Override
    public int search(Object o) {
        // TODO Auto-generated method stub
        return list.indexOf(o);
//        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public boolean empty() {
        // TODO Auto-generated method stub
        return list.isEmpty();
//        throw new UnsupportedOperationException("Unimplemented method 'empty'");
    }

}