package com.again.day0215.basic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import com.again.day0215.OrderType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {
    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of(new Integer[]{5, 7, 2, 9, 10, 6, 1, 3, 4, 8}, OrderType.ASC, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
                Arguments.of(new Integer[]{6, 1, 3, 4, 8, 5, 7, 2, 9, 10}, OrderType.DESC, new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
        );
    }

    @ParameterizedTest(name = "BubbleSort {0}, {1} --> {2}")
    @MethodSource("testcases")
    @DisplayName("버블 정렬 테스트")
    void bubbleSortTest(Integer[] arr, OrderType orderType, Integer[] answer) {
        assertTrue(Arrays.deepEquals(Main.solution(arr, orderType), answer));
    }
}