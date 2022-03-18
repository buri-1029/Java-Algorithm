package programmers.level1;

public class P12943_콜라츠추측 {
    public static void main(String[] args) {
        int n = 626331;
        int ans = solution(n);
        System.out.println(ans);
    }
    public static int solution(int num) {
        int answer = -1, cnt = 0;
        while(true){
            if(num == 1 || cnt >= 483) break;

            if(num%2 == 0) num = num/2;
            else num = num*3 + 1;

            cnt++;
        }

        if(cnt < 483) answer = cnt;

        return answer;
    }
}