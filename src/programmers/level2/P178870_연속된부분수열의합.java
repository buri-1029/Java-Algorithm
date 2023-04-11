package programmers.level2;

import java.util.Arrays;

public class P178870_연속된부분수열의합 {

	public static void main(String[] args) {
		int[] sequence = {1, 1, 1, 2, 3, 4, 5};
		int k = 5;
		System.out.println(Arrays.toString(solution(sequence, k)));
	}

	public static int[] solution(int[] sequence, int k) {
		int len = sequence.length;
		int left = 0, right = len;
		int sum = 0;

		for (int l = 0, r = 0; l < len; l++) {
			while (r < len && sum < k) {
				sum += sequence[r++];
			}

			if (sum == k) {
				if ((right - left) > (r - l - 1)) {
					left = l;
					right = r - 1;
				}
			}

			sum -= sequence[l];
		}

		return new int[]{left, right};
	}
}
