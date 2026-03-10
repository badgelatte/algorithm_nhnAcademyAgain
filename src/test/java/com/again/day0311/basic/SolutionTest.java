package com.again.day0311.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {
    double[] arr;

    @BeforeEach
    void setUp(){
        arr = new double[]{ 23.4, -34.5, 50.0, 33.5, 55.5, 43.7, 5.7, -66.5 };
    }

    @Test
    @DisplayName("array length : 0")
    void empty_array(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Solution.getLargestNumber(new double[]{});
        });
    }

    @Test
    @DisplayName("largest number")
    void getLargestNumber() {
        double actual = Solution.getLargestNumber(arr);
        Assertions.assertEquals(55.5, actual);
    }

    @Test
    @DisplayName("smallest number")
    void getSmallestNumber() {
        double actual = Solution.getSmallestNumber(arr);
        Assertions.assertEquals(-66.5, actual);
    }
}