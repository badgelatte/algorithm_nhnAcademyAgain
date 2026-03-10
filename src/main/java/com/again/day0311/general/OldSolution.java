package com.again.day0311.general;

import java.util.Stack;

// 1023에 완성한 풀이
public class OldSolution {
    public static void calc(int[] calcThing) {
        int result = 0;

        if(calcThing[2]== 43){
            result = calcThing[0] + calcThing[1];
        }
        else if(calcThing[2] == 45){
            result = calcThing[0] - calcThing[1];
        }
        else if(calcThing[2] == 42){
            result = calcThing[0] * calcThing[1];
        }
        else if(calcThing[2] == 47){
            result = calcThing[0] / calcThing[1];
        }
        calcThing[0] = result;
    }

    public static int evaluatePostFix(String str) {
        // TODO 1. Postfix 수식계산
        Stack<Character> stack = new Stack<Character>();    // array에서 stack으로 하나씩 밀어넣는다
        int[] calcThing = new int[3];   // 값 계산용

        // stack.add(str.toCharArray()); // 한번에 들어간다
        char[] array = str.toCharArray();

        // 근데 내가 짠건 하나씩 들어갈 경우야
        for(int k =0; k < array.length; k++){
            stack.push(array[k]);
            if(stack.peek() < 48) {
                if(calcThing[0] == 0) {
                    calcThing[2] = stack.pop();
                    calcThing[1] = stack.pop()-48;
                    calcThing[0]= stack.pop()-48;
                }else {
                    calcThing[2] = stack.pop();
                    calcThing[1] = stack.pop()-48;
                }
                calc(calcThing);
            }
        }
        return calcThing[0];
    }
}