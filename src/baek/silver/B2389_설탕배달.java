package baek.silver;

import java.util.Scanner;

public class B2389_설탕배달 {

	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		dp = new int[N + 1];
		dp[3] = 1;
		if (N > 4) {
			dp[5] = 1;
		}
		if (N > 5) {
			dp[6] = 2;
		}

		for (int i = 8; i <= N; i++) {
			dp[i] = dp[i - 3] + 1;
			if (i % 5 == 0) {
				dp[i] = i / 5;
			}
		}
		/*
		dp[3] = 1;
		if (N > 4) dp[5] = 1;

		for (int i = 6; i <= N; i++) {
			if (dp[i - 3] > 0 && dp[i - 5] > 0)
				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
			else if (dp[i - 3] > 0)
				dp[i] = dp[i - 3] + 1;
			else if (dp[i - 5] > 0)
				dp[i] = dp[i - 5] + 1;
		}
		*/
		if (dp[N] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}
}
