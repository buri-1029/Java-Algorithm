package programmers.Level1;

import java.util.Arrays;
import java.util.Collections;

public class P12917_문자열내림차순으로배치하기 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String answer1 = solution(s);
        System.out.println(answer1);
    }

    private static String solution(String s) {
        String answer = "";

        String[] tmp = String.valueOf(s).split("");
        Arrays.sort(tmp);

        for(int i = tmp.length - 1; i >= 0; i--){
            answer += tmp[i];
        }

//        Arrays.sort(tmp, Collections.reverseOrder());
//        answer = String.join("", tmp);
        return answer;
    }

}
