package com.again.day0308.basic;

public class Solution {

    public static double averageReturnDouble(double arr[]){
        // TODO 1.arr[]의 average(평균값 계산하기) 소숫점 2자리 까지 반올림 하여 반환
        double avgArr = 0d;

        if (arr.length < 1) {
            throw new IllegalArgumentException();
        }

        for (double v : arr) {
            avgArr += v;
        }

        avgArr /= arr.length;

        return Math.round(avgArr * 100D) / 100D;
    }

    public static String averageReturnString(double... arr){
        // TODO 2.arr[]의 average(평균값 계산하기) - 소숫점 2자리 까지 반올림 하여 반환

        return String.format("%.2f", averageReturnDouble(arr));
    }
}
