package programmers.Level1;

public class P76501_음양더하기 {
    public static void main(String[] args) {
        int[] absolutes1	= {4, 7, 12};
        boolean[] signs1 = {true, false, true};
        int ans1 = solution(absolutes1, signs1);
        System.out.println(ans1); // 9

        int[] absolutes2	= {1, 2, 3};
        boolean[] signs2 = {false, false, true};
        int ans2 = solution(absolutes2, signs2);
        System.out.println(ans2); // 0
    }

    private static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            answer += (signs[i] ? absolutes[i] : absolutes[i] * (-1));
        }
        return answer;
    }
}
