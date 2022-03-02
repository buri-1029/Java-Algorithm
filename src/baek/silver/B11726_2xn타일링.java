package baek.silver;

import java.util.Scanner;

public class B11726_2xn타일링 {

	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N + 1];
		System.out.println(tileFill(N));

		/*
		 * dp[1] = 1;
		 * dp[2] = 2;
		 *
		 * for(int i=3;i<=N;++i) {
		 * 		dp[i] = (dp[i-1]+ dp[i-2]) % 10007;
		 * }
		 *
		 * System.out.println(dp[N]);
		 */
	}

	private static int tileFill(int n) {
		// TODO Auto-generated method stub
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = (tileFill(n - 1) + tileFill(n - 2)) % 10007;
	}
}
