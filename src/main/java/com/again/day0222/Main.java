package com.again.day0222;

import java.util.Arrays;

public class Main {
    public static String solution(String input) {
        String[] arr = divideArr(input.split(""));
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : arr) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    public static String[] divideArr(String[] strs) {
        if (strs.length < 2) {
            return strs;
        }

        int mid = strs.length/2;

        String[] arr1 = divideArr(Arrays.copyOfRange(strs, 0, mid));
        String[] arr2 = divideArr(Arrays.copyOfRange(strs,mid, strs.length));

        return mergeArr(arr1, arr2);
    }

    public static String[] mergeArr(String[] arr1, String[] arr2) {
        String[] arr = new String[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {

            int n1 = Integer.parseInt(arr1[i]);
            int n2 = Integer.parseInt(arr2[j]);

            if (n1 <= n2) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        return arr;
    }
}
