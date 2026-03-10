package com.again.day0310.general;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@Slf4j
class SolutionTest {

    @Test
    @DisplayName("문자열 뒤집기")
    void reverse() {
        String str = "nhn-academy";
        Assertions.assertEquals(new StringBuilder(str).reverse().toString(),Solution.reverse(str) );
    }


    @Test
    @DisplayName("문자열 길이 : 120")
    void string_length_test(){
        String str = new Random().ints(97,123)
                .limit(120).collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append)
                .toString();
        log.info("rand-str:{}", str);
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            Solution.reverse(str);
        });
    }
}