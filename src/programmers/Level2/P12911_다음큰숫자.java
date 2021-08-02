package programmers.Level2;

public class P12911_다음큰숫자 {
    public static void main(String[] args) {
        int n1 = 78;
        System.out.println(solution(n1));

        int n2 = 15;
        System.out.println(solution(n2));
    }

    private static int solution(int n) {
        int answer = 0;
        int cnt = count(n); // 1의 개수
        int tmp = n + 1, tmpCnt = 0; // 다음 큰 숫자와 그 숫자의 1의 개수
        while(tmpCnt != cnt){ // cnt 와 tmpCnt가 같을 때까지
            tmpCnt = count(tmp++); // n보다 큰 수 찾기
        }
        answer = tmp - 1;
        return answer;
    }

    // 2진수로 변환 후 1의 개수 반환
    private static int count(int n) {
        int cnt = 0;
        while(n > 0){
            if(n % 2 < 10){
                if(n%2 == 1) {
                    cnt++;
                }
                n /= 2;
            }
        }
        return cnt;
    }
}
