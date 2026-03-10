package com.again.day0310.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class SolutionTest {

    double arr[];

    @BeforeEach
    void setUp(){
        arr = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    @DisplayName("empty array")
    void empty_array(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            Solution.calcStandardDeviation(new double[]{});
        });
    }

    @Test
    @DisplayName("표준편차")
    void calcStandardDeviation() {
        double actual = Solution.calcStandardDeviation(arr);
        log.info("actual:{}",actual);
        Assertions.assertEquals(2.8722813232690143,actual);
    }
}