package com.again.day0220;

public class Main {

    static int[] sortedArray;

    public static int solution(int[] sortedArray) {
        return 0;
    }

    public static int add(int intValue) {
        int[] tempArray = new int[sortedArray.length + 1];

        for (int i = 0; i < sortedArray.length; i++) {
            tempArray[i] = sortedArray[i];
        }

        tempArray[tempArray.length - 1] = intValue;
        sortedArray = tempArray;

        int insertedIndex = solution(sortedArray);

        return insertedIndex;
    }

}