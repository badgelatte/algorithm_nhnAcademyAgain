package com.again.day0315;

//1027에 완성한 풀이
public class OldNode<E> {

    private final E data;
    private Node<E> next;

    public OldNode() {
        throw new IllegalStateException();
    }

    public OldNode(E num){
        data = num;
    }

    public E getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node<E> node) {
        next = node;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        if(getData() != null) {
            hash = hash * 31 + (getData() == null ? 0 : getData().hashCode());
        }
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Node) {
            return ((Node)object).getData() == this.getData();
        }
        return false;
    }



}