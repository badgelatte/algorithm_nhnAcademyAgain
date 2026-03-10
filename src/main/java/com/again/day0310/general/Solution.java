package com.again.day0310.general;

import java.util.Stack;

public class Solution {

    public static String reverse(String str){
        //todo 1.stack을 이용한 문자열 뒤집기 구현.
        // str의 범위는 0 < str <=100 입니다.
        Stack<Character> stack = new Stack<>();
        StringBuilder reverseStr = new StringBuilder();

        if (str.isEmpty() || str.length() > 100) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            reverseStr.append(stack.pop());
        }
        return reverseStr.toString();
    }

}