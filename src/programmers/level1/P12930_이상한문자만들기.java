package programmers.level1;

public class P12930_이상한문자만들기 {
    /*
     *   각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수
     */
    public static void main(String[] args) {
        String s = "try hello world";
        String ans = solution(s);
        System.out.println(ans);
    }

    private static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        int idx = 0;
        for(String str : arr){
            if(str.equals(" ")) {
                idx = 0;
                answer += str;
            }
            else if(idx++%2 == 0){
                answer+= str.toUpperCase();
            }else{
                answer+= str.toLowerCase();
            }
        }
        return answer;
    }
}
