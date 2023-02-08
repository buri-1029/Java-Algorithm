package baek.silver;

import java.util.Scanner;

public class B2293_동전1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int k = scan.nextInt(); // 가치의 합

		int[] arr = new int[n + 1];
		int[] dp = new int[10001];

		for (int i = 1; i <= n; i++) {
			arr[i] = scan.nextInt();
		}

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = arr[i]; j <= k; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}

		System.out.println(dp[k]);
	}
}
