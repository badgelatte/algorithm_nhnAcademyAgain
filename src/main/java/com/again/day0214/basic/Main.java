package com.again.day0214.basic;

// 0920
public class Main {

    public static void swapPrimitive(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void swapReference(Object input) {
        int[] arr = (int[])input;
        int temp = arr[0];

        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static void solution(char[] input) {
        char temp = 'a';

        for (int i = 0; i < input.length / 2; i++) {
            temp = input[input.length - 1 - i];
            input[input.length - 1 - i] = input[i];
            input[i] = temp;
        }
    }

}