package com.again.day0311.general;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class SolutionTest {
    @Test
    @DisplayName("Postfix - test1")
    void evaluatePostFixTest1() {
        String preOrder = "352*+9-";
        int result = Solution.evaluatePostFix(preOrder);
        log.info("result : {}", result);
        Assertions.assertEquals(4, result);
    }

    @Test
    @DisplayName("Postfix - test2")
    void evaluatePostFixTest2() {
        String preOrder = "652*+4/";
        int result = Solution.evaluatePostFix(preOrder);
        log.info("result : {}", result);
        Assertions.assertEquals(4, result);
    }
}