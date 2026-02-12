package com.again.day0212.advanced;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("0.01", "1/100"),
                Arguments.of("0.25", "1/4"),
                Arguments.of("-0.25", "-1/4"),
                Arguments.of("0.99", "99/100"),
                Arguments.of("-0.99", "-99/100"),
                Arguments.of("0.5000000", "1/2"),
                Arguments.of("0.00000001", "1/100000000"),
                Arguments.of("0.1234567", "1234567/10000000")
        );
    }


    @ParameterizedTest(name = "{0} -> {1}")
    @DisplayName("소수 -> 분수 변환 테스트")
    @MethodSource("testCases")
    void test(String input, String result) {
        Assertions.assertEquals(result, Main.solution(input));
    }

}