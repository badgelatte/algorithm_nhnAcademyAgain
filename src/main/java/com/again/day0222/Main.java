package com.again.day0222;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String solution(String input) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add(input.substring(0,input.length()/2));
        list2.add(input.substring(input.length()/2));

        String left = list1.getFirst();
        String right = list2.getFirst();
        int leftSize = 0;
        int rightSize = 0;

        // divide
        for (int i = 0; i < input.length()/2 - 1; i++) {
            leftSize = list1.size();
            rightSize = list2.size();

            while(leftSize > 0) {
                left = list1.get(leftSize - 1);
                leftSize--;

                if(left.length() > 1) {
                    list1.remove(left);
                    list1.add(left.substring(0, left.length()/2));
                    list2.add(left.substring(left.length()/2));
                }

            }

            while(rightSize > 0) {
                right = list2.get(rightSize - 1);
                rightSize--;

                if(right.length() > 1) {
                    list2.remove(right);
                    list1.add(right.substring(0, right.length()/2));
                    list2.add(right.substring(right.length()/2));
                }
            }
        }

        list1.addAll(list2);
        int[] arr = strListToIntArr(list1);


        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static int[] strListToIntArr(List<String> stringList) {
        int[] arr = new int[stringList.size()];

        for (int i = 0; i < stringList.size(); i++) {
            arr[i] = Integer.parseInt(stringList.get(i));
        }

        return arr;
    }
}
