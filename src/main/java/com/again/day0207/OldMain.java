package com.again.day0207;

public class OldMain {
    // 0912

    public static int solution(int start, int end) {
        int count = 0;

        for(int i = start; i < end; i++) {
            for(int j = 2; j <= i; j++) {
                // 1 혹은 나 자신으로만 나눠지면 소수 -> 어떠한 수로 나눠지면 for문을 탈출
                if(i == j) {
                    count++;
                } else if(i % j == 0) { // 나눠지면 나머지 == 0
                    break;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 50));
    }
}