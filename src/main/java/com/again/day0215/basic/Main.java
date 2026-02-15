package com.again.day0215.basic;

import com.again.day0215.OrderType;

public class Main {

    public static Integer[] solution(Integer[] arr, OrderType orderType) {
        if(orderType.equals(OrderType.ASC)) {
            ascBubbleSort(arr);
        }
        else {
            descBubbleSort(arr);
        }

        return arr;
    }

    public static Integer[] ascBubbleSort(Integer[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        return arr;
    }

    public static Integer[] descBubbleSort(Integer[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] < arr[j + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        return arr;
    }
}