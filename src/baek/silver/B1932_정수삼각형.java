package baek.silver;

import java.util.Scanner;

public class B1932_정수삼각형 {

	static int[][] arr;
	static Integer[][] dp;
	static int N;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();

		arr = new int[N][N];
		dp = new Integer[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = arr[N - 1][i];
		}

		System.out.println(find(0, 0));

	}


	private static int find(int d, int i) {
		if (d == N - 1) {
			return dp[d][i];
		}

		if (dp[d][i] == null) {
			dp[d][i] =
				Math.max(find(d + 1, i), find(d + 1, i + 1)) + arr[d][i];
		}

		return dp[d][i];

	}
}
