package programmers.Level1;

public class P12926_시저암호 {
    public static void main(String[] args) {
        String s1 = "AB";
        int n1 = 1;
        String ans1 = solution(s1, n1);
        System.out.println(ans1);

        String s2 = "a B z";
        int n2 = 4;
        String ans2 = solution(s2, n2);
        System.out.println(ans2);
    }

    private static String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                answer += " ";
            }else if(65 <= (int)s.charAt(i) && (int)s.charAt(i) <= 90) { // 대문자
                char ch = (char) (((int)s.charAt(i) + n - 65) % 26 + 65);
                answer += Character.toString(ch);
            }else{ // 소문자
                char ch = (char) (((int)s.charAt(i) + n - 97) % 26 + 97);
                answer += Character.toString(ch);
            }
        }
        return answer;
    }
}
