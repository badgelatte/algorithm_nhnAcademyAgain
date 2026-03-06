package com.again.day0216;

import java.util.Comparator;

public enum OrderType {
    ASC(Integer::compareTo),
    DESC(Comparator.reverseOrder());

    final Comparator<Integer> comparator;

    OrderType(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Integer> getComparator() {
        return comparator;
    }
}