package com.again.day0214.advanced;

// 0920
public class Main {

    public static void solution(char[] input, int... excludeIndex) {
        char temp = 'a';
        int end = input.length - 1;

        for (int start = 0; start < end; start++) {
            if (isInclude(excludeIndex, start)) {
                continue;
            }

            while(isInclude(excludeIndex, end)) {
                end--;
            }

            temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            end--;
        }
    }

    public static boolean isInclude(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                return true;
            }
        }

        return false;
    }

}