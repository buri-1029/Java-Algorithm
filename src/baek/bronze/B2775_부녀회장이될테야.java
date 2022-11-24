package baek.bronze;

import java.util.Scanner;

public class B2775_부녀회장이될테야 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			int[][] dp = new int[15][15];

			for (int i = 1; i < 15; i++) {
				dp[0][i] = i;
			}

			for (int i = 1; i < 15; i++) {
				dp[i][1] = 1;
			}

			for (int i = 1; i < 15; i++) {
				for (int j = 2; j < 15; j++) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}

			System.out.println(dp[k][n]);
		}
	}
}
