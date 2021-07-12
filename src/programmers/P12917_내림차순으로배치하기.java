package programmers;

import java.util.Arrays;
import java.util.Collections;

public class P12917_내림차순으로배치하기 {
    public static void main(String[] args) {
        long n = 118372;
        long answer1 = solution1(n);
        System.out.println(answer1);

        String s = "Zbcdefg";
        String answer2 = solution2(s);
        System.out.println(answer2);
    }

    // 정수내림차순으로배치하기
    private static long solution1(long n) {
        long answer = 0;

        String[] tmp = String.valueOf(n).split("");
        Arrays.sort(tmp, Collections.reverseOrder());
        answer = Long.parseLong(String.join("", tmp));

       // String 배열 -> int 배열로 변환
//        int[] arr = new int[tmp.length];
//        for(int i = 0;i < tmp.length; i++){
//            arr[i] = Integer.parseInt(tmp[i]);
//        }
//
//        int[] arr = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();

        return answer;
    }

    // 문자열내림차순으로배치하기
    private static String solution2(String s) {
        String answer = "";

        String[] tmp = String.valueOf(s).split("");
        Arrays.sort(tmp, Collections.reverseOrder());
        answer = String.join("", tmp);

        return answer;
    }
}
