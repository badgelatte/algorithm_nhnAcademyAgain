package com.again.day0215.basic;

import com.again.day0215.OrderType;

// 0921에 완성한 풀이
public class OldMain {

    public static Integer[] solution(Integer[] arr, OrderType orderType) {
        int temp = 0;
        int j = 0;

        if(orderType == OrderType.ASC){
            while (j < arr.length) {
                for(int i = 0; i < arr.length-1; i++) {
                    if(arr[i] > arr[i+1]) {
                        temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                    }

                }
                j++;

                for (Integer integer : arr) {
                    System.out.print(integer + ", ");
                }
                System.out.println();

            }
        }
        else if(orderType == OrderType.DESC){
            while (j < arr.length) {
                for(int i = 0; i < arr.length-1; i++) {
                    if(arr[i] < arr[i+1]) {
                        temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                    }
                    System.out.print(arr[i] +", ");
                }
                j++;
                System.out.println(arr[arr.length-1]);
                System.out.println();
            }
        }
        System.out.println();
        return arr;
    }


    public static void main(String[] args) {
        Integer a[] = {5, 7, 2, 9, 10, 6, 1, 3, 4, 8};
        Integer b[] = {6, 1, 3, 4, 8, 5, 7, 2, 9, 10};

        solution(a, OrderType.DESC);

        solution(b, OrderType.ASC);

    }
}