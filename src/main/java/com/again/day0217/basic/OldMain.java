package com.again.day0217.basic;

// 0925에 풀었던 풀이방식
public class OldMain {
    public static String solution(String input) {
        int[] array = new int[input.length()];
        char num;
        int small;
        int temp;
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            num = input.charAt(i);
            // System.out.print(num);
            array[i] = num-48;
            // System.out.print(array[i] +": " + i + " / ");
        }
        // System.out.println();


        for (int i = 0; i < array.length; i++) {
            small = array[i];
            int smallindex = i;
            for (int j = i+1; j < array.length; j++) {
                if(small > array[j]) {
                    small = array[j];
                    smallindex = j;
                }
            }
            temp = array[smallindex];
            array[smallindex] = array[i];
            array[i] = temp;

        }

        for (Integer i : array) {
            System.out.print(i);
            result += i.toString();
        }
        System.out.println();
        return result;
    }
    public static void main(String[] args) {
        solution("83014729");
    }
}