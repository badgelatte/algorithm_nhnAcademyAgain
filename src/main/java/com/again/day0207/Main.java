package com.again.day0207;

public class Main {

    public static int solution(int start, int end) {
        int count = 0;

        for(int i = start; i <= end; i++) {
            if(isDecimal(i)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isDecimal(int num) {
        int i = 2;

        if(i > num) {
            return false;
        }

        while(i < num) {
            if(num % i++ == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 50));
    }
}
