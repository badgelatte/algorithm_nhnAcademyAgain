package com.again.day0331;

import com.again.day0325.MyHashMap;

import java.util.Iterator;

public class MyHashSet<E> implements ISet<E>, Iterable<E> {

    //dummy Object value;
    private static final Object PRESENT = new Object();
    private MyHashMap<E,Object> map = new MyHashMap<>();

    @Override
    public boolean add(E item) {
        return map.put(item, PRESENT) == null;
    }

    @Override
    public boolean remove(E o) {
        if (!contains(o)) {
            return false;
        }
        map.remove(o);

        return true;
    }

    @Override
    public boolean contains(E o) {
        return map.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return map.getKeySet().iterator();
    }
}