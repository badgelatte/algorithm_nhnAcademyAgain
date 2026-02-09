package com.again.day0209.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {
    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of(new int[]{ 3, 6, 8, 10 }, 3),
                Arguments.of(new int[]{ 5, 7, 12 }, 1),
                Arguments.of(new int[]{ 10, 20, 30, 40 }, 20),
                Arguments.of(new int[]{ 12, 22, 46, 55, 89 }, 11),
                Arguments.of(new int[]{ 15, 25, 125 }, 25),
                Arguments.of(new int[]{ 100, 155, 324, 450 }, 50)
        );
    }

    @ParameterizedTest(name = "{0} --> {1}")
    @MethodSource("testcases")
    @DisplayName("[007-1] 최대 최대공약수")
    void test(int[] input, int answer) {
        assertEquals(Main.solution(input), answer);
    }
}