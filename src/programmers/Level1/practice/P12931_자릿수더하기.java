package programmers.Level1.practice;

public class P12931_자릿수더하기 {
    public static void main(String[] args) {
        int n = 123;
        int ans = solution(n);
    }

    private static int solution(int n) {
        int answer = 0;

        while(n != 0){
            answer += n%10;
            n /= 10;
        }

        return answer;
    }
}
