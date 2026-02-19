package com.again.day0219.advanced;

public class Main {
    public static void bubble(int[] input) {
        int temp = 0;

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
    }

    public static void selection(int[] input) {
        int min = 0;
        int temp = 0;

        for (int i = 0; i < input.length; i++) {
            min = i;

            for (int j = i; j < input.length; j++) {
                if (input[min] > input[j]) {
                    min = j;
                }
            }

            temp = input[min];
            input[min] = input[i];
            input[i] = temp;
        }
    }

    public static void insertion(int[] input) {
        int point = 0;
        int temp = 0;

        for (int i = 1; i < input.length; i++) {
            point = i;

            for (int j = 0; j < i; j++) {
                if (input[point] < input[j]) {
                    temp = input[j];
                    input[j] = input[point];
                    input[point] = temp;
                }
            }
        }
    }
}
