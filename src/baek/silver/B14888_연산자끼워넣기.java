package baek.silver;

import java.util.Scanner;

/**
 * 다음에 백트래킹 이용해서 풀어보기
 */
public class B14888_연산자끼워넣기 {

	static int N;
	static int[] nums;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();

		nums = new int[N];
		int[] calc = new int[4];

		for (int i = 0; i < N; i++) {
			nums[i] = scan.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			calc[i] = scan.nextInt();
		}

		calculate(1, nums[0], calc[0], calc[1], calc[2], calc[3]);

		System.out.println(max);
		System.out.println(min);
	}

	private static void calculate(int idx, int sum, int c1, int c2, int c3, int c4) {
		if (idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}

		if (c1 > 0) {
			calculate(idx + 1, sum + nums[idx], c1 - 1, c2, c3, c4);
		}

		if (c2 > 0) {
			calculate(idx + 1, sum - nums[idx], c1, c2 - 1, c3, c4);
		}

		if (c3 > 0) {
			calculate(idx + 1, sum * nums[idx], c1, c2, c3 - 1, c4);
		}

		if (c4 > 0) {
			calculate(idx + 1, sum / nums[idx], c1, c2, c3, c4 - 1);
		}
	}
}
