package com.again.day0212.basic;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, 4, "1/4"),
                Arguments.of(-10, 20, "-1/2"),
                Arguments.of(10, -20, "-1/2"),
                Arguments.of(-5, -10, "1/2"),
                Arguments.of(7, 39, "7/39"),
                Arguments.of(100, 100, "1/1"),
                Arguments.of(369, 444, "123/148"),
                Arguments.of(1_000_000, 1_998_244_353, "1000000/1998244353"),
                Arguments.of(1_234_567, 999_999_937, "1234567/999999937")
        );
    }

    @ParameterizedTest(name = "{0}/{1} --> {2}")
    @MethodSource("testCases")
    @DisplayName("기약 분수 test")
    void test(int numerator, int denominator, String result) {
        Assertions.assertEquals(result, Main.solution(numerator, denominator));
    }
}