package programmers.Level1;

public class P77884_약수의개수와덧셈 {
    public static void main(String[] args) {
        int left1 = 13, right1 = 17;
        int left2 = 24, right2 = 27;

        int ans1 = solution(left1, right1);
        System.out.println(ans1);

        int ans2 = solution(left2, right2);
        System.out.println(ans2);
    }

    private static int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int cnt = 0;
            for(int j = 1; j <= i; j++){
                if(i%j == 0) cnt++;
            }
            if(cnt%2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}
