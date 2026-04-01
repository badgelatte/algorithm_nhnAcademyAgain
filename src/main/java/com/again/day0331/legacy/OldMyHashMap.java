package com.again.day0331.legacy;

import com.again.day0325.HashNode;
import com.again.day0325.IMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 1115에 완성한 풀이
public class OldMyHashMap<K, V> implements IMap<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] table;
    // private HashNode<K, V>[] hashNode;

    private Set<K> keySet = new HashSet();

    public Set<K> getKeySet() {
        return keySet;
    }

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
        HashNode<K, V> newNode = new HashNode<>(hash(key), key, value);
        int index = newNode.getHash() % 10;
        keySet.add(key);
        /*
         * // table[index]에 있는 거
         * if (table[index] != null) {
         * V oldValue = ((HashNode<K, V>) table[index]).getValue();
         * ((HashNode<K, V>) table[index]).setNext(newNode);
         * size++;
         * return oldValue;
         * }
         * // table[index]에 아무것도 없는 거
         * else if (table[index] == null) {
         * table[index] = newNode;
         * size++;
         * return value;
         * }
         */

        // table[index]에 값이 없는 경우
        if (table[index] == null) {
            table[index] = newNode;
            size++;
            return null;
        }
        HashNode<K, V> nowNode = (HashNode) table[index];

        // table[index]에 값이 있는 경우, key가 이미 있는 경우
        while (Objects.nonNull(nowNode)) {
            if (nowNode.getKey() == key) {
                V oldValue = nowNode.getValue();
                nowNode.setValue(value);
                return oldValue;
            }
            nowNode = nowNode.getNext();
        }

        // table[index]에 값이 있는 경우, key가 없는 경우
        nowNode.setNext(newNode);
        size++;

        return null;
    }

    public int getIndex(K key) {
        return hash(key) % 10;
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        HashNode<K, V> findNode = ((HashNode<K, V>) table[index]);
        if (findNode == null) { // 만일 없는 key 찾는데 등록된 게 없다면
            throw new IllegalArgumentException();
        } else {
            if (findNode.getKey() == key) { // 처음부터 찾던 key를 갖고 있는 노드라면
                table[index] = findNode.getNext();
                size--;
            }
            while (findNode.getNext() != null) { // 첫번째 노드가 아닌 다음 노드들이 찾고 있던 key라면 -> 못찾으면 그냥 끝
                if (findNode.getNext().getKey() == key) { // 찾았다면
                    findNode.setNext(findNode.getNext().getNext());
                    size--;
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
        int a = key.hashCode();
        System.out.println(key + " , " + a);
        return a;
        // hashCode(key) & (n-1)
    }
    // HashMap
    // Set

    public static void main(String[] args) {
        OldMyHashMap<String, Integer> hashMap = new OldMyHashMap<>();
        hashMap.put("dkdk", 1);
        hashMap.put("df", 2);
        hashMap.put("dfff", 3);
        hashMap.put("dkdk", 4);
        hashMap.put("df", 5);
        hashMap.put("dkdk", 6);
        hashMap.put("df", 7);
        hashMap.put("dfff", 8);
        hashMap.remove("dfff");

        // HashNode node =MyHashMap.test();
        System.out.println(hashMap.get("dkdk"));
        System.out.println(hashMap.get("df"));
        // System.out.println(hashMap.get("dfff"));

        System.out.println(hashMap.size());

    }
}