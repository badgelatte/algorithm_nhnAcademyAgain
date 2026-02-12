package com.again.day0212.advanced;

import java.math.BigDecimal;

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


        public void normalize() {

        }

        public static int gcd(int first, int second) {
            if(second == 0)
                return first;
            else
                return gcd(second, first % second);
        }


    }

    /**
     * 소수점 값에 대해 자리 수 계산 하는 메서드.    <br/>
     * ex)  <br/>
     * 0.01 -> 100을 곱하기 위해 2를 return    <br/>
     * 0.1 -> 10을 곱하기 위해 1을 return
     *
     *
     * @param num   소수 값
     * @return      소수점 이하 자리 수 값
     */
    public static int getDecimalNumber(BigDecimal num) {
        String str = num.toPlainString();

        return 0;
    }

    public static String solution(String input) {
        BigDecimal number = new BigDecimal(input);

        int decimalNumber = getDecimalNumber(number);

        double denominator = 0;
        int numerator = 0;

        return new Fraction(numerator, (int) denominator).toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }




    private static final String[][] TEST_CASES = {
            {"0.01", "1/100"},
            {"0.25", "1/4"},
            {"-0.25", "-1/4"},
            {"0.99", "99/100"},
            {"-0.99", "-99/100"},
            {"0.5000000", "1/2"},
            {"0.00000001", "1/100000000"},
            {"0.1234567", "1234567/10000000"}
    };

    private static double correct = 0;

    public static boolean test(String input, String result) {
        if (solution(input).equals(result)) {
            correct++;
            return true;
        }

        return false;
    }
}