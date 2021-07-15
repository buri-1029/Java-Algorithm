package programmers;

public class P81301_숫자문자열과영단어 {
    public static void main(String[] args) {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        int ans1 = solution(s1);
        System.out.println(ans1);

        int ans2 = solution(s2);
        System.out.println(ans2);

        int ans3 = solution(s3);
        System.out.println(ans3);

        int ans4 = solution(s4);
        System.out.println(ans4);
    }

    private static int solution(String s) {
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        if(s.matches("[+-]?\\d*(\\.\\d+)?"))
            return Integer.parseInt(s);

        for(int i = 0; i < number.length; i++){
            s = s.replaceAll(number[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
