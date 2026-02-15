package com.again.day0215.advanced;

import com.again.day0215.OrderType;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static Integer[] solution(Integer[] arr, int[] indexs, OrderType orderType) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < indexs.length; i++) {
            set.add(indexs[i]);
        }

        if (orderType.equals(OrderType.ASC)) {
            ascBubbleSort(arr, set);
        }
        else {
            descBubbleSort(arr, set);
        }

        return arr;
    }

    public static void ascBubbleSort(Integer[] arr, Set<Integer> indexs) {
        int temp = 0;
        int count = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (indexs.contains(j)) {
                    continue;
                }

                while(indexs.contains(j + count)) {
                    count++;
                }

                if ((arr.length - i) > (j + count) && arr[j] > arr[j + count]) {
                    temp = arr[j];
                    arr[j] = arr[j + count];
                    arr[j + count] = temp;
                    j += count - 1;
                }
                count = 1;
            }
        }
    }

    public static void descBubbleSort(Integer[] arr, Set<Integer> indexs) {
        int temp = 0;
        int count = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (indexs.contains(j)) {
                    continue;
                }

                while (indexs.contains(j + count)) {
                    count++;
                }

                if ((arr.length - i)> (j + count) && arr[j] < arr[j + count]) {
                    temp = arr[j];
                    arr[j] = arr[j + count];
                    arr[j + count] = temp;
                    j += count - 1;
                }
                count = 1;
            }
        }
    }
}
