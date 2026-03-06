package com.again.day0307;

// 1018에 완성한 풀이
public class OldSolution {
    private static int[] sum;
    private static int check = 0;

    public static void sumArr(int[] arr, int[] sum) {
        // 초기 값 세팅
        if(arr[0] + arr[1] != 0){
            check = arr[0] + arr[1] > 0 ? 1 : -1;
        }
        sum[0] = arr[0];

        // 앞 뒤 배열의 합 구하기
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i-1] + arr[i];
            if(sum[i] < 0 && check == -1) {      // 앞 뒤 배열의 수 합이 -가 모두 -인가를 체크
                check = -1;
            }
            else if(sum[i] > 0 && check == 1) { // 앞 뒤 배열의 수 합이 모두 +인가를 체크
                check = 1;
            }
            else {
                check = 0;
            }
        }
    }

    public static int checkPlusMinus(int check) {
        int maximum =  0;
        int count = 0;

        switch (check) {
            // -와 + 모두 있을때
            case 0:
                while(count < sum.length ) {
                    int count2 = count+1;
                    while(count2 < sum.length) {
                        if(sum[count2] - sum[count] > maximum){
                            maximum = sum[count2] - sum[count];
                        }
                        count2++;
                    }
                    count++;
                }
                return maximum;
            // +만 있을때 모든 합계 구하기
            // -만 있을 때 최솟값 찾기
            default:
                while(count < sum.length) {
                    if(sum[maximum] < sum[count]) {
                        maximum = count;
                    }
                    count++;
                }
                return sum[maximum];
        }
    }

    public static long maxSubarraySum(int arr[]){
        sum = new int[arr.length];

        sumArr(arr, sum);

        return checkPlusMinus(check);
    }
}