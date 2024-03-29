package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class P12915_문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        String[] strings1 = {"sun", "bed", "car"};
        int n1 = 1;

        String[] strings2 = {"abce", "abcd", "cdx"};
        int n2 = 2;

        String[] answers1 = solution(strings1, n1);
        System.out.println(Arrays.toString(answers1));

        String[] answers2 = solution(strings2, n2);
        System.out.println(Arrays.toString(answers2));
    }

    private static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);

                if(c1 == c2){ // n 자리의 문자가 같으면 문자열 자체를 비교
                    return s1.compareTo(s2);
                } else return c1 - c2; // 아니면 해당 문자를 비교
            }
        });
        return strings;
    }
}
