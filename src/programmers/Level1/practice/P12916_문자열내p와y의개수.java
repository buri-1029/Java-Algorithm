package programmers.Level1.practice;

public class P12916_문자열내p와y의개수 {
    public static void main(String[] args) {
        String s1 = "pPoooyY";
        String s2 = "Pyy";
        
        boolean ans1 = solution(s1);
        boolean ans2 = solution(s2);

        System.out.println(ans1);
        System.out.println(ans2);
    }

    private static boolean solution(String s) {
        boolean answer = true;

        s = s.toUpperCase();

        long pcnt = 0, ycnt = 0;

        pcnt = s.chars().filter(c -> c == 'P').count();
        ycnt = s.chars().filter(c -> c == 'Y').count();

        // for(int i = 0; i < s.length(); i++){
        //     if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
        //         pcnt++;
        //     }else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
        //         ycnt++;
        //     }
        // }

        if(pcnt != ycnt) answer = false;
        return answer;
    }
}
