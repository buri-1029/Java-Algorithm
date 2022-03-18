package programmers.level1;

public class P87389_나머지가1이되는수찾기 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 12;

        int ans1 = solution(n1);
        System.out.println(ans1);

        int ans2 = solution(n2);
        System.out.println(ans2);
    }

    private static int solution(int n) {
        int answer = n;

        for (int i = n - 1; i > 0; i--) {
            if (n % i == 1) {
                answer = Math.min(answer, i);
            }
        }

        return answer;
    }
}
