package com.again.day0213.basic;

// 0919에 풀었던 코드
public class OldMain {
    public static long factorial(int number) {

        // TODO : factorial
        switch (number) {
            case 0:
            case 1:
                return 1;

            default:
                return number * factorial(number-1);
        }

    }

    public static long factorial2(int number) {
        // TODO : factorial
        long result = 1;
        if(number == 0) {
            return 1;
        }
        for(long i = number; i > 0; i--) {
            System.out.println(result +" : result");
            result *= i;
        }
        return result;
    }

    public static long fibonacci(int number) {
        // TODO : fibonacci
        long result = 0;
        switch (number) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                result = fibonacci(number-1) + fibonacci(number-2);
                return result;
        }
    }

    public static long fibonacci2(int number) {
        // TODO : fibonacci
        long result = number;
        if(result == 0) {
            return 0;
        }
        else if(result == 1) {
            return 1;
        }
        else {
            result = fibonacci(number-1)+ fibonacci(number-2);
            return result;
        }
    }

}