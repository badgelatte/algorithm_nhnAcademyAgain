package com.again.day0206;

// 0911
public class OldMain {
    private static double correctCount = 0;
    private static final String[][] TESTCASES = new String[][]{
            {"abciwkabc", "abc", "2"},
            {"aciwcosck", "c", "3"},
            {"banana", "na", "2"},
            {"alhorithmtest", "th", "1"},
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(String input, String input2, String answer) {
        boolean res = String.valueOf(solution(input, input2)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }

    public static int solution(String first, String second) {
        int count = 0;
        int where = 0;

        // 초기에 어디서부터 첫번째 일치하는 것이 나오는가  // indexOf - 매개변수를 찾아서 그 자리의 index를 반환한다.
        where = first.indexOf(second);
        count++;
        while (where >= 0 && where <= first.length()) {
            where = first.indexOf(second, where + second.length());
            if (where < 0) {
                break;
            }
            count++;
        }
        System.out.println(count);
        return count;
    }
}