package com.again.day0215.advanced;

import com.again.day0215.OrderType;

public class Main {
    public static Integer[] solution(Integer[] arr, int[] indexs, OrderType orderType) {
        if (orderType.equals(OrderType.ASC)) {
            ascBubbleSort(arr, indexs);
        }
        else {
            descBubbleSort(arr, indexs);
        }

        return arr;
    }

    public static boolean isContain(int[] arr, int num) {
        for (int arrNum : arr) {
            if(arrNum == num) {
                return true;
            }
        }

        return false;
    }

    public static void ascBubbleSort(Integer[] arr, int[] indexs) {
        int temp = 0;
        int count = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (isContain(indexs, j)) {
                    continue;
                }

                while(isContain(indexs, j + count)) {
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

    public static void descBubbleSort(Integer[] arr, int[] indexs) {
        int temp = 0;
        int count = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (isContain(indexs, j)) {
                    continue;
                }

                while (isContain(indexs, j + count)) {
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
