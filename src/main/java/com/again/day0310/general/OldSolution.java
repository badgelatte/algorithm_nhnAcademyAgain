package com.again.day0310.general;

import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

// 1020에 완성한 풀이
@Slf4j
public class OldSolution {
    public static void check(String str) {
        if(str.length() > 100){
            throw new IllegalArgumentException();
        }
    }

    public static String reverse(String str){
        //todo 1.stack을 이용한 문자열 뒤집기 구현.
        // str의 범위는 0 < str <=100 입니다.
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();

        check(str);
        for (int i = str.length()-1; i >= 0; i--) {
            stack.push(str.toCharArray()[i]);
            result.append(stack.pop());
        }

        return result.toString();
    }
}
