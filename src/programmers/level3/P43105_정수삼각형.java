package programmers.level3;

public class P43105_정수삼각형 {

	static Integer[][] dp;
	static int N;

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
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
