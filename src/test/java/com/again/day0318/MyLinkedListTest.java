package com.again.day0318;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void addFirst() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(1);

        assertEquals(1, list.getFirst());
    }

    @Test
    void addLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addLast(1);

        assertEquals(1, list.getFirst());
    }

    @Test
    void removeFirst() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.removeFirst();
        
        assertEquals(2, list.getFirst());
    }

    @Test
    void removeLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.removeLast();

        assertEquals(1, list.getLast());
    }

    @Test
    void getFirst() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);

        assertEquals(1, list.getFirst());
    }

    @Test
    void getLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);

        assertEquals(2, list.getLast());
    }

    @Test
    void add() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);

        assertEquals(1, list.getFirst());
    }

    @Test
    void remove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.remove(1);

        assertFalse(list.contains(1));
    }

    @Test
    void testRemove() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.remove("1");

        assertFalse(list.contains("1"));
    }

    @Test
    void get() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void set() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);

        assertEquals(4, list.get(1));
    }

    @Test
    void size() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
    }

    @Test
    void contains() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(1));
    }

    @Test
    void iterator() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        StringBuilder sb = new StringBuilder();

        while (iterator.hasNext()) {
            sb.append(iterator.next() + " ");
        }

        assertEquals("1 2 3 ", sb.toString());
    }
}