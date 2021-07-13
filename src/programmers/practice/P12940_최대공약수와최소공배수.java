package programmers.practice;

import java.util.Arrays;

public class P12940_최대공약수와최소공배수 {
    public static void main(String[] args) {
        int x = 3, y = 12;
        int[] ans = solution(x, y);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solution(int x, int y) {
        int[] answer = new int[2];
        int z = x * y;

        while (y > 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }

        // 최대공약수
        answer[0] = x;
        // 최소공배수
        answer[1] = z/x;

        return answer;
    }
}
