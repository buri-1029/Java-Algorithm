package programmers.level1;

public class P70128_내젹 {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};
        int[] b1 = {-3, -1, 0, 2};
        int ans1 = solution(a1, b1);
        System.out.println(ans1);

        int[] a2 = {-1, 0, 1};
        int[] b2 = {1, 0, -1};
        int ans2 = solution(a2, b2);
        System.out.println(ans2);
    }

    private static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++){
            answer += a[i] * b[i];
        }
        return answer;
    }
}
