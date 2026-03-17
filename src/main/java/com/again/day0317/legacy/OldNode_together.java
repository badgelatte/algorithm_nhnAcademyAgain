package com.again.day0317.legacy;

import java.util.Objects;

// 1030에 당시 TA 선생님과 함께 완성한 풀이
public class OldNode_together<E> {

    private final E data;
    private OldNode_together<E> next;
    private OldNode_together<E> prev;

    public OldNode_together(E data){
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public OldNode_together<E> getNext() {
        return next;
    }

    public void setNext(OldNode_together<E> next) {
        this.next = next;
    }

    public OldNode_together<E> getPrev() {
        return prev;
    }

    public void setPrev(OldNode_together<E> prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OldNode_together)) {
            return false;
        }
        OldNode_together<?>node = (OldNode_together<?>)obj;
        return node.getData().equals((node.getData()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(data);
    }
}