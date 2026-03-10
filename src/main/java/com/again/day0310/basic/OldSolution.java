package com.again.day0310.basic;

import lombok.extern.slf4j.Slf4j;

// 1020에 완성한 풀이
@Slf4j
public class OldSolution {
    public static void isData(double[] arr) {
        if (arr.length <= 0)
            throw new IllegalArgumentException();
    }

    public static double calcStandardDeviation(double[] arr){
        //todo 1 표준편차 계산, 아래 링크를 참고하여 구현합니다.
        //https://www.mathsisfun.com/data/standard-deviation.html
        double average = 0;
        double result = 0;

        isData(arr);

        for (int i = 0; i < arr.length; i++) {
            average += arr[i];
        }
        average /= arr.length;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.pow(Math.abs(arr[i] - average), 2);
            result += arr[i];
        }
        return Math.pow(result /= arr.length,0.5);
    }

}