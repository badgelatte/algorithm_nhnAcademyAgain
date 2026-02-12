package com.again.day0212.basic;

public class OldMain {

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

        public void normalize() {
            // TODO 약분
            if(numerator < 0 ) {
                numerator *= -1;
            }
            if(denominator < 0) {
                denominator *= -1;
            }

            int afternumberator = numerator / gcd(numerator, denominator);
            this.denominator = denominator / gcd(numerator, denominator);
            this.numerator = afternumberator;

            // System.out.println(gcd(numerator, denominator) + " : gcd");
            // System.out.println(numerator + " : numerator");
            // System.out.println(denominator + " : denominator");
        }

        // TODO 최대공약수
        public static int gcd(int first, int second) {
            int small = 0;
            int end =  0;
            if(first < 0 ) {
                first *= -1;
            }
            if(second < 0) {
                second *= -1;
            }

            if(first > second) {
                small = second;
            } else {
                small = first;
            }

            for(int i = 1; i <= small; i++) {
                if(first % i == 0 && second % i == 0) {
                    end = i;
                }
            }

            // System.out.println("end: " + end);
            return end;
        }

        // TODO
        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    public static String solution(int numerator, int denominator) {
        // TODO
        // System.out.println(numerator+": solution_numerator");
        // System.out.println(denominator + ": solution_numerator");
        Fraction fraction = new Fraction(numerator, denominator);
        /* if(numerator < 0 || denominator <0) {
            if (numerator < 0 && denominator <0) {
            }else {
                numerator *= -1;
            }
        } */

        // - 해결
        if(numerator < 0) {
            if(denominator < 0) {   // numerator < 0 && denominator < 0
            }
            else {  // numerator < 0 && denominator >= 0
                fraction.numerator *= -1;
            }
        }else if (denominator < 0) {    // numerator >= 0 && denominator < 0
            fraction.numerator *= -1;
        }

        // System.out.println("numerator : " + fraction.numerator + " denominator: " + fraction.denominator);
        /* fraction.numerator/= fraction.gcd(numerator, denominator);
        fraction.denominator /= fraction.gcd(numerator, denominator); */
        numerator = fraction.numerator;
        denominator = fraction.denominator;
        // System.out.println(numerator + "/" + denominator);
        // System.out.println(fraction);
        return fraction +"";
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