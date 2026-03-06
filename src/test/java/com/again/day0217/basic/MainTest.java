package com.again.day0217.basic;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {
    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of("572961348", "123456789"),
                Arguments.of("83014729", "01234789"),
                Arguments.of("5359713250", "0123355579")
        );
    }

    @ParameterizedTest(name = "Selection sort {0} --> {1}")
    @MethodSource("testcases")
    @DisplayName("선택 정렬 basic 테스트")
    void mainTest(String before, String after) {
        assertEquals(Main.solution(before), after);
    }
}