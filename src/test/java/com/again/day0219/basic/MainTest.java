package com.again.day0219.basic;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {
    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of("759618324", "123456789"),
                Arguments.of("473823019", "012334789"),
                Arguments.of("53950971392", "01233557999")
        );
    }

    @ParameterizedTest(name = "Insertion sort {0} --> {1}")
    @MethodSource("testcases")
    @DisplayName("삽입 정렬 basic 테스트")
    void mainTest(String before, String after) {
        assertEquals(Main.solution(before), after);
    }
}