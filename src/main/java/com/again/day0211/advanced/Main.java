package com.again.day0211.advanced;

public class Main {
    private static double correctCount = 0;
    private static final int[][] TESTCASES = {
            { 4, 5 },
            { 20, 30 },
            { 10, 15 },
            { 12, 40 },
            { 7, 11 },
            { 30, 14 },
            { 144, 60 },
            { 6, 5 },
    };
    private static final int[][] EXPECTED_VALUES = {
            { 20, 20 },
            { 60, 6 },
            { 30, 6 },
            { 120, 30 },
            { 77, 77 },
            { 210, 105 },
            { 720, 60 },
            { 30, 30 },
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++) {
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i], EXPECTED_VALUES[i]));
        }
        System.out.println("정답률 = " + (int)(correctCount / TESTCASES.length) * 100 + "%");
    }

    public static boolean test(int[] inputs, int[] outputs) {
        int[] yourAnwser = solution(inputs[0], inputs[1]);

        boolean res = outputs[0] == yourAnwser[0] && outputs[1] == yourAnwser[1];
        if (res)
            correctCount++;
        return res;
    }

    public static int[] solution(int a, int b){
        int[] answer = new int[2];
        int len = a * b / gcd(a, b);
        answer[0] = len;
        answer[1] = len/a * len/b;
        return answer;

    }

    public static int gcd(int a, int b){
        if (a%b==0) return b;
        return gcd(b,a%b);
    }
}