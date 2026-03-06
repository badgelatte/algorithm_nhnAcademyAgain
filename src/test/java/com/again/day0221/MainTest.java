package com.again.day0221;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {

    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of(List.of(5, 2, 7, 1, 8, 3, 6, 9), List.of(0, 0, 2, 0, 4, 2, 4, 7)),
                Arguments.of(List.of(9, 4, 6, 2, 1, 7, 3, 5), List.of(0, 0, 1, 0, 0, 4, 2, 4)),
                Arguments.of(List.of(8, 2, 5, 6, 1, 7, 4, 9), List.of(0, 0, 1, 2, 0, 4, 2, 7)),
                Arguments.of(List.of(3, 1, 6, 7, 4, 2, 8), List.of(0, 0, 2, 3, 2, 1, 6)),
                Arguments.of(List.of(7, 5, 4, 2, 3, 6, 1), List.of(0, 0, 0, 0, 1, 4, 0)),
                Arguments.of(List.of(1, 7, 3, 6, 8, 2, 4), List.of(0, 1, 1, 2, 4, 1, 3)),
                Arguments.of(List.of(6, 3, 5, 4, 2, 7, 1), List.of(0, 0, 1, 1, 0, 5, 0)),
                Arguments.of(List.of(4, 2, 8, 1, 7, 6, 3), List.of(0, 0, 2, 0, 3, 3, 2)),
                Arguments.of(List.of(2, 6, 1, 8, 4, 3, 7), List.of(0, 1, 0, 3, 2, 2, 5)),
                Arguments.of(List.of(5, 7, 3, 1, 6, 2, 4), List.of(0, 1, 0, 0, 3, 1, 3)));
    }

    @ParameterizedTest(name = "Advanced {0} -> {1}")
    @MethodSource("testcases")
    @DisplayName("Insertion Sort advanced")
    void insertionSortAdvanced(List<Integer> unsorted, List<Integer> expected) {
        int[] unsortedArray = unsorted.stream().mapToInt(Integer::intValue).toArray();

        List<Integer> actual = new ArrayList<>();
        Main.sortedArray = new int[0];

        for (int intValue : unsortedArray) {
            actual.add(Main.add(intValue));
        }

        assertIterableEquals(expected, actual);
    }

}