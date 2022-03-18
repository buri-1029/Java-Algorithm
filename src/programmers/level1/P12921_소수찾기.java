package programmers.level1;

public class P12921_소수찾기 {
    public static void main(String[] args) {
        int n = 10;
        int ans = solution(n);
        System.out.println(ans);
    }

    private static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(prime(i))
                answer++;
        }
        return answer;
    }

    private static boolean prime(int n){
        if(n < 2){
            return false;
        }

        // 2부터 해당 숫자까지 모든 숫자로 나눠볼 필요 없이,
        // 해당 숫자의 제곱근까지만 구하면 된다.
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }
}
