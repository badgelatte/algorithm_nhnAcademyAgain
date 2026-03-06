package com.again.day0209.advanced;

//0914
public class Main {
    private static double correctCount = 0;
    private static final int[][] TESTCASES = new int[][] {
            { 3, 6, 8, 10 },
            { 5, 7, 12 },
            { 10, 20, 30, 40 },
            { 12, 22, 46, 55, 89 },
            { 15, 25, 125 },
            { 100, 155, 324, 450 }
    };
    private static final int[] ANSWERS = new int[] { 3, 1, 20, 11, 25, 50 };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + (i + 1) + " = " + test(TESTCASES[i], ANSWERS[i]));

        System.out.println("정답률 = " + (int)(correctCount / 6 * 100) + "%");
    }

    private static boolean test(int[] input, int answer) {
        boolean res = solution(input) == answer;
        if (res)
            correctCount++;
        return res;
    }

    public static int solution(int[] input) {
        int gcd = 1;
        int maxGCD = 1;

        for(int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if(i == j) {
                    continue;
                } else {
                    gcd = getGCD(input[i], input[j]);
                }

                if(gcd > maxGCD) {
                    maxGCD = gcd;
                }
            }
        }
        return maxGCD;
    }

    public static int getGCD(int num1, int num2) {
        int prime = 2;
        int minNum = Math.min(num1, num2);
        int gcd = 0;

        while(prime <= minNum) {
            if(num1 % prime == 0 && num2 % prime == 0) {
                gcd = prime++;
            } else {
                prime++;
            }
        }

        return gcd;
    }
}