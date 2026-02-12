package com.again.day0212.basic;

public class Main {

    public static class Fraction {
        private int numerator;  // 분자
        private int denominator;    // 분모

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;

            normalize();
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        //약분
        public void normalize() {
            int gcd = gcd(numerator,denominator);

            this.numerator /= gcd;
            this.denominator /= gcd;
        }

        // 최대공약수
        public static int gcd(int first, int second) {
            first = Math.abs(first);
            second = Math.abs(second);
            int minNum = Math.min(first, second);
            int gcd = 1;

            for (int i = 1; i <= minNum; i++) {
                if (first % i == 0 && second % i == 0) {
                    gcd = i;
                }
            }

            return gcd;
        }

        @Override
        public String toString() {
            if(denominator < 0) {
                return numerator * -1 + "/" + denominator * -1;
            }

            return numerator + "/" + denominator;
        }
    }

    public static String solution(int numerator, int denominator) {
        Fraction fraction = new Fraction(numerator, denominator);

        return fraction.toString();
    }

    public static void main(String[] args) {
        for(int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1], Test_CASES_RESULT[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;

    private static boolean test(int numerator, int denominator, String result) {
        if (solution(numerator, denominator).equals(result)) {
            correct++;
            return true;
        }

        return false;
    }

    private static final int[][] TEST_CASES = {
            {1, 4},
            {-10, 20},
            {10, -20},
            {-5, -10},
            {7, 39},
            {100, 100},
            {369, 444},
            {1_000_000, 1_998_244_353},
            {1_234_567, 999_999_937}
    };

    private static String[] Test_CASES_RESULT = {
            "1/4",
            "-1/2",
            "-1/2",
            "1/2",
            "7/39",
            "1/1",
            "123/148",
            "1000000/1998244353",
            "1234567/999999937"
    };

}