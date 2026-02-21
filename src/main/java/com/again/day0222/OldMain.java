package com.again.day0222;

import java.util.ArrayList;
import java.util.List;

// 1005에 완성한 풀이
public class OldMain {
    public static String solution(String input) {
        int[] array = {};
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // 2개씩으로 나누기
        list2.add(input.substring(0, list1.size() / 2));
        list2.add(input.substring(list1.size() / 2 + 1, list1.size()));
        while (true) {
            list1.removeAll(list1);
            list1.addAll(list2);
            //
            if (list1.get(0).length() > 1) {
                for (int i = 0; i < list1.size(); i++) {
                    // 초기화하고 안에 2개씩 나눠서 집어넣기
                    list2.removeAll(list2);
                    list2.add(list1.get(i).substring(0, list1.get(i).length() / 2));
                    list2.add(list1.get(i).substring(list1.get(i).length() / 2 + 1, list1.get(i).length()));
                }
            } else {
                break;
            }
        }
        // list1, list2 모두 같은 걸 가지고 있다.

        // string -> int
        for (int i = 0; i < list1.size(); i++) {
            array[i] = Integer.parseInt(list1.get(i));
        }

        // 2팀씩 비교
        return "";
    }
}