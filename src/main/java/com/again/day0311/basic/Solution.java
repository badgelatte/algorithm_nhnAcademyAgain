package com.again.day0311.basic;

public class Solution {
    public static double getLargestNumber(double[] arr) {
        // TODO 1. 배열 arr에서 가장 큰 수 구하기
        double maxNum = 0d;

        if (arr.length < 1) {
            throw new IllegalArgumentException();
        }

        for (double num : arr) {
            if (maxNum < num) {
                maxNum = num;
            }
        }

        return maxNum;
    }

    public static double getSmallestNumber(double[] arr) {
        // TODO 2. 배열 arr에서 가장 작은 수 구하기
        double minNum = 0d;

        if (arr.length < 1) {
            throw new IllegalArgumentException();
        }

        for (double num : arr) {
            if (minNum > num) {
                minNum = num;
            }
        }

        return minNum;
    }
}