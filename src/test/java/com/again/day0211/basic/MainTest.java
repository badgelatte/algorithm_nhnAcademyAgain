package com.again.day0211.basic;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(123, 345, 14145),
                Arguments.of(2, 81, 162),
                Arguments.of(3, 7, 21),
                Arguments.of(19, 87, 1653),
                Arguments.of(1, 40, 40)
        );
    }

    @ParameterizedTest(name = "{0} and {1}'s LCM is {2}")
    @MethodSource("testCases")
    @DisplayName("최소 공배수 테스트")
    void algorithm_test(int first, int second, int answer) {
        Assertions.assertEquals(answer, Main.solution(first, second));
    }
}