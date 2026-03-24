package com.again.day0325;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashMapTest {

    @Test
    void clear() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.clear();

        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void containsKey() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.clear();

        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void containsValue() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        Assertions.assertTrue(map.containsValue("a"));
    }

    @Test
    void get() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        Assertions.assertEquals("a", map.get(1));
    }

    @Test
    void isEmpty() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void put() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        Assertions.assertEquals("d", map.put(4,"d"));
    }

    @Test
    void remove() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.remove(1);

        Assertions.assertNull(map.get(1));
    }

    @Test
    void size() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        Assertions.assertEquals(3, map.size());
    }
}