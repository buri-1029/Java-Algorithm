package programmers;

import java.util.Arrays;

public class P12982_예산 {
    public static void main(String[] args) {
        int[] d1 = {1, 3, 2, 5, 4};
        int budget1 = 9;
        int ans1 = solution(d1, budget1);
        System.out.println(ans1);

        int[] d2 = {2, 2, 3, 3};
        int budget2 = 10;
        int ans2 = solution(d2, budget2);
        System.out.println(ans2);
    }

    /*
     *  "최대" 몇 개까지 지원할 수 있는가?
     *   -> 적은 금액으로 많이 채우면 된다.
     */

    private static int solution(int[] d, int budget) {
        int sum = 0, answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++){
            if(sum + d[i] > budget) break;
            sum+=d[i];
            answer++;
        }
        return answer;
    }

}
