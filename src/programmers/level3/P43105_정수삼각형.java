package programmers.level3;

public class P43105_정수삼각형 {

	static Integer[][] dp;
	static int N;

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution1(triangle));
		System.out.println(solution2(triangle));
	}

	public static int solution2(int[][] triangle) {
		int answer = 0;
		int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
		dp[0][0] = triangle[0][0];

		for (int i = 1; i < triangle.length; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];

			for (int j = 1; j <= i - 1; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
				answer = Math.max(answer, dp[i][j]);
			}
		}

		return answer;
	}

	public static int solution1(int[][] triangle) {
		N = triangle[triangle.length - 1].length;
		dp = new Integer[N][N];

		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = triangle[N - 1][i];
		}

		return find(triangle, 0, 0);
	}

	private static int find(int[][] triangle, int d, int i) {
		if (d == N - 1) {
			return dp[d][i];
		}

		if (dp[d][i] == null) {
			dp[d][i] =
				Math.max(find(triangle, d + 1, i), find(triangle, d + 1, i + 1)) + triangle[d][i];
		}

		return dp[d][i];

	}
}
