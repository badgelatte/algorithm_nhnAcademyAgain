package com.again.day0324;

public interface IQueue<E> {
    boolean add(E e);
    E element();
    boolean offer(E e);
    E poll();
    E peek();
}