package com.again.day0219.advanced;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import java.util.List;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {

    private static Stream<Arguments> testcases() {
        return Stream.of(Arguments.of(List.of(5, 7, 2, 9, 10, 6, 1, 3, 4, 8), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @ParameterizedTest(name = "Advanced {0} -> {1}")
    @MethodSource("testcases")
    @DisplayName("Bubble Sort advanced")
    void bubbleTest(List<Integer> unsorted, List<Integer> sorted) {
        int[] unsortedArray = unsorted.stream().mapToInt(Integer::intValue).toArray();
        int[] expected = sorted.stream().mapToInt(Integer::intValue).toArray();

        Main.bubble(unsortedArray);
        assertArrayEquals(expected, unsortedArray);
    }

    @ParameterizedTest(name = "Advanced {0} -> {1}")
    @MethodSource("testcases")
    @DisplayName("Selection Sort advanced")
    void selectionTest(List<Integer> unsorted, List<Integer> sorted) {
        int[] unsortedArray = unsorted.stream().mapToInt(Integer::intValue).toArray();
        int[] expected = sorted.stream().mapToInt(Integer::intValue).toArray();

        Main.selection(unsortedArray);
        assertArrayEquals(expected, unsortedArray);
    }

    @ParameterizedTest(name = "Advanced {0} -> {1}")
    @MethodSource("testcases")
    @DisplayName("Insertion Sort advanced")
    void insertionTest(List<Integer> unsorted, List<Integer> sorted) {
        int[] unsortedArray = unsorted.stream().mapToInt(Integer::intValue).toArray();
        int[] expected = sorted.stream().mapToInt(Integer::intValue).toArray();

        Main.insertion(unsortedArray);
        assertArrayEquals(expected, unsortedArray);
    }
}