package com.again.day0216.basic;

public class Main {
    public static int solution(int[] unsortedArray, int[] sortedArray) {
        int maxDistance = 0;

        for (int i = 0; i < unsortedArray.length - 1; i++) {
            for(int j = 0; j < sortedArray.length - 1; j++) {
                if(unsortedArray[i] == sortedArray[j] && maxDistance < i - j) {
                    maxDistance = i - j;
                }
            }
        }

        return maxDistance;
    }

}
