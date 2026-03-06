package com.again.day0208.basic;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {
    private static final Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(60, List.of(2, 2, 3, 5)),
                Arguments.of(1000, List.of(2, 2, 2, 5, 5, 5)),
                Arguments.of(123_454_321, List.of(41, 41, 271, 271)),
                Arguments.of(2_100_000_012, List.of(2, 2, 3, 11, 11, 1446281)),
                Arguments.of(2, List.of(2)),
                Arguments.of(13, List.of(13)),
                Arguments.of(8, List.of(2, 2, 2))
        );
    }

    @ParameterizedTest(name = "{0} --> {1}")
    @MethodSource("testCases")
    @DisplayName("소인수분해 Test")
    void test(int number, List<Integer> result) {
        Assertions.assertEquals(Main.solution(number), result);
    }
}