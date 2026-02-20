package com.again.day0220;

import java.util.ArrayList;
import java.util.List;

// 1004에 완성한 풀이
public class OldMain {

    static int[] sortedArray;

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
    public static void main(String[] args) {
        // 5, 2, 7, 1, 8, 3, 6, 9
        List<Integer> actual = new ArrayList<>();
        int [] unsortedArray = {5, 2, 7, 1, 8, 3, 6, 9};
        Main.sortedArray = new int[0];
        for (int intValue : unsortedArray) {
            actual.add(Main.add(intValue));
        }
    }

    private static int solution(int[] sortedArray) {
        // 옮길려는 수 = sortedArray의 맨마지막 수
        int count = sortedArray.length-1;

        // count-1 >= 0 -> 끝까지 돌릴 수 있다면 다 돌린다
        while (count-1 >= 0) {
            // 이전의 수가 현재의 수보다 크다면 이전의 수를 현재의 수 뒤로 배치해야하므로(오름차순) swap 하기
            if(sortedArray[count] < sortedArray[count-1]){
                int temp = sortedArray[count];
                sortedArray[count] = sortedArray[count-1];
                sortedArray[count-1] = temp;
                count--;
            }
            // 들어왔던 수(= array 마지막 수)가 제자리를 찾았다면
            // 더이상 swap하면 안되기에 while문을 깬다
            // 이거 설정 안하면 count--가 if문 안에 있기 때문에, 더이상 swap안되면 while문이 안깨진다.
            else {
                break;
            }
        }

        // sysout으로 변천사 볼라고 만든거
        String result = "";

        for (int i : sortedArray) {
            result += Integer.toString(i);
        }
        System.out.println("result : " + result);

        return count;
    }

}