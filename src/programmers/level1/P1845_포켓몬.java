package programmers.level1;

import java.util.ArrayList;

public class P1845_포켓몬 {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};

        int ans1 = solution(nums1);
        System.out.println(ans1);

        int ans2 = solution(nums2);
        System.out.println(ans2);

        int ans3 = solution(nums3);
        System.out.println(ans3);
    }

    private static int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : nums){
            if(!list.contains(n))
                list.add(n);
        }
        if(nums.length/2 < list.size())
            answer = nums.length/2;
        else
            answer = list.size();
        return answer;
    }
}
