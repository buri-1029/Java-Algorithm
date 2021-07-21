package programmers.Level1;

import java.util.Arrays;

public class P12933_정수내림차순으로배치하기 {
    public static void main(String[] args) {
        long n = 118372;
        long answer = solution(n);
        System.out.println(answer);

    }

    private static long solution(long n) {
        long answer = 0;
        String[] tmp = String.valueOf(n).split("");
        Arrays.sort(tmp);
        String str = "";
        for(int i = tmp.length - 1; i >=0 ; i--){
            str += tmp[i];
        }
        answer = Long.parseLong(str);
        return answer;
    }
}
