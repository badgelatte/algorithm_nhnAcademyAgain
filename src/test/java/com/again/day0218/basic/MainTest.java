package com.again.day0218.basic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import java.util.List;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {

    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of(List.of(5, 9, 2, 4, 7), List.of(2, 5, 9, 7, 4)),
                Arguments.of(List.of(1, 3, 6, 8, 10), List.of(1, 6, 10, 8, 3)),
                Arguments.of(List.of(7, 2, 8, 1, 4, 6), List.of(1, 4, 7, 8, 6, 2)),
                Arguments.of(List.of(10, 9, 7, 4, 2, 1, 3), List.of(1, 3, 7, 10, 9, 4, 2)),
                Arguments.of(List.of(6, 4, 7, 5), List.of(4, 6, 7, 5)),
                Arguments.of(List.of(3, 9, 2, 6, 8, 1, 5), List.of(1, 3, 6, 9, 8, 5, 2)),
                Arguments.of(List.of(7, 3, 5, 1, 6), List.of(1, 5, 7, 6, 3)),
                Arguments.of(List.of(8, 5, 2, 9, 7, 1), List.of(1, 5, 8, 9, 7, 2))
        );
    }

    @ParameterizedTest(name = "Advanced {0} -> {1}")
    @MethodSource("testcases")
    @DisplayName("Selection Sort advanced")
    void selectionTest(List<Integer> unsorted, List<Integer> sorted) {
        int[] unsortedArray = unsorted.stream().mapToInt(Integer::intValue).toArray();
        int[] expected = sorted.stream().mapToInt(Integer::intValue).toArray();

        Main.solution(unsortedArray);

        assertArrayEquals(expected, unsortedArray);
    }


}