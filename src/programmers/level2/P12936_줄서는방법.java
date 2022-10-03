package programmers.level2;

import java.util.Arrays;

public class P12936_줄서는방법 {

	static int num, cnt = 0;
	static int[] arr, select, answer;
	static boolean[] visit;

	public static void main(String[] args) {
		int n = 3;
		int k = 2;

		System.out.println(Arrays.toString(solution(n, k)));
	}

	public static int[] solution(int n, long k) {
		num = n;

		arr = new int[n];
		select = new int[n];
		answer = new int[n];
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		permutation(0, k);

		return answer;
	}

	private static void permutation(int n, long k) {
		if (n == select.length) {
			cnt++;

			if (cnt == k) {
				answer = Arrays.copyOf(select, select.length);
			}

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[n] = arr[i];
				permutation(n + 1, k);
				visit[i] = false;
			}
		}
	}
}
