package com.again.day0213.basic;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {
    private static Stream<Arguments> factorialCases() {
        return Stream.of(
                Arguments.of(0, 1L),
                Arguments.of(1, 1L),
                Arguments.of(7, 5_040L),
                Arguments.of(8, 40_320L),
                Arguments.of(13, 6_227_020_800L),
                Arguments.of(15, 1_307_674_368_000L),
                Arguments.of(20, 2_432_902_008_176_640_000L)
        );
    }

    private static Stream<Arguments> fibonacciCases() {
        return Stream.of(
                Arguments.of(0, 0L),
                Arguments.of(1, 1L),
                Arguments.of(10, 55L),
                Arguments.of(30, 832_040L),
                Arguments.of(45, 1_134_903_170L),
                Arguments.of(50, 12_586_269_025L)
        );
    }

    @ParameterizedTest(name = "Factorial {0} --> {1}")
    @MethodSource("factorialCases")
    @DisplayName("팩토리얼 테스트")
    void factorialTest(int number, long result) {
        Assertions.assertEquals(result, Main.factorial(number));
    }


    @ParameterizedTest(name = "Fibonacci {0} --> {1}")
    @MethodSource("fibonacciCases")
    @DisplayName("피보나치 테스트")
    void fibonacciTest(int number, long result) {
        Assertions.assertEquals(result, Main.fibonacci(number));
    }
}