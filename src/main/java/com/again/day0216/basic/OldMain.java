package com.again.day0216.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 0922에 풀었던 방식
public class OldMain {
    public static int solution(int[] array, int[] second) {
        // (오른쪽에서 왼쪽으로) 젤 많이 움직이는 수가 버블정렬 횟수이다
        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if(second[j] == array[i]){
                    count.add(i-j);
                }
            }
        }
        int a = Collections.max(count);
        return a;
        /*
        // swap하여 정렬하기
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int l : array) {
                System.out.print(l + ", ");
            }
            System.out.println();

            boolean changed = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    changed = true;
                    swap(array, j, j + 1);

                }
            }
            System.out.println();
            if (!changed) {
                System.out.println(i);
                break;
            }
            count++;
        }

        return count; */

    }

    public static int[] swap(int[] array, int left, int right) {
        int temp;

        temp = array[left];
        array[left] = array[right];
        array[right] = temp;

        return array;

    }

    /* public static void main(String[] args) {
        int[] a = { 42, 17, 8, 64, 23, 91, 55, 3, 36, 70 };
        int[] b = { 3, 8, 17, 23, 36, 42, 55, 64, 70, 91 };

        System.out.println("count : " + solution(a, b));
    } */
}