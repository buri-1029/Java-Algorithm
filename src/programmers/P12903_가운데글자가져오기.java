package programmers;

public class P12903_가운데글자가져오기 {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "qwer";

        String answer1 = solution(s1);
        String answer2 = solution(s2);

        System.out.println(answer1);
        System.out.println(answer2);
    }

    private static String solution(String s) {
        String answer = "";
        if(s.length()%2 == 0){ // 길이가 짝수일 때
            answer = s.substring(s.length()/2 - 1,s.length()/2 + 1);
        }else{ // 길이가 홀수일 때
            answer = s.substring(s.length()/2,s.length()/2 + 1);
        }
        return answer;
    }
}
