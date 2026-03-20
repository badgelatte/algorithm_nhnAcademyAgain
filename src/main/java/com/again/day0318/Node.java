package com.again.day0318;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Node<E> {
    // Data
    private E data;
    // prev node;
    private Node<E> prev;
    // next node
    private Node<E> next;

    public Node(E e) {
        this.data = e;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return !Objects.isNull(next);
    }
}