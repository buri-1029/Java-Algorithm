package baek.silver;

import java.util.Scanner;

public class B9461_파도반수열 {

	public static long[] dp = new long[101];

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 101; i++) {
			dp[i] = -1;
		}

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		int T = scan.nextInt();

		while (T-- > 0) {
			int N = scan.nextInt();
			System.out.println(padovan(N));
		}

	}

	public static long padovan(int N) {
		if (dp[N] == -1) {
			dp[N] = padovan(N - 2) + padovan(N - 3);
		}
		return dp[N];
	}

}
