package baek;

import java.util.Scanner;
/*
 *  점화식 : dp[n] = dp[n-2]*3 + dp[n-4]*2 + dp[n-6]*2 ... dp[0]*2 ;
 */
public class B2133_타일채우기 {
	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		dp = new int[N + 1];

		dp[0] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = 3 * dp[i - 2];
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
		}
		System.out.println(dp[N]);
	}
}
