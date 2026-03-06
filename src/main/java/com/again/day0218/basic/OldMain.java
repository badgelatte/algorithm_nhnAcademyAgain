package com.again.day0218.basic;

import java.util.List;

// 0926에 했던 풀이
public class OldMain {
    // 앞에서부터 배치
    public static int[] left(int i, int[] array) {
        int small = array[i];
        int smallindex = i;
        for (int j = i; j < array.length - i;j++) {
            // i가 2번 돌때마다 끝내는 조건부 만들기
            if(small > array[j]){
                small = array[j];
                smallindex = j;
            }

        }
        int temp = array[smallindex];
        array[smallindex] = array[i];
        array[i] = temp;


        System.out.println(i+1 + "차 정렬 앞쪽");
        for (int l : array) {
            System.out.print(l +" ");
        }
        System.out.println();


        return array;
    }

    // 뒤에서부터 배치
    public static int[] right(int i, int[] array) {
        int small = array[i+1];
        int smallindex = i+1;

        for (int j = i + 1; j < array.length - i;j++) {
            // i가 2번 돌때마다 끝내는 조건부 만들기
            if(small > array[j]){
                small = array[j];
                smallindex = j;
            }
            /* else if(small == array[i]) {
                continue;
            } */
        }
        int temp = array[smallindex];
        array[smallindex] = array[array.length - i-1];
        array[array.length - i-1] = temp;

        System.out.println(i+1+ "차 정렬 뒤쪽");
        for (int l : array) {
            System.out.print(l +" ");
        }
        System.out.println();

        return array;
    }


    public static void solution(int[] array) {
        int small;
        int smallindex;
        int temp = 0;

        for (int i = 0; i < array.length/2 ;i++) {
            small = array[i];
            smallindex = i;

            left(i,array);


            right(i, array);

            /* // 짝수는 앞에 배치
            if(i % 2 == 0) {
                temp = array[smallindex];
                array[smallindex] = array[i/2];
                array[i/2] = temp;
                System.out.println("현재 바꾼 위치 짝수 : " + i/2);

            } */


            /* // 홀수는 뒤에 배치 -> 5 - i = 1, 3 , 5 = 4, 2, 0 => 4, 3, 2
            if(i % 2 == 1) {
                temp = array[smallindex];
                array[smallindex] = array[array.length -(i / 2) - 1];
                array[array.length -(i / 2) - 1] = temp;
                int a = array.length -(i / 2) - 1;
                System.out.println("현재 바꾼 위치 홀수: " + a);
            } */



        }
    }


    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 7, 1};
        solution(array);

        /* solution({});
        10, 9, 7, 4, 2, 1, 3
1, 3, 6, 8, 10
7, 2, 8, 1, 4, 6
10, 9, 7, 4, 2, 1, 3
6, 4, 7, 5
3, 9, 2, 6, 8, 1, 5
7, 3, 5, 1, 6
5, 9, 2, 4, 7 */
    }

}