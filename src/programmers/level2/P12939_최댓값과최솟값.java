package programmers.level2;

public class P12939_최댓값과최솟값 {

	public static void main(String[] args) {
		String s1 = "1 2 3 4";
		String s2 = "-1 -2 -3 -4";
		String s3 = "-1 -1";

		String ans1 = solution(s1);
		System.out.println(ans1);

		String ans2 = solution(s2);
		System.out.println(ans2);

		String ans3 = solution(s3);
		System.out.println(ans3);

	}

	private static String solution(String s) {
		int max, min;
		String[] nums = s.split(" ");
		min = max = Integer.parseInt(nums[0]);
		for (String num : nums) {
			max = Integer.parseInt(num) > max ? Integer.parseInt(num) : max;
			min = Integer.parseInt(num) < min ? Integer.parseInt(num) : min;
		}
		return min + " " + max;
	}
}
