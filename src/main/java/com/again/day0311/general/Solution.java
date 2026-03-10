package com.again.day0311.general;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class Solution {
    public static int evaluatePostFix(String str) {
        // TODO 1. Postfix 수식계산
        String[] strs = str.split("");
        Stack<Integer> numbers = new Stack<>();
        int result = 0;
        int num = 0;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("+")) {
                num = numbers.pop();
                result = numbers.pop() + num;
                numbers.push(result);
                log.info("result : {}", result);
            }
            else if (strs[i].equals("-")) {
                num = numbers.pop();
                result = numbers.pop() - num;
                numbers.push(result);
                log.info("result : {}", result);
            }
            else if (strs[i].equals("*")) {
                num = numbers.pop();
                result = numbers.pop() * num;
                numbers.push(result);
                log.info("result : {}", result);
            }
            else if (strs[i].equals("/")) {
                num = numbers.pop();
                result = numbers.pop() / num;
                numbers.push(result);
                log.info("result : {}", result);
            }
            else {
                numbers.push(Integer.parseInt(strs[i]));
            }
        }

        return numbers.pop();
    }
}