package com.again.day0307;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("arr size = 5")
    void test1(){
        int[] arr = {1,2,3,-2,5};
        long actual = Solution.maxSubarraySum(arr);
        Assertions.assertEquals(9l,actual);
    }

    @Test
    @DisplayName("arr size = 4")
    void test2(){
        int[] arr = {-1,-2,-3,-4};
        long actual = Solution.maxSubarraySum(arr);
        Assertions.assertEquals(-1l,actual);
    }

    @Test
    @DisplayName("arr size = 6")
    void test3(){
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        long actual = Solution.maxSubarraySum(arr);
        Assertions.assertEquals(7,actual);
    }

}