package com.again.day0219.basic;

public class Main {
    public static String solution(String input) {
        int[] arr = new int[input.length()];
        int point = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.charAt(i) - 48;
        }

        for (int i = 1; i < arr.length; i++) {
            point = i;

            for (int j = 0; j < i; j++) {
                if(arr[point] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[point];
                    arr[point] = temp;
                }
            }
        }

        return toString(arr);
    }

    public static String toString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : arr) {
            stringBuilder.append(i);
        }

        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}