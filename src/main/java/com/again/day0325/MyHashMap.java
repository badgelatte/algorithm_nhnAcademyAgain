package com.again.day0325;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K,V> implements IMap<K,V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] table;

    private Set<K> keySet = new HashSet<>();

    public MyHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }

        size = 0;
        table = new Object[capacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public Set<K> getKeySet() {
        return keySet;
    }

    @Override
    public void clear() {
        size = 0;
        table = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (Object object : table) {
            HashNode<K, V> current = (HashNode<K, V>) object;
            if (current != null && current.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = key.hashCode() % table.length;
        HashNode<K, V> current = (HashNode<K, V>) table[index];

        while (current != null) {
            if (current.getKey() == key) {
                return current.getValue();
            }

            current = current.getNext();
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        HashNode<K, V> node = new HashNode<>(hash, key, value);
        int index = hash % table.length;
        keySet.add(key);

        if (table[index] == null) {
            table[index] = node;
            size++;
            return value;
        }

        HashNode<K, V> current = (HashNode<K, V>) table[index];

        while (current.getNext() != null) {
            if (current.getNext().getKey() == key) {
                node.setNext(current.getNext().getNext());
                current.setNext(node);
                return current.getNext().getValue();
            }
        }

        current.setNext(node);
        size++;
        return value;
    }

    @Override
    public void remove(K key) {
        int index = key.hashCode() % table.length;
        HashNode<K, V> current = (HashNode<K, V>)table[index];
        HashNode<K, V> next = current.getNext();

        if (current == null) {
            return;
        }

        if (current.getKey() == key) {
            table[index] = next;
            size--;
            return;
        }

        while (next != null) {
            if (next.getKey() == key) {
                current.setNext(next.getNext());
                size--;
                return;
            }

            next = next.getNext();
        }

    }

    @Override
    public int size() {
        return size;
    }
}