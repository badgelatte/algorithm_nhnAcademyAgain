package com.again.day0325.legacy;

import com.again.day0325.HashNode;
import com.again.day0325.IMap;

import java.util.Arrays;
import java.util.HashMap;

// 1113에 완성한 풀이
public class OldMyHashMap<K, V> implements IMap<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] table;
    // private HashNode<K, V>[] hashNode;

    public OldMyHashMap() {
        // hashNode = new HashNode[DEFAULT_CAPACITY];
        table = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public boolean containsKey(K key) { // 중복 값 없애기 위해 만든 것
        // for (int i = 0; i < table.length; i++) {
        // HashNode<K, V> findNode = (HashNode<K, V>) table[i];
        // while (findNode != null) {
        // if (findNode.getKey() == key) {
        // return true;
        // }
        // findNode = findNode.getNext();
        // }
        // }
        // return false;
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < table.length; i++) {
            HashNode<K, V> findNode = (HashNode<K, V>) table[i];
            while (findNode != null) {
                if (findNode.getValue() == value) {
                    return true;
                }
                findNode = findNode.getNext();
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < table.length; i++) {
            HashNode<K, V> findNode = (HashNode<K, V>) table[i];
            while (findNode != null) {
                if (findNode.getKey() == key) {
                    return findNode.getValue();
                }
                findNode = findNode.getNext();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public V put(K key, V value) {
        HashNode<K, V> hashNode = new HashNode<>(hash(key), key, value);
        int index = hashNode.getHash() % 10;
        if (table[index] != null) {
            V oldValue = ((HashNode<K, V>) table[index]).getValue();
            ((HashNode<K, V>) table[index]).setNext(hashNode);
            size++;
            return oldValue;
        } else if (table[index] == null) {
            table[index] = hashNode;
            size++;
            return value;
        }
        return null;
    }

    @Override
    public void remove(K key) {
        for (int i = 0; i < table.length; i++) {
            HashNode<K, V> findNode = ((HashNode<K, V>) table[i]);
            if (findNode.getKey() == key) {
                table[i] = findNode.getNext();
                break;
            }
            while (findNode.getNext() != null) {
                if (findNode.getNext().getKey() == key) {
                    findNode.setNext(findNode.getNext().getNext());
                    return;
                }
                findNode = findNode.getNext();
            }
        }

    }

    @Override
    public int size() {
        return size;
    }

    public int hash(K key) {
        return key.hashCode();
        // hashCode(key) & (n-1)

    }
    // HashMap
}