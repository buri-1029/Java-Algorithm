package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12936_줄서는방법 {

	public static void main(String[] args) {
		int n = 3;
		int k = 2;

		System.out.println(Arrays.toString(solution(n, k)));
	}

	public static int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();

		long tmp = 1;

		for (int i = 1; i <= n; i++) {
			list.add(i);
			tmp *= i;
		}

		k--;
		int idx = 0;

		while (idx < n) {
			tmp /= n - idx;
			answer[idx++] = list.remove((int) (k / tmp));
			k %= tmp;
		}

		return answer;
	}

}
