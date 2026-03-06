package com.again.day0214.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

    @MethodSource("cases")
    @ParameterizedTest
    @DisplayName("특정 인덱스만 제외하고 문자열 뒤집기")
    void reverseWord(char[] input, int[] indexes, char[] expected) {

        Main.solution(input,indexes);

        assertEquals(
                String.valueOf(expected),
                String.valueOf(input)
        );
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("Hello".toCharArray(),new int[]{0,3}, "Holle".toCharArray()),
                Arguments.of("Computer".toCharArray(),new int[]{0,5}, "Creuptmo".toCharArray()),
                Arguments.of("Sunshine".toCharArray(),new int[]{3,5}, "enhsniuS".toCharArray()),
                Arguments.of("Butterfly".toCharArray(),new int[]{1,7}, "yufrettlB".toCharArray()),
                Arguments.of("Chocolate".toCharArray(),new int[]{3,6},"etlcooahC".toCharArray()),
                Arguments.of("Adventure".toCharArray(),new int[]{2,5,6},"ervnetudA".toCharArray()),
                Arguments.of("banana".toCharArray(),new int[]{1,2,3,4}, "aananb".toCharArray()),
                Arguments.of("apple".toCharArray(),new int[]{0,1,3,4}, "apple".toCharArray())
        );
    }
}
