package com.again.day0310.basic;

public class Solution {

    public static double calcStandardDeviation(double[] arr){
        //todo 1 표준편차 계산, 아래 링크를 참고하여 구현합니다.
        //https://www.mathsisfun.com/data/standard-deviation.html
        double avg = 0;
        double standardDeviation = 0;

        if (arr.length < 1) {
            throw new IllegalArgumentException();
        }

        for (double v : arr) {
            avg += v;
        }

        avg /= arr.length;

        for (double v : arr) {
            standardDeviation += Math.pow(v - avg, 2);
        }

        standardDeviation /= arr.length;

        standardDeviation = Math.sqrt(standardDeviation);
        return standardDeviation;
    }

}