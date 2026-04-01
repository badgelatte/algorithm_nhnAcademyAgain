package com.again.day0331;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class MyHashSetTest {

    @Test
    void add() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));
    }

    @Test
    void remove() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        Assertions.assertTrue(set.remove(1));
        Assertions.assertTrue(set.remove(2));
        Assertions.assertTrue(set.remove(3));
    }

    @Test
    void contains() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));
    }

    @Test
    void isEmpty() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(1);

        Assertions.assertFalse(set.isEmpty());

        set.remove(1);

        Assertions.assertTrue(set.isEmpty());
    }

    @Test
    void size() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        Assertions.assertEquals(3, set.size());
    }

    @Test
    void clear() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        set.clear();

        Assertions.assertTrue(set.isEmpty());
        Assertions.assertFalse(set.contains(1));
        Assertions.assertFalse(set.contains(2));
        Assertions.assertFalse(set.contains(3));
        Assertions.assertEquals(0, set.size());
    }

    @Test
    void iterator() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();

        int sum = 0;

        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        Assertions.assertEquals(6, sum);

    }
}