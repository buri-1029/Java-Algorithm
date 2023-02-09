package baek.silver;

import java.util.Scanner;

public class B2294_동전2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int k = scan.nextInt();

		int[] arr = new int[n + 1];
		int[] dp = new int[k + 1];

		for (int i = 1; i <= k; i++) {
			dp[i] = 100001;
		}

		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			arr[i] = scan.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = arr[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
			}
		}

		if (dp[k] == 100001) {
			dp[k] = -1;
		}

		System.out.println(dp[k]);
	}
}
