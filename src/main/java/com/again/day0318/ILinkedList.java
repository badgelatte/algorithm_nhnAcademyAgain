package com.again.day0318;

public interface ILinkedList<E> {
    void addFirst(E e);
    void addLast(E e);
    E removeFirst();
    E removeLast();
    E getFirst();
    E getLast();
}