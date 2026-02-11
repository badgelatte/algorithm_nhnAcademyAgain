package com.again.day0211.basic;

public class OldMain {
    private static double correctCount = 0;
    private static final int[][] TESTCASES = new int[][] {
            { 1, 1, 1 },
            { 123, 345, 14145 },
            { 2, 81, 162 },
            { 3, 7, 21 },
            { 19, 87, 1653 },
            { 1, 40, 40 }
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++) {
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));
        }
        System.out.println("정답률 = " + (int)(correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(int first, int second, int answer) {
        boolean res = solution2(first, second) == answer;
        if (res)
            correctCount++;
        return res;
    }

    public static int solution(int first, int second) {
        int result;
        int mul = 0;
        int gcd = 0;

        // first 약수 구하기
        if(first > second) {
            mul = second;
        }
        else {
            mul = first;
        }

        for(int i = 1; i<= mul; i++) {
            if(first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }

        // result = (first / gcd) * (second / gcd) * gcd;

        System.out.println(gcd);
        result = first * second / gcd;
        System.out.println(result);
        return result;
    }

    // 유클리드 호제법
    // a / b = i   a = b  b = i   a / b = i
    // b로 나누고
    public static int solution2(int a, int b) {
        int first = a;
        int second = b;
        int result = 0;

        while(b != 0) {
            result = a % b;
            a = b;
            b = result;
        }

        return first * second / a;


    }
}