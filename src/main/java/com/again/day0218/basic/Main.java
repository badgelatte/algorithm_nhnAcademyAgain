package com.again.day0218.basic;

public class Main {
    public static int[] solution(int[] unsortedArray) {
        int min = 0;
        int temp = 0;

        for (int i = 0; i < unsortedArray.length - 1; i++) {
            min = i/2 + i % 2;
            for (int j = i/2 + i % 2; j < unsortedArray.length - i / 2; j++) {
                if (unsortedArray[min] > unsortedArray[j]) {
                    min = j;
                }
            }
            
            if (i % 2 == 0) {
                temp = unsortedArray[min];
                unsortedArray[min] = unsortedArray[i / 2];
                unsortedArray[i / 2] = temp;
            } else {
                temp = unsortedArray[min];
                unsortedArray[min] = unsortedArray[unsortedArray.length - 1 - i / 2];
                unsortedArray[unsortedArray.length - 1 - i / 2] = temp;
            }
        }

        return unsortedArray;
    }
}
