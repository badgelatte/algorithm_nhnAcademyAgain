package com.again.day0217.basic;

public class Main {
    public static String solution(String input) {
        int[] arr = new int[input.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.charAt(i) - 48;
        }

        selectionSort(arr);

        input = "";
        for (int j : arr) {
            input += j;
        }

        return input;
    }

    public static void selectionSort(int[] arr) {
        int max = 0;
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            max = i;

            for (int j = i + 1; j < arr.length; j++) {
                if(arr[max] > arr[j]) {
                    max = j;
                }
            }

            temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }
}