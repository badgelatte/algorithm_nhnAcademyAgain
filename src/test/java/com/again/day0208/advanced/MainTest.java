package com.again.day0208.advanced;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {

    private static final Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, "1 = 1"),
                Arguments.of(60, "2 * 2 * 3 * 5 = 60"),
                Arguments.of(256, "2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 256"),
                Arguments.of(325, "5 * 5 * 13 = 325"),
                Arguments.of(20160, "2 * 2 * 2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 = 20160"),
                Arguments.of(3_456_789, "3 * 7 * 97 * 1697 = 3456789"),
                Arguments.of(10_000_001, "11 * 909091 = 10000001"),
                Arguments.of(1_234_567_890, "2 * 3 * 3 * 5 * 3607 * 3803 = 1234567890")
        );
    }

    @ParameterizedTest(name = "{0} --> {1}")
    @MethodSource("testCases")
    @DisplayName("소인수분해 Test")
    void test(int number, String result) {
        Assertions.assertEquals(result, Main.solution(number));
    }
}