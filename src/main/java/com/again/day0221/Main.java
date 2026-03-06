package com.again.day0221;

public class Main {

    static int[] sortedArray;

    public static int add(int intValue) {
        int[] tempArray = new int[sortedArray.length + 1];

        for (int i = 0; i < sortedArray.length; i++) {
            tempArray[i] = sortedArray[i];
        }

        tempArray[tempArray.length - 1] = intValue;
        sortedArray = tempArray;

        int insertedIndex = solution(sortedArray);
        System.out.println(intValue + ", " + insertedIndex);
        return insertedIndex;
    }


    public static int solution(int[] inputs) {
        int num = inputs.length - 1;
        int count = 0;

        for (int input : inputs) {
            if (input < inputs[num]) {
                count++;
            }
        }

        return count;
    }
}