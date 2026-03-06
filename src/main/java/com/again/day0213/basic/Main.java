package com.again.day0213.basic;

public class Main {

    public static long factorial(int number) {
        if (number <= 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static long fibonacci(int number) {
        if (number <= 1) {
            return number;
        }

        if (number == 2) {
            return 1;
        }

        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}