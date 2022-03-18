package programmers.courses;

import java.util.HashMap;
import java.util.Map;

public class P96081_포켓몬 {

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
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		return Math.min(nums.length / 2, map.size());
	}

}
