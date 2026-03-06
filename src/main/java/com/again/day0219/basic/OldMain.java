package com.again.day0219.basic;

// 0927에 풀었던 방식
public class OldMain {
    public static String solution(String input) {
        int[] array = new int[input.length()];
        String result = "";

        // String -> int 형변환
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i);
            array[i] = num - 48;
        }

        // 앞에서부터 순서대로 배치하기
        for (int i = 0; i < array.length; i++) {
            int small = i;
            // 해당 순서의 가장 작은 수 구하기
            for (int j = i; j < array.length; j++) {
                if (array[small] > array[j]) {
                    small = j;
                }
            }

            // 찾아놓은 가장 작은 수 i번째 자리에 꽂기
            int temp = array[small];
            for (int j = small; j - 1 >= i; j--) {
                array[j] = array[j - 1];
            }
            array [i] = temp;

        }

        // string으로 형변환
        for (int i : array) {
            result += Integer.toString(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("53950971392"));
    }
}