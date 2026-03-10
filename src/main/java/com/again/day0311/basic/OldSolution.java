package com.again.day0311.basic;

// 1023에 완성한 풀이
public class OldSolution {
    public static double getLargestNumber(double[] arr) {
        // TODO 1. 배열 arr에서 가장 큰 수 구하기
        if (arr.length <= 0) {
            throw new IllegalArgumentException();
        }
        double MaxNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(MaxNum < arr[i]) {
                MaxNum = arr[i];
            }
        }
        return MaxNum;
    }

    public static double getSmallestNumber(double[] arr) {
        // TODO 2. 배열 arr에서 가장 작은 수 구하기
        double MinNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(MinNum > arr[i]) {
                MinNum = arr[i];
            }
        }
        return MinNum;
    }
}