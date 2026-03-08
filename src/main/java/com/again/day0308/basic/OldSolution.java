package com.again.day0308.basic;

import lombok.extern.slf4j.Slf4j;

// 1019에 완성한 풀이
@Slf4j
public class OldSolution {

    public static double averageReturnDouble(double arr[]){
        // TODO 1.arr[]의 average(평균값 계산하기) 소숫점 2자리 까지 반올림 하여 반환
        double result = 0;
        for (double d : arr) {
            result += d;
            log.info("result : {}", result);
        }
        double a =result / arr.length;
        log.info("a : {}", a);

        double b = (a)*100.0;
        log.info("b : {}", b);


        result = Math.round(b)/100.0;
        log.info("real result : {}", result);

        return result;
    }

    public static String averageReturnString(double... arr){
        // TODO 2.arr[]의 average(평균값 계산하기) - 소숫점 2자리 까지 반올림 하여 반환
        double result = 0;
        String stringResult = "";
        for (double d : arr) {
            result += d;
            log.info("result : {}", result);
        }
        log.info("String result : {}", result);
        stringResult = String.format("%.2f",(result / arr.length));
        return stringResult;
    }
}
