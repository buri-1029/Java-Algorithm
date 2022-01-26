package programmers.Level2;

public class P12905_가장큰정사각형찾기 {

	public static void main(String[] args) {
		int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
		System.out.println(solution(board));

		int[][] board2 = {{0, 0, 1, 1}, {1, 1, 1, 1}};
		System.out.println(solution(board2));
	}

	private static int solution(int[][] board) {
		int answer = 0;
		int r = board.length;
		int c = board[0].length;

		int[][] dp = new int[r + 1][c + 1];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				dp[i + 1][j + 1] = board[i][j];
			}
		}

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (dp[i][j] != 0) {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}

		return answer * answer;
	}

}
