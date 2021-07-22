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
        // dartResult == "점수|보너스|[옵션]"
        int cur = 0; // 현재 몇 번째 기회인지
        int[] ans = new int[3]; // 3번의 기회

        for (int i = 0; i < dartResult.length(); i++) {
            // 숫자인지 판별 후
            if (Character.isDigit(dartResult.charAt(i))) {
                cur++;  // 숫자이면 기회 증가
                // 그 다음 인덱스도 숫자이면 10이기 때문에 인덱스 증가
                if (Character.isDigit(dartResult.charAt(i + 1))) {
                    i++;
                    ans[cur - 1] = 10;
                } else {
                    ans[cur - 1] = dartResult.charAt(i) - '0';
                }
            // S, D, T 일 때 해당 기회의 점수 제곱으로 계산
            } else if (dartResult.charAt(i) == 'S') {
                ans[cur - 1] = (int) Math.pow(ans[cur - 1], 1);
            } else if (dartResult.charAt(i) == 'D') {
                ans[cur - 1] = (int) Math.pow(ans[cur - 1], 2);
            } else if (dartResult.charAt(i) == 'T') {
                ans[cur - 1] = (int) Math.pow(ans[cur - 1], 3);
            // * 일 때
            } else if (dartResult.charAt(i) == '*') {
                // 중첩되기 때문에 전 기회의 점수 2배로 계산
                if (cur == 3 || cur == 2) {
                    ans[cur - 2] = ans[cur - 2] * 2;
                }
                // 해당 기회의 점수에서도 2배로 계산
                ans[cur - 1] = ans[cur - 1] * 2;
            // # 일 때
            } else if (dartResult.charAt(i) == '#') {
                // 해당 기회의 점수 마이너스로
                ans[cur - 1] = ans[cur - 1] * (-1);
            }
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += ans[i];
        }
        return answer;
    }
}
