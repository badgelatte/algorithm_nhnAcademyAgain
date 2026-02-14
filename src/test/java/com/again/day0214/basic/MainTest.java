package com.again.day0214.basic;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {

    @Disabled
    @Test
    void usePrimitives() {
        int a = 1;
        int b = 2;

        int beforeA = a;
        int beforeB = b;

        Main.swapPrimitive(a, b);

        assertAll(
                "Swap A and B",
                () -> assertEquals(a, beforeB),
                () -> assertEquals(b, beforeA)
        );
    }

    @Test
    void useReference() {
        int a = 1;
        int b = 2;

        // Enter Your Code

        int[] input = {1, 2};

        Main.swapReference(input);

        assertAll(
                "Swap A and B",
                () -> assertEquals(a, input[1]),
                () -> assertEquals(b, input[0])
        );
    }

    @MethodSource("cases")
    @ParameterizedTest
    @DisplayName("문자열 뒤집기")
    void reverseWord(char[] input, char[] expected) {

        Main.solution(input);

        assertEquals(
                String.valueOf(expected),
                String.valueOf(input)
        );
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("Hello".toCharArray(), "olleH".toCharArray()),
                Arguments.of("Computer".toCharArray(), "retupmoC".toCharArray()),
                Arguments.of("Sunshine".toCharArray(), "enihsnuS".toCharArray()),
                Arguments.of("Butterfly".toCharArray(), "ylfrettuB".toCharArray()),
                Arguments.of("Chocolate".toCharArray(), "etalocohC".toCharArray()),
                Arguments.of("Adventure".toCharArray(), "erutnevdA".toCharArray()),
                Arguments.of("banana".toCharArray(), "ananab".toCharArray()),
                Arguments.of("apple".toCharArray(), "elppa".toCharArray())
        );
    }
}