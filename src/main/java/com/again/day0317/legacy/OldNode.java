package com.again.day0317.legacy;

// 1030에 완성한 풀이
public class OldNode<E> {

    private final E data;
    private OldNode<E> next;
    private OldNode<E> prev;

    public OldNode(E data){
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public OldNode<E> getNext() {
        return next;
    }

    public void setNext(OldNode<E> next) {
        this.next = next;
    }

    public OldNode<E> getPrev() {
        return prev;
    }

    public void setPrev(OldNode<E> prev) {
        this.prev = prev;
    }
}