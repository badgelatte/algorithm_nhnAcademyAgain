package com.again.day0315;

public class Node<E> {
    private final E data;
    private Node<E> next;


    public Node(E data) {
        if (data == null) {
            throw new IllegalStateException();
        }

        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setNext(Node<E> node) {
        next = node;
    }

    public Node<E> getNext() {
        return next;
    }

    @Override
    public final int hashCode() {
        int hash = 31;

        hash = hash * 17 + (getData() == null ? 0 : getData().hashCode());

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Node) {
            return this.getData() == ((Node) object).getData();
        }

        return false;
    }
}
