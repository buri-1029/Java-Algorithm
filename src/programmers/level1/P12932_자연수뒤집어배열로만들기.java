package programmers.level1;

import java.util.Arrays;

public class P12932_자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        long n1 = 12345;
        int[] answer1 = solution(n1);
        System.out.println(Arrays.toString(answer1)); // [5,4,3,2,1]

        long n2 = 479231;
        int[] answer2 = solution(n2);
        System.out.println(Arrays.toString(answer2)); // [1,3,2,9,7,4]
    }

    private static int[] solution(long n) {
        String[] arr = String.valueOf(n).split("");
        int[] answer = new int[arr.length];

        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            answer[j] = Integer.parseInt(arr[i]);
        }

        return answer;
    }
}
