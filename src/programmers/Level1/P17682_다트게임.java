package programmers.Level1;

public class P17682_다트게임 {
    public static void main(String[] args) {
        String str1 = "1S2D*3T";
        String str2 = "1D2S#10S";
        String str3 = "1D2S0T";
        String str4 = "1S*2T*3S";
        String str5 = "1D#2S*3S";
        String str6 = "1T2D3D#";
        String str7 = "1D2S3T*";

        int ans1 = solution(str1);
        System.out.println(ans1);
        int ans2 = solution(str2);
        System.out.println(ans2);

    }
    
    static public int solution(String dartResult) {
        int idx = 0;
        int[] ans = new int[3];
        int answer = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {
                idx++;
                if (i + 1 < dartResult.length() && Character.isDigit(dartResult.charAt(i + 1))) {
                    i++;
                    ans[idx - 1] = 10;
                } else {
                    ans[idx - 1] = dartResult.charAt(i) - '0';
                }
            } else if (dartResult.charAt(i) == 'S') {
                ans[idx - 1] = (int) Math.pow(ans[idx - 1], 1);
            } else if (dartResult.charAt(i) == 'D') {
                ans[idx - 1] = (int) Math.pow(ans[idx - 1], 2);
            } else if (dartResult.charAt(i) == 'T') {
                ans[idx - 1] = (int) Math.pow(ans[idx - 1], 3);
            } else if (dartResult.charAt(i) == '*') {
                if (idx >= 2) {
                    ans[idx - 1] = ans[idx - 1] * 2;
                    ans[idx - 2] = ans[idx - 2] * 2;
                } else {
                    ans[idx - 1] = ans[idx - 1] * 2;
                }
            } else if (dartResult.charAt(i) == '#') {
                ans[idx - 1] = ans[idx - 1] * (-1);
            }
        }

        for (int i = 0; i < 3; i++) {
            answer += ans[i];
        }
        return answer;
    }
}
