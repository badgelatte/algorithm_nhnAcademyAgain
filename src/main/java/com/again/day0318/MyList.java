package com.again.day0318;

public interface MyList<E> {
    boolean add(E element);
    // index번 째의 element 삭제
    boolean remove(int index);
    // 처음 발견되는 element 삭제
    boolean remove(E e);
    E get(int index);
    E set(int index, E element);
    int size();
    boolean contains(Object o);
}