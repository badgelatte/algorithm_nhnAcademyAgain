package com.again.day0331.legacy;

import com.again.day0331.ISet;

import java.util.Iterator;

// 1115에 완성한 풀이
public class OldMyHashSet<E> implements ISet<E>, Iterable<E> {

    // dummy Object value;
    private static final Object PRESENT = new Object();
    private OldMyHashMap<E, Object> map = new OldMyHashMap<>();

    @Override
    public boolean add(E item) {
        // 원래 비어있던 경우 -> true
        return map.put(item, PRESENT) == null;
    }

    @Override
    public boolean remove(E o) {
        boolean result = false;
        if (map.get(o) != null) { // 찾을 경우
            result = true;
        }
        map.remove(o); // 있다면 삭제 될거고 없다면
        return result;
    }

    @Override
    public boolean contains(E o) {
        return map.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        // 다 비어 있는 상태라면 true, 뭐 하나라도 있으면 false
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
