package programmers.Level1.practice;

import java.util.Arrays;

public class P12935_제일작은수제거하기 {
    public static void main(String[] args) {
        int[] arr1 = {4,3,2,1};
        int[] arr2 = {10};

        int[] res1 = solution(arr1);
        int[] res2 = solution(arr2);

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }
    private static int[] solution(int[] arr) {
        int[] answer1 = new int[arr.length - 1];
        int min = arr[0]; // 작은 수 임의 설정

        // 빈 배열이거나 정수가 1개일 때
        if (arr.length <= 1) {
            // 배열에 -1을 채워 리턴
            int[] answer2 = {-1};
            return answer2;
        }

        // 가장 작은 수 찾기
        for (int n : arr) {
            if (n < min) {
                min = n;
            }
        }

        // 가장 작은 수를 제거한 배열을 리턴
        int idx = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != min){
                answer1[idx++] = arr[i];
            }
        }

        return answer1;
    }
}
