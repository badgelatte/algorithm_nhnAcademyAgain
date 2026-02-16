package com.again.day0216.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {

    /**
     * [42, 17, 8, 64, 23, 91, 55, 3, 36, 70]
     * [19, 5, 12, 47, 88, 2, 30, 76, 9, 1]
     * [61, 78, 50, 38, 27, 14, 6, 59, 33, 68]
     * [22, 85, 7, 29, 53, 74, 11, 46, 20, 95]
     * [49, 31, 72, 45, 57, 26, 99, 37, 63, 83]
     * [21, 96, 58, 13, 86, 24, 66, 75, 4, 77]
     * [18, 82, 35, 90, 67, 32, 15, 54, 41, 98]
     * [60, 16, 25, 28, 71, 52, 40, 43, 73, 10]
     * [44, 34, 87, 94, 56, 81, 89, 62, 51, 69]
     *
     * @return
     */
    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of(List.of(42, 17, 8, 64, 23, 91, 55, 3, 36, 70),
                        List.of(3, 8, 17, 23, 36, 42, 55, 64, 70, 91), 7),
                Arguments.of(List.of(19, 5, 12, 47, 88, 2, 30, 76, 9, 1),
                        List.of(88, 76, 47, 30, 19, 12, 9, 5, 2, 1), 6),
                Arguments.of(List.of(61, 33, 27, 6, 14, 78, 50, 38, 59, 68),
                        List.of(6, 14, 27, 33, 38, 50, 59, 61, 68, 78), 3),
                Arguments.of(List.of(49, 63, 31, 72, 99, 83, 45, 57, 26, 37),
                        List.of(99, 83, 72, 63, 57, 49, 45, 37, 31, 26), 4),
                Arguments.of(List.of(21, 96, 58, 13, 86, 4, 24, 66, 75, 77),
                        List.of(4, 13, 21, 24, 58, 66, 75, 77, 86, 96), 5),
                Arguments.of(List.of(67, 90, 98, 82, 41, 54, 15, 18, 35, 32),
                        List.of(98, 90, 82, 67, 54, 41, 35, 32, 18, 15), 2),
                Arguments.of(List.of(44, 34, 51, 69, 94, 56, 62, 87, 81, 89),
                        List.of(34, 44, 51, 56, 62, 69, 81, 87, 89, 94), 2),
                Arguments.of(List.of(60, 16, 25, 28, 71, 52, 40, 43, 73, 10),
                        List.of(73, 71, 60, 52, 43, 40, 28, 25, 16, 10), 8)
        );
    }

    @ParameterizedTest(name = "Sort {0}, {1} --> {2}")
    @MethodSource("testcases")
    @DisplayName("Bubble Sort advanced 02")
    void bubbleSortTest(List<Integer> unsorted, List<Integer> sorted, int expected) {
        int[] unsortedArray = unsorted.stream().mapToInt(Integer::intValue).toArray();
        int[] sortedArray = sorted.stream().mapToInt(Integer::intValue).toArray();

        int actual = Main.solution(unsortedArray, sortedArray);

        assertEquals(expected, actual);
    }

}