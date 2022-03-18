package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class P77484_로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};

        int[] ans1 = solution(lottos1, win_nums1);
        System.out.println(Arrays.toString(ans1));

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};

        int[] ans2 = solution(lottos2, win_nums2);
        System.out.println(Arrays.toString(ans2));

        int[] lottos3 = {21, 5, 31, 40, 1, 7};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};

        int[] ans3 = solution(lottos3, win_nums3);
        System.out.println(Arrays.toString(ans3));
    }

    private static int[] solution(int[] lottos, int[] win_nums) {
        // 인덱스 : 6 - 일치하는 번호 개수, 원소 : 순위
        int[] ranking = {1, 2, 3, 4, 5, 6, 6};

        // max : 일치하는 번호 개수(+ 0의 개수), min : 일치하지 않는 번호 개수
        int max = 0, min = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int n : win_nums) list.add(n);

        // max 와 min 구하기
        for(int lotto : lottos){
            if(list.contains(lotto) || lotto == 0) max++;
            if(!list.contains(lotto)) min++;
        }

        int[] answer = new int[2];
        answer[0] = ranking[6 - max];
        answer[1] = ranking[min];

        return answer;
    }
}
