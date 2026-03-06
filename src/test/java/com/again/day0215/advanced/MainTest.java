package com.again.day0215.advanced;

import com.again.day0215.OrderType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{5, 7, 2, 9, 10, 6, 1, 3, 4, 8},
                        new int[]{4, 9},
                        OrderType.ASC,
                        new Integer[]{1, 2, 3, 4, 10, 5, 6, 7, 9, 8}
                ),
                Arguments.of(
                        new Integer[]{6, 1, 3, 4, 8, 5, 7, 2, 9, 10},
                        new int[]{0, 2, 6, 7},
                        OrderType.DESC,
                        new Integer[]{6, 10, 3, 9, 8, 5, 7, 2, 4, 1}
                )
        );
    }

    @Disabled
    @ParameterizedTest(name = "{0}, {1}, {2} --> {3}")
    @MethodSource("testcases")
    @DisplayName("버블 정렬 advanced 테스트")
    void bubbleSortTest(Integer[] arr, int[] indexs, OrderType orderType, Integer[] answer) {
        assertTrue(Arrays.deepEquals(Main.solution(arr, indexs, orderType), answer));
    }
}